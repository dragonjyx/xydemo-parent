package com.xydemo.dao.commom.basic;

import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import java.io.Serializable;

/**
 * @description: 实体基类
 * @author: DRAGON-Yeah
 * @date: 2019/8/11 0:12
 */
public class BaseModel<T> implements Serializable {

    private static final long serialVersionUID = -7616956306533419463L;

    /**
     * id自增组建
     */
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private T id;


}
