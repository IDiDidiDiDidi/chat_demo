package com.liudi.entity;

import com.baomidou.mybatisplus.annotation.TableName;
import com.liudi.base.InfoEntity;
import lombok.Data;

@TableName("sys_user")
@Data
public class SysUser extends InfoEntity {
    private String username;
    private String password;
    private String nickname;
    private String email;
    private String realname;
    private Integer gender;
    private String birthday;
    private String country;
    private String province;
    private String city;
    private String region;
    private String address;
    private String telephone;
    private String mobile;
    private String site;
    private String postalCode;
    private String theme;
    private String noteWord;
    private Integer role;
    private Integer auth;
    private Integer belongId;
    private Integer userHeader;
    private String status;
    private Integer headerPhoto;
    private Integer subUser;
    private String provinceId;
    private String cityId;
    private String regionId;
    private Integer authorizeStep;
    private String authOpinion;
    private String creditCode;
    private Integer isCertificateReady;
    private String codeCorporate;
    private String logo;
    private String source;
    private Integer casUserId;
    private Integer parentCasUserId;
    private String companyId;
    private String updateBy;
    private String systemId;
    private String deptId;
    private Boolean isMain;
    private String isSignin;
}
