package com.xydemo.dao.commom.basic;

import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.validation.constraints.NotNull;
import java.io.Serializable;

/**
 * @description: 实体基类
 * @athoor: DRAGON-Yeah
 * @date: 2019/8/11 0:12
 */
public class BaseModel<T> implements Serializable {

    private static final long serialVersionUID = -7616956306533419463L;

    @NotNull(groups = Update.class,message = "id不能为空")
    @Id
    @GeneratedValue( strategy = GenerationType.IDENTITY, generator = "select replace(uuid(),'-','') from dual" )
    private T id; // 主键

}
