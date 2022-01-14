//
// Source code recreated from a .class file by IntelliJ IDEA
// (powered by FernFlower decompiler)
//

package com.liudi.utils.zhenghe;

import java.io.Serializable;
import java.util.HashMap;
import java.util.Map;

public class BaseDto implements Serializable {
    private static final long serialVersionUID = -6651212609692684267L;
    private Map<String, Object> params;

    public BaseDto() {
    }

    public boolean equals(Object o) {
        if (o == this) {
            return true;
        } else if (!(o instanceof BaseDto)) {
            return false;
        } else {
            BaseDto other = (BaseDto)o;
            return other.canEqual(this);
        }
    }

    protected boolean canEqual(Object other) {
        return other instanceof BaseDto;
    }

    public int hashCode() {
        int result = 1;
        return result;
    }

    public Map<String, Object> getParams() {
        if (this.params == null) {
            this.params = new HashMap();
        }

        return this.params;
    }

    public void setParams(Map<String, Object> params) {
        this.params = params;
    }

    public String toString() {
        return "BaseDto(params=" + this.getParams() + ")";
    }
}
