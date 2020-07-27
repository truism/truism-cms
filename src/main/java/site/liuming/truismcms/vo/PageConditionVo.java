package site.liuming.truismcms.vo;

/**
 * 分页查询条件参数
 */
public class PageConditionVo<T> {

    private Integer pageNum;

    private Integer pageSize;

    private T paramMap;

    public Integer getPageNum() {
        return pageNum;
    }

    public void setPageNum(Integer pageNum) {
        this.pageNum = pageNum;
    }

    public Integer getPageSize() {
        return pageSize;
    }

    public void setPageSize(Integer pageSize) {
        this.pageSize = pageSize;
    }

    public T getParamMap() {
        return paramMap;
    }

    public void setParamMap(T paramMap) {
        this.paramMap = paramMap;
    }
}
