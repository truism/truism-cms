package site.liuming.truismcms.bo;

import java.util.Date;
import java.util.List;

public class BlogBo {

    private String title;

    private String content;

    private Long typeId;

    private Boolean source;

    private List<Long> tagsId;

    private Date updateTime;

    private Boolean draft;

    public BlogBo() {

    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
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

    public Boolean getSource() {
        return source;
    }

    public void setSource(Boolean source) {
        this.source = source;
    }

    public Boolean getDraft() {
        return draft;
    }

    public void setDraft(boolean draft) {
        this.draft = draft;
    }

    @Override
    public String toString() {
        return "BlogBo{" +
                "title='" + title + '\'' +
                ", content='" + content + '\'' +
                ", typeId=" + typeId +
                ", source=" + source +
                ", tagsId=" + tagsId +
                ", updateTime=" + updateTime +
                ", draft=" + draft +
                '}';
    }
}
