package com.demo.utils;

import org.apache.commons.lang3.StringUtils;
import org.dom4j.Document;
import org.dom4j.DocumentException;
import org.dom4j.Element;
import org.dom4j.io.SAXReader;

import java.io.InputStream;
import java.lang.reflect.Field;
import java.util.List;

/**
 * 解析XML，并且使用反射机制实例化对象
 */
public class ClassPathXmlApplicationContext {

    /**
     * 读取xml地址
     */
    private String xmlPath;

    public ClassPathXmlApplicationContext(String xmlPath) {
        this.xmlPath = xmlPath;
    }


    /**
     * 获取对象
     * @param beanId
     * @return
     * @throws Exception
     */
    public Object getBean(String beanId) throws Exception{
        if (StringUtils.isEmpty(beanId)){
            throw new  Exception("beanid不能为空");
        }

        //解析XML
        List<Element> readerXml = readerXml();
        if (readerXml==null||readerXml.isEmpty()){
            throw new  Exception("readerXml不能为空");
        }

        //2使用方法参数beanid查找
        return findByElementClass(readerXml,beanId);
    }


    /**
     * 使用方法参数beanid查找配置文件中bean节点的id信息是否一致
     * @param readerXml
     * @param beanId
     * @return
     */
    public Object findByElementClass(List<Element> readerXml,String beanId) throws ClassNotFoundException, IllegalAccessException, InstantiationException, NoSuchFieldException {
        for (Element ele : readerXml){

            String id = ele.attributeValue("id");
            if (StringUtils.isEmpty(id)){
                continue;
            }

            if(!id.equals(beanId)){
                continue;
            }
            String beanClass = ele.attributeValue("class");

            //通过反射机制实例化对象
            Class<?> clazz = Class.forName(beanClass);
            Object instance = clazz.newInstance();
            List<Element> elementList = ele.elements();
            for (Element element : elementList) {
                String name  = element.attributeValue("name");
                String value = element.attributeValue("value");
                Field declaredField = clazz.getDeclaredField(name);

                declaredField.setAccessible(true);

                String type = declaredField.getGenericType().getTypeName();
                if(type.equals("java.lang.Integer")||type.equals("int")){
                    declaredField.setInt(instance,Integer.valueOf(value));
                }else if(type.equals("java.lang.Double")||type.equals("double")){
                    declaredField.setDouble(instance,Double.parseDouble(value));
                }else if(type.equals("java.lang.Boolean")||type.equals("boolean")){
                    declaredField.setBoolean(instance,Boolean.parseBoolean(value));
                }else if(type.equals("java.lang.Short")||type.equals("short")){
                    declaredField.setShort(instance,Short.parseShort(value));
                }else{
                    declaredField.set(instance,value);
                }



            }
            return instance;
        }
        return null;
    }


    /**
     * 解析xml
     * @return
     * @throws DocumentException
     */
    public List<Element> readerXml() throws DocumentException {
        //解析xml节点信息
        SAXReader saxReader = new SAXReader();
        Document document = saxReader.read(getResourceAsStream(xmlPath));
        //读取根节点信息，
        Element rootElement = document.getRootElement();
        // 读取子节点 返回泛型集合
        List<Element> elements = rootElement.elements();
        return elements;
    }


    /**
     * 获取当前上下文路径
     * @param xmlPath
     * @return
     */
    public InputStream getResourceAsStream(String xmlPath){
        InputStream inputStream = this.getClass().getClassLoader().getResourceAsStream(xmlPath);
        return inputStream;
    }

}
