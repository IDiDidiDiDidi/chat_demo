//
// Source code recreated from a .class file by IntelliJ IDEA
// (powered by FernFlower decompiler)
//

package com.liudi.base;

import java.io.Serializable;

public class BaseVo implements Serializable {
    private static final long serialVersionUID = -6651212609692684267L;

    public BaseVo() {
    }

    public boolean equals(Object o) {
        if (o == this) {
            return true;
        } else if (!(o instanceof BaseVo)) {
            return false;
        } else {
            BaseVo other = (BaseVo)o;
            return other.canEqual(this);
        }
    }

    protected boolean canEqual(Object other) {
        return other instanceof BaseVo;
    }

    public int hashCode() {
        int result = 1;
        return result;
    }

    public String toString() {
        return "BaseVo()";
    }
}
