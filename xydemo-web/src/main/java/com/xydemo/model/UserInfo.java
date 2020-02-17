package com.xydemo.model;

import com.xydemo.support.base.BaseModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Column;
import javax.persistence.Table;
import java.util.Date;

/**
 * 用户信息
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "t_user_info")
public class UserInfo extends BaseModel<Long> {

    private static final long serialVersionUID = -637537728464815966L;

    @ApiModelProperty(value = "用户UID")
    @Column(name="user_id")
    private String userId;

    @ApiModelProperty(value = "用户密码key")
    @Column(name="ukey")
    private String ukey;

    @ApiModelProperty(value = "用户密码")
    @Column(name="password")
    private String password;

    @ApiModelProperty(value = "邮箱")
    @Column(name="email")
    private String email;

    @ApiModelProperty(value = "手机号码")
    @Column(name="mobile")
    private String mobile;

    @ApiModelProperty(value = "登录名称")
    @Column(name="login_name")
    private String loginName;

    @ApiModelProperty(value = "昵称")
    @Column(name="nickname")
    private String nickname;

    @ApiModelProperty(value = "真实姓名")
    @Column(name="true_name")
    private String trueName;

    @ApiModelProperty(value = "性别 0:男 1:女 2:未知")
    @Column(name="gender")
    private Integer gender;

    @ApiModelProperty(value = "用户身份证号码")
    @Column(name="id_num")
    private String idNum;

    @ApiModelProperty(value = "头像")
    @Column(name="avatar")
    private String avatar;

    @ApiModelProperty(value = "unionId 公众平台ID")
    @Column(name="union_id")
    private String unionId;

    @ApiModelProperty(value = "出生日期")
    @Column(name="birthday")
    private String birthday;

    @ApiModelProperty(value = "注册IP")
    @Column(name="register_ip")
    private String registerIp;

    @ApiModelProperty(value = "注册时间")
    @Column(name="register_date")
    private Date registerDate;

    @ApiModelProperty(value = "登录IP")
    @Column(name="login_ip")
    private String loginIp;

    @ApiModelProperty(value = "登录时间")
    @Column(name="login_date")
    private Date loginDate;

    @ApiModelProperty(value = "登录次数")
    @Column(name="login_times")
    private Integer loginTimes;

    @ApiModelProperty(value = "登录错误次数")
    @Column(name="login_error_times")
    private Integer loginErrorTimes;

    @ApiModelProperty(value = "是否被锁住")
    @Column(name="locked")
    private Boolean locked;


}