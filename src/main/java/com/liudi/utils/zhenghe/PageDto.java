//
// Source code recreated from a .class file by IntelliJ IDEA
// (powered by FernFlower decompiler)
//

package com.liudi.utils.zhenghe;

import java.util.Map;

public class PageDto extends BaseDto {
    private Integer pageNum;
    private Integer pageSize;
    private String orderByColumn;
    private String isAsc;
    private Map<String, Object> aliasParams;
    private String aliasSearchStr;

    public PageDto(Integer pageNum, Integer pageSize, String orderByColumn, String isAsc) {
        this.pageNum = pageNum;
        this.pageSize = pageSize;
        this.orderByColumn = orderByColumn;
        this.isAsc = isAsc;
    }

    public Integer getPageNum() {
        return this.pageNum == null ? 0 : this.pageNum;
    }

    public Integer getPageSize() {
        return this.pageSize == null ? 10 : this.pageSize;
    }

    public String getOrderByColumn() {
        return this.orderByColumn;
    }

    public String getIsAsc() {
        return this.isAsc;
    }

    public Map<String, Object> getAliasParams() {
        return this.aliasParams;
    }

    public String getAliasSearchStr() {
        return this.aliasSearchStr;
    }

    public void setPageNum(Integer pageNum) {
        this.pageNum = pageNum;
    }

    public void setPageSize(Integer pageSize) {
        this.pageSize = pageSize;
    }

    public void setOrderByColumn(String orderByColumn) {
        this.orderByColumn = orderByColumn;
    }

    public void setIsAsc(String isAsc) {
        this.isAsc = isAsc;
    }

    public void setAliasParams(Map<String, Object> aliasParams) {
        this.aliasParams = aliasParams;
    }

    public void setAliasSearchStr(String aliasSearchStr) {
        this.aliasSearchStr = aliasSearchStr;
    }

    public boolean equals(Object o) {
        if (o == this) {
            return true;
        } else if (!(o instanceof PageDto)) {
            return false;
        } else {
            PageDto other = (PageDto)o;
            if (!other.canEqual(this)) {
                return false;
            } else {
                Object this$pageNum = this.getPageNum();
                Object other$pageNum = other.getPageNum();
                if (this$pageNum == null) {
                    if (other$pageNum != null) {
                        return false;
                    }
                } else if (!this$pageNum.equals(other$pageNum)) {
                    return false;
                }

                Object this$pageSize = this.getPageSize();
                Object other$pageSize = other.getPageSize();
                if (this$pageSize == null) {
                    if (other$pageSize != null) {
                        return false;
                    }
                } else if (!this$pageSize.equals(other$pageSize)) {
                    return false;
                }

                Object this$orderByColumn = this.getOrderByColumn();
                Object other$orderByColumn = other.getOrderByColumn();
                if (this$orderByColumn == null) {
                    if (other$orderByColumn != null) {
                        return false;
                    }
                } else if (!this$orderByColumn.equals(other$orderByColumn)) {
                    return false;
                }

                label62: {
                    Object this$isAsc = this.getIsAsc();
                    Object other$isAsc = other.getIsAsc();
                    if (this$isAsc == null) {
                        if (other$isAsc == null) {
                            break label62;
                        }
                    } else if (this$isAsc.equals(other$isAsc)) {
                        break label62;
                    }

                    return false;
                }

                label55: {
                    Object this$aliasParams = this.getAliasParams();
                    Object other$aliasParams = other.getAliasParams();
                    if (this$aliasParams == null) {
                        if (other$aliasParams == null) {
                            break label55;
                        }
                    } else if (this$aliasParams.equals(other$aliasParams)) {
                        break label55;
                    }

                    return false;
                }

                Object this$aliasSearchStr = this.getAliasSearchStr();
                Object other$aliasSearchStr = other.getAliasSearchStr();
                if (this$aliasSearchStr == null) {
                    if (other$aliasSearchStr != null) {
                        return false;
                    }
                } else if (!this$aliasSearchStr.equals(other$aliasSearchStr)) {
                    return false;
                }

                return true;
            }
        }
    }

    protected boolean canEqual(Object other) {
        return other instanceof PageDto;
    }

//    public int hashCode() {
//        int PRIME = true;
//        int result = 1;
//        Object $pageNum = this.getPageNum();
//        int result = result * 59 + ($pageNum == null ? 43 : $pageNum.hashCode());
//        Object $pageSize = this.getPageSize();
//        result = result * 59 + ($pageSize == null ? 43 : $pageSize.hashCode());
//        Object $orderByColumn = this.getOrderByColumn();
//        result = result * 59 + ($orderByColumn == null ? 43 : $orderByColumn.hashCode());
//        Object $isAsc = this.getIsAsc();
//        result = result * 59 + ($isAsc == null ? 43 : $isAsc.hashCode());
//        Object $aliasParams = this.getAliasParams();
//        result = result * 59 + ($aliasParams == null ? 43 : $aliasParams.hashCode());
//        Object $aliasSearchStr = this.getAliasSearchStr();
//        result = result * 59 + ($aliasSearchStr == null ? 43 : $aliasSearchStr.hashCode());
//        return result;
//    }

    public String toString() {
        return "PageDto(pageNum=" + this.getPageNum() + ", pageSize=" + this.getPageSize() + ", orderByColumn=" + this.getOrderByColumn() + ", isAsc=" + this.getIsAsc() + ", aliasParams=" + this.getAliasParams() + ", aliasSearchStr=" + this.getAliasSearchStr() + ")";
    }

    public PageDto() {
    }

    public PageDto(Integer pageNum, Integer pageSize, String orderByColumn, String isAsc, Map<String, Object> aliasParams, String aliasSearchStr) {
        this.pageNum = pageNum;
        this.pageSize = pageSize;
        this.orderByColumn = orderByColumn;
        this.isAsc = isAsc;
        this.aliasParams = aliasParams;
        this.aliasSearchStr = aliasSearchStr;
    }
}
