//
// Source code recreated from a .class file by IntelliJ IDEA
// (powered by FernFlower decompiler)
//

package com.liudi.base;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;

import java.io.Serializable;

public class BaseEntity implements Serializable {
    private static final long serialVersionUID = -6651212609692684267L;
    @TableId(
        type = IdType.ASSIGN_UUID
    )
    private String baseId;

    public BaseEntity() {
    }

    public String getBaseId() {
        return this.baseId;
    }

    public void setBaseId(String baseId) {
        this.baseId = baseId;
    }

    public boolean equals(Object o) {
        if (o == this) {
            return true;
        } else if (!(o instanceof BaseEntity)) {
            return false;
        } else {
            BaseEntity other = (BaseEntity)o;
            if (!other.canEqual(this)) {
                return false;
            } else {
                Object this$baseId = this.getBaseId();
                Object other$baseId = other.getBaseId();
                if (this$baseId == null) {
                    if (other$baseId != null) {
                        return false;
                    }
                } else if (!this$baseId.equals(other$baseId)) {
                    return false;
                }

                return true;
            }
        }
    }

    protected boolean canEqual(Object other) {
        return other instanceof BaseEntity;
    }

//    public int hashCode() {
//        int PRIME = true;
//        int result = 1;
//        Object $baseId = this.getBaseId();
//        int result = result * 59 + ($baseId == null ? 43 : $baseId.hashCode());
//        return result;
//    }

    public String toString() {
        return "BaseEntity(baseId=" + this.getBaseId() + ")";
    }
}
