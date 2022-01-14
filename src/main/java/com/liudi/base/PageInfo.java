//
// Source code recreated from a .class file by IntelliJ IDEA
// (powered by FernFlower decompiler)
//

package com.liudi.base;

public class PageInfo {
    int pageNumber;
    int pageSize;

    public int getPageNumber() {
        return this.pageNumber;
    }

    public int getPageSize() {
        return this.pageSize;
    }

    public void setPageNumber(int pageNumber) {
        this.pageNumber = pageNumber;
    }

    public void setPageSize(int pageSize) {
        this.pageSize = pageSize;
    }

    public boolean equals(Object o) {
        if (o == this) {
            return true;
        } else if (!(o instanceof PageInfo)) {
            return false;
        } else {
            PageInfo other = (PageInfo)o;
            if (!other.canEqual(this)) {
                return false;
            } else if (this.getPageNumber() != other.getPageNumber()) {
                return false;
            } else {
                return this.getPageSize() == other.getPageSize();
            }
        }
    }

    protected boolean canEqual(Object other) {
        return other instanceof PageInfo;
    }

//    public int hashCode() {
//        int PRIME = true;
//        int result = 1;
//        int result = result * 59 + this.getPageNumber();
//        result = result * 59 + this.getPageSize();
//        return result;
//    }

    public String toString() {
        return "PageInfo(pageNumber=" + this.getPageNumber() + ", pageSize=" + this.getPageSize() + ")";
    }

    public PageInfo() {
    }

    public PageInfo(int pageNumber, int pageSize) {
        this.pageNumber = pageNumber;
        this.pageSize = pageSize;
    }
}
