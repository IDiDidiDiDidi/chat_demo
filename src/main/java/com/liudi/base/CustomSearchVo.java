//
// Source code recreated from a .class file by IntelliJ IDEA
// (powered by FernFlower decompiler)
//

package com.liudi.base;

public class CustomSearchVo {
    private String key;
    private String value;
    private boolean isShow;
    private String rule;
    private String columnName;
    private Object contentValue;
    private boolean dateShow;

    public String getKey() {
        return this.key;
    }

    public String getValue() {
        return this.value;
    }

    public boolean isShow() {
        return this.isShow;
    }

    public String getRule() {
        return this.rule;
    }

    public String getColumnName() {
        return this.columnName;
    }

    public Object getContentValue() {
        return this.contentValue;
    }

    public boolean isDateShow() {
        return this.dateShow;
    }

    public void setKey(String key) {
        this.key = key;
    }

    public void setValue(String value) {
        this.value = value;
    }

    public void setShow(boolean isShow) {
        this.isShow = isShow;
    }

    public void setRule(String rule) {
        this.rule = rule;
    }

    public void setColumnName(String columnName) {
        this.columnName = columnName;
    }

    public void setContentValue(Object contentValue) {
        this.contentValue = contentValue;
    }

    public void setDateShow(boolean dateShow) {
        this.dateShow = dateShow;
    }

    public boolean equals(Object o) {
        if (o == this) {
            return true;
        } else if (!(o instanceof CustomSearchVo)) {
            return false;
        } else {
            CustomSearchVo other = (CustomSearchVo)o;
            if (!other.canEqual(this)) {
                return false;
            } else {
                label79: {
                    Object this$key = this.getKey();
                    Object other$key = other.getKey();
                    if (this$key == null) {
                        if (other$key == null) {
                            break label79;
                        }
                    } else if (this$key.equals(other$key)) {
                        break label79;
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

                if (this.isShow() != other.isShow()) {
                    return false;
                } else {
                    Object this$rule = this.getRule();
                    Object other$rule = other.getRule();
                    if (this$rule == null) {
                        if (other$rule != null) {
                            return false;
                        }
                    } else if (!this$rule.equals(other$rule)) {
                        return false;
                    }

                    label57: {
                        Object this$columnName = this.getColumnName();
                        Object other$columnName = other.getColumnName();
                        if (this$columnName == null) {
                            if (other$columnName == null) {
                                break label57;
                            }
                        } else if (this$columnName.equals(other$columnName)) {
                            break label57;
                        }

                        return false;
                    }

                    Object this$contentValue = this.getContentValue();
                    Object other$contentValue = other.getContentValue();
                    if (this$contentValue == null) {
                        if (other$contentValue != null) {
                            return false;
                        }
                    } else if (!this$contentValue.equals(other$contentValue)) {
                        return false;
                    }

                    if (this.isDateShow() != other.isDateShow()) {
                        return false;
                    } else {
                        return true;
                    }
                }
            }
        }
    }

    protected boolean canEqual(Object other) {
        return other instanceof CustomSearchVo;
    }

//    public int hashCode() {
//        int PRIME = true;
//        int result = 1;
//        Object $key = this.getKey();
//        int result = result * 59 + ($key == null ? 43 : $key.hashCode());
//        Object $value = this.getValue();
//        result = result * 59 + ($value == null ? 43 : $value.hashCode());
//        result = result * 59 + (this.isShow() ? 79 : 97);
//        Object $rule = this.getRule();
//        result = result * 59 + ($rule == null ? 43 : $rule.hashCode());
//        Object $columnName = this.getColumnName();
//        result = result * 59 + ($columnName == null ? 43 : $columnName.hashCode());
//        Object $contentValue = this.getContentValue();
//        result = result * 59 + ($contentValue == null ? 43 : $contentValue.hashCode());
//        result = result * 59 + (this.isDateShow() ? 79 : 97);
//        return result;
//    }

    public String toString() {
        return "CustomSearchVo(key=" + this.getKey() + ", value=" + this.getValue() + ", isShow=" + this.isShow() + ", rule=" + this.getRule() + ", columnName=" + this.getColumnName() + ", contentValue=" + this.getContentValue() + ", dateShow=" + this.isDateShow() + ")";
    }

    public CustomSearchVo(String key, String value, boolean isShow, String rule, String columnName, Object contentValue, boolean dateShow) {
        this.key = key;
        this.value = value;
        this.isShow = isShow;
        this.rule = rule;
        this.columnName = columnName;
        this.contentValue = contentValue;
        this.dateShow = dateShow;
    }

    public CustomSearchVo() {
    }
}
