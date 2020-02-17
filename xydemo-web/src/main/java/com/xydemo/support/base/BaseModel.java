package com.xydemo.support.base;

import io.swagger.annotations.ApiModelProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Column;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import java.io.Serializable;
import java.util.Date;

/**
 * 模型基础
 * @param <T>
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
public class BaseModel<T> implements Serializable {

    @ApiModelProperty(value = "主键")
    @Id
    @Column(name="id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private T id;


    @ApiModelProperty(value = "创建时间")
    @Column(name="create_date")
    private Date createDate;

    @ApiModelProperty(value = "更新时间")
    @Column(name="update_date")
    private Date updateDate;

    @ApiModelProperty(value = "是否被删除")
    @Column(name="is_delete")
    private Boolean isDelete;

    @ApiModelProperty(value = "备注")
    @Column(name="remark")
    private String remark;

}
