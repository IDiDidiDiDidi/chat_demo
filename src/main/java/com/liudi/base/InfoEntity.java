//
// Source code recreated from a .class file by IntelliJ IDEA
// (powered by FernFlower decompiler)
//

package com.liudi.base;

import com.baomidou.mybatisplus.annotation.FieldFill;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableLogic;
import com.fasterxml.jackson.annotation.JsonFormat;

import java.util.Date;

public class InfoEntity extends BaseEntity {
    @TableField(
        fill = FieldFill.INSERT
    )
    @JsonFormat(
        pattern = "yyyy-MM-dd HH:mm:ss",
        timezone = "GMT+8"
    )
    private Date baseCreateTime;
    @TableField(
        fill = FieldFill.UPDATE
    )
    @JsonFormat(
        pattern = "yyyy-MM-dd HH:mm:ss",
        timezone = "GMT+8"
    )
    private Date baseUpdateTime;
    private String creator;
    @TableField(
        fill = FieldFill.INSERT
    )
    @TableLogic(
        value = "0",
        delval = "1"
    )
    private Boolean isDelete;

    public InfoEntity() {
    }

    public Date getBaseCreateTime() {
        return this.baseCreateTime;
    }

    public Date getBaseUpdateTime() {
        return this.baseUpdateTime;
    }

    public String getCreator() {
        return this.creator;
    }

    public Boolean getIsDelete() {
        return this.isDelete;
    }

    public void setBaseCreateTime(Date baseCreateTime) {
        this.baseCreateTime = baseCreateTime;
    }

    public void setBaseUpdateTime(Date baseUpdateTime) {
        this.baseUpdateTime = baseUpdateTime;
    }

    public void setCreator(String creator) {
        this.creator = creator;
    }

    public void setIsDelete(Boolean isDelete) {
        this.isDelete = isDelete;
    }

    public boolean equals(Object o) {
        if (o == this) {
            return true;
        } else if (!(o instanceof InfoEntity)) {
            return false;
        } else {
            InfoEntity other = (InfoEntity)o;
            if (!other.canEqual(this)) {
                return false;
            } else {
                label59: {
                    Object this$baseCreateTime = this.getBaseCreateTime();
                    Object other$baseCreateTime = other.getBaseCreateTime();
                    if (this$baseCreateTime == null) {
                        if (other$baseCreateTime == null) {
                            break label59;
                        }
                    } else if (this$baseCreateTime.equals(other$baseCreateTime)) {
                        break label59;
                    }

                    return false;
                }

                Object this$baseUpdateTime = this.getBaseUpdateTime();
                Object other$baseUpdateTime = other.getBaseUpdateTime();
                if (this$baseUpdateTime == null) {
                    if (other$baseUpdateTime != null) {
                        return false;
                    }
                } else if (!this$baseUpdateTime.equals(other$baseUpdateTime)) {
                    return false;
                }

                Object this$creator = this.getCreator();
                Object other$creator = other.getCreator();
                if (this$creator == null) {
                    if (other$creator != null) {
                        return false;
                    }
                } else if (!this$creator.equals(other$creator)) {
                    return false;
                }

                Object this$isDelete = this.getIsDelete();
                Object other$isDelete = other.getIsDelete();
                if (this$isDelete == null) {
                    if (other$isDelete != null) {
                        return false;
                    }
                } else if (!this$isDelete.equals(other$isDelete)) {
                    return false;
                }

                return true;
            }
        }
    }

    protected boolean canEqual(Object other) {
        return other instanceof InfoEntity;
    }

//    public int hashCode() {
//        int PRIME = true;
//        int result = 1;
//        Object $baseCreateTime = this.getBaseCreateTime();
//        int result = result * 59 + ($baseCreateTime == null ? 43 : $baseCreateTime.hashCode());
//        Object $baseUpdateTime = this.getBaseUpdateTime();
//        result = result * 59 + ($baseUpdateTime == null ? 43 : $baseUpdateTime.hashCode());
//        Object $creator = this.getCreator();
//        result = result * 59 + ($creator == null ? 43 : $creator.hashCode());
//        Object $isDelete = this.getIsDelete();
//        result = result * 59 + ($isDelete == null ? 43 : $isDelete.hashCode());
//        return result;
//    }

    public String toString() {
        return "InfoEntity(baseCreateTime=" + this.getBaseCreateTime() + ", baseUpdateTime=" + this.getBaseUpdateTime() + ", creator=" + this.getCreator() + ", isDelete=" + this.getIsDelete() + ")";
    }
}
