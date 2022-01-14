//
// Source code recreated from a .class file by IntelliJ IDEA
// (powered by FernFlower decompiler)
//

package com.liudi.base;

public class ExcelVo {
    private String key;
    private String value;
    private int sort;

    public ExcelVo() {
    }

    public String getKey() {
        return this.key;
    }

    public String getValue() {
        return this.value;
    }

    public int getSort() {
        return this.sort;
    }

    public void setKey(String key) {
        this.key = key;
    }

    public void setValue(String value) {
        this.value = value;
    }

    public void setSort(int sort) {
        this.sort = sort;
    }

    public boolean equals(Object o) {
        if (o == this) {
            return true;
        } else if (!(o instanceof ExcelVo)) {
            return false;
        } else {
            ExcelVo other = (ExcelVo)o;
            if (!other.canEqual(this)) {
                return false;
            } else {
                label39: {
                    Object this$key = this.getKey();
                    Object other$key = other.getKey();
                    if (this$key == null) {
                        if (other$key == null) {
                            break label39;
                        }
                    } else if (this$key.equals(other$key)) {
                        break label39;
                    }

                    return false;
                }

                Object this$value = this.getValue();
                Object other$value = other.getValue();
                if (this$value == null) {
                    if (other$value != null) {
                        return false;
                    }
                } else if (!this$value.equals(other$value)) {
                    return false;
                }

                if (this.getSort() != other.getSort()) {
                    return false;
                } else {
                    return true;
                }
            }
        }
    }

    protected boolean canEqual(Object other) {
        return other instanceof ExcelVo;
    }

//    public int hashCode() {
//        int PRIME = true;
//        int result = 1;
//        Object $key = this.getKey();
//        int result = result * 59 + ($key == null ? 43 : $key.hashCode());
//        Object $value = this.getValue();
//        result = result * 59 + ($value == null ? 43 : $value.hashCode());
//        result = result * 59 + this.getSort();
//        return result;
//    }

    public String toString() {
        return "ExcelVo(key=" + this.getKey() + ", value=" + this.getValue() + ", sort=" + this.getSort() + ")";
    }
}
