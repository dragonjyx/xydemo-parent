package com.dbaccess.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.Date;

/**
 * 角色表
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "t_role")
public class JPARole {

    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "create_date")
    private Date createTime;

    @Column(name = "update_date")
    private Date updateTime;

    @Column(name = "is_delete")
    private Boolean isDelete;

    @Column(name = "remark")
    private String remark;

    @Column(name = "role")
    private String roleId;

    @Column(name = "appid")
    private String appId;

    @Column(name = "name")
    private String name;

    @Column(name = "description")
    private String description;

}
