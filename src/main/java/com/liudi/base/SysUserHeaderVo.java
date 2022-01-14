//
// Source code recreated from a .class file by IntelliJ IDEA
// (powered by FernFlower decompiler)
//

package com.liudi.base;

import java.io.Serializable;

public class SysUserHeaderVo implements Serializable {
    private String baseId;
    private String username;
    private String realname;
    private String mobile;

    public SysUserHeaderVo() {
    }

    public String getBaseId() {
        return this.baseId;
    }

    public String getUsername() {
        return this.username;
    }

    public String getRealname() {
        return this.realname;
    }

    public String getMobile() {
        return this.mobile;
    }

    public void setBaseId(String baseId) {
        this.baseId = baseId;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public void setRealname(String realname) {
        this.realname = realname;
    }

    public void setMobile(String mobile) {
        this.mobile = mobile;
    }

    public boolean equals(Object o) {
        if (o == this) {
            return true;
        } else if (!(o instanceof SysUserHeaderVo)) {
            return false;
        } else {
            SysUserHeaderVo other = (SysUserHeaderVo)o;
            if (!other.canEqual(this)) {
                return false;
            } else {
                label59: {
                    Object this$baseId = this.getBaseId();
                    Object other$baseId = other.getBaseId();
                    if (this$baseId == null) {
                        if (other$baseId == null) {
                            break label59;
                        }
                    } else if (this$baseId.equals(other$baseId)) {
                        break label59;
                    }

                    return false;
                }

                Object this$username = this.getUsername();
                Object other$username = other.getUsername();
                if (this$username == null) {
                    if (other$username != null) {
                        return false;
                    }
                } else if (!this$username.equals(other$username)) {
                    return false;
                }

                Object this$realname = this.getRealname();
                Object other$realname = other.getRealname();
                if (this$realname == null) {
                    if (other$realname != null) {
                        return false;
                    }
                } else if (!this$realname.equals(other$realname)) {
                    return false;
                }

                Object this$mobile = this.getMobile();
                Object other$mobile = other.getMobile();
                if (this$mobile == null) {
                    if (other$mobile != null) {
                        return false;
                    }
                } else if (!this$mobile.equals(other$mobile)) {
                    return false;
                }

                return true;
            }
        }
    }

    protected boolean canEqual(Object other) {
        return other instanceof SysUserHeaderVo;
    }


//    public int hashCode() {
//        int PRIME = true;
//        int result = 1;
//        Object $baseId = this.getBaseId();
//        int result = result * 59 + ($baseId == null ? 43 : $baseId.hashCode());
//        Object $username = this.getUsername();
//        result = result * 59 + ($username == null ? 43 : $username.hashCode());
//        Object $realname = this.getRealname();
//        result = result * 59 + ($realname == null ? 43 : $realname.hashCode());
//        Object $mobile = this.getMobile();
//        result = result * 59 + ($mobile == null ? 43 : $mobile.hashCode());
//        return result;
//    }

    public String toString() {
        return "SysUserHeaderVo(baseId=" + this.getBaseId() + ", username=" + this.getUsername() + ", realname=" + this.getRealname() + ", mobile=" + this.getMobile() + ")";
    }
}
