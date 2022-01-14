//
// Source code recreated from a .class file by IntelliJ IDEA
// (powered by FernFlower decompiler)
//

package com.liudi.base;

import java.io.Serializable;
import java.util.List;

public class PageResult<T> implements Serializable {
    private static final long serialVersionUID = 867755909294344406L;
    private long totalCount;
    private List<T> content;
    private long recordCount;
    private long totalPage;
    private PageInfo pageInfo;

    public long getRecordCount() {
        return this.content != null && this.content.size() > 0 ? (long)this.content.size() : 0L;
    }

    public long getTotalPage() {
        return this.pageInfo != null && this.pageInfo.getPageSize() == 0 ? 1L : (long)((int)Math.ceil((double)this.totalCount / (double)this.pageInfo.getPageSize()));
    }

    public PageResult(List<T> content, PageInfo pageInfo, long totalCount) {
        this.totalCount = totalCount;
        this.content = content;
        this.pageInfo = pageInfo;
        this.recordCount = this.getRecordCount();
        this.totalPage = this.getTotalPage();
    }

    public long getTotalCount() {
        return this.totalCount;
    }

    public List<T> getContent() {
        return this.content;
    }

    public PageInfo getPageInfo() {
        return this.pageInfo;
    }

    public void setTotalCount(long totalCount) {
        this.totalCount = totalCount;
    }

    public void setContent(List<T> content) {
        this.content = content;
    }

    public void setRecordCount(long recordCount) {
        this.recordCount = recordCount;
    }

    public void setTotalPage(long totalPage) {
        this.totalPage = totalPage;
    }

    public void setPageInfo(PageInfo pageInfo) {
        this.pageInfo = pageInfo;
    }

    public boolean equals(Object o) {
        if (o == this) {
            return true;
        } else if (!(o instanceof PageResult)) {
            return false;
        } else {
            PageResult<?> other = (PageResult)o;
            if (!other.canEqual(this)) {
                return false;
            } else if (this.getTotalCount() != other.getTotalCount()) {
                return false;
            } else {
                label45: {
                    Object this$content = this.getContent();
                    Object other$content = other.getContent();
                    if (this$content == null) {
                        if (other$content == null) {
                            break label45;
                        }
                    } else if (this$content.equals(other$content)) {
                        break label45;
                    }

                    return false;
                }

                if (this.getRecordCount() != other.getRecordCount()) {
                    return false;
                } else if (this.getTotalPage() != other.getTotalPage()) {
                    return false;
                } else {
                    Object this$pageInfo = this.getPageInfo();
                    Object other$pageInfo = other.getPageInfo();
                    if (this$pageInfo == null) {
                        if (other$pageInfo != null) {
                            return false;
                        }
                    } else if (!this$pageInfo.equals(other$pageInfo)) {
                        return false;
                    }

                    return true;
                }
            }
        }
    }

    protected boolean canEqual(Object other) {
        return other instanceof PageResult;
    }

//    public int hashCode() {
//        int PRIME = true;
//        int result = 1;
//        long $totalCount = this.getTotalCount();
//        int result = result * 59 + (int)($totalCount >>> 32 ^ $totalCount);
//        Object $content = this.getContent();
//        result = result * 59 + ($content == null ? 43 : $content.hashCode());
//        long $recordCount = this.getRecordCount();
//        result = result * 59 + (int)($recordCount >>> 32 ^ $recordCount);
//        long $totalPage = this.getTotalPage();
//        result = result * 59 + (int)($totalPage >>> 32 ^ $totalPage);
//        Object $pageInfo = this.getPageInfo();
//        result = result * 59 + ($pageInfo == null ? 43 : $pageInfo.hashCode());
//        return result;
//    }

    public String toString() {
        return "PageResult(totalCount=" + this.getTotalCount() + ", content=" + this.getContent() + ", recordCount=" + this.getRecordCount() + ", totalPage=" + this.getTotalPage() + ", pageInfo=" + this.getPageInfo() + ")";
    }
}
