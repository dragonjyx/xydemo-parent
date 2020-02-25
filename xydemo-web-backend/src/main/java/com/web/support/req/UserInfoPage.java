package com.example.validate.request;

import io.swagger.annotations.ApiModelProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.validator.constraints.Range;

import javax.validation.constraints.Min;
import java.io.Serializable;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class UserInfoPage implements Serializable {


    private static final long serialVersionUID = 35592447724246615L;


    @ApiModelProperty(value = "用户名",required = true)
    private String name;


    @Range(min=10,max = 50)
    @ApiModelProperty(value = "页面大小",required = true)
    private Integer pageSize;


    @Min(1)
    @ApiModelProperty(value = "当前页面",required = true)
    private Long currentPage;




}
