//
// Source code recreated from a .class file by IntelliJ IDEA
// (powered by FernFlower decompiler)
//

package com.liudi.base;

import java.io.Serializable;
import java.util.List;

public class PageCustomResult<T> implements Serializable {
    private List<T> customSearch;
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

    public PageCustomResult(List<T> content, PageInfo pageInfo, long totalCount, List<T> customSearch) {
        this.totalCount = totalCount;
        this.content = content;
        this.pageInfo = pageInfo;
        this.recordCount = this.getRecordCount();
        this.totalPage = this.getTotalPage();
        this.customSearch = customSearch;
    }

    public List<T> getCustomSearch() {
        return this.customSearch;
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

    public void setCustomSearch(List<T> customSearch) {
        this.customSearch = customSearch;
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
        } else if (!(o instanceof PageCustomResult)) {
            return false;
        } else {
            PageCustomResult<?> other = (PageCustomResult)o;
            if (!other.canEqual(this)) {
                return false;
            } else {
                label59: {
                    Object this$customSearch = this.getCustomSearch();
                    Object other$customSearch = other.getCustomSearch();
                    if (this$customSearch == null) {
                        if (other$customSearch == null) {
                            break label59;
                        }
                    } else if (this$customSearch.equals(other$customSearch)) {
                        break label59;
                    }

                    return false;
                }

                if (this.getTotalCount() != other.getTotalCount()) {
                    return false;
                } else {
                    Object this$content = this.getContent();
                    Object other$content = other.getContent();
                    if (this$content == null) {
                        if (other$content != null) {
                            return false;
                        }
                    } else if (!this$content.equals(other$content)) {
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
    }

    protected boolean canEqual(Object other) {
        return other instanceof PageCustomResult;
    }

//    public int hashCode() {
//        int PRIME = true;
//        int result = 1;
//        Object $customSearch = this.getCustomSearch();
//        int result = result * 59 + ($customSearch == null ? 43 : $customSearch.hashCode());
//        long $totalCount = this.getTotalCount();
//        result = result * 59 + (int)($totalCount >>> 32 ^ $totalCount);
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
        return "PageCustomResult(customSearch=" + this.getCustomSearch() + ", totalCount=" + this.getTotalCount() + ", content=" + this.getContent() + ", recordCount=" + this.getRecordCount() + ", totalPage=" + this.getTotalPage() + ", pageInfo=" + this.getPageInfo() + ")";
    }
}
