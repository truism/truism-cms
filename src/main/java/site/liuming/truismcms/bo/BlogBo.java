package site.liuming.truismcms.bo;

import java.util.Arrays;
import java.util.Date;
import java.util.List;

public class BlogBo {

    private String title;

    private Long typeId;

    private List<Long> tagsId;

    private Date updateTime;

    private boolean draft;

    public BlogBo() {

    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public Long getTypeId() {
        return typeId;
    }

    public void setTypeId(Long typeId) {
        this.typeId = typeId;
    }

    public List<Long> getTagsId() {
        return tagsId;
    }

    public void setTagsId(List<Long> tagsId) {
        this.tagsId = tagsId;
    }

    public Date getUpdateTime() {
        return updateTime;
    }

    public void setUpdateTime(Date updateTime) {
        this.updateTime = updateTime;
    }

    public boolean isDraft() {
        return draft;
    }

    public void setDraft(boolean draft) {
        this.draft = draft;
    }

    @Override
    public String toString() {
        return "BlogBo{" +
                "title='" + title + '\'' +
                ", typeId=" + typeId +
                ", tagsId=" + tagsId +
                ", updateTime=" + updateTime +
                ", draft=" + draft +
                '}';
    }
}
