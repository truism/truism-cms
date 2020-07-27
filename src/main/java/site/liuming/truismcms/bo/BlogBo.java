package site.liuming.truismcms.bo;

import java.util.Date;

public class BlogBo {

    private String title;

    private Long typeId;

    private Long tagId;

    private Date startTime;

    private Date endTime;

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

    public Long getTagsId() {
        return tagId;
    }

    public void setTagsId(Long tagId) {
        this.tagId = tagId;
    }

    public Date getStartTime() {
        return startTime;
    }

    public void setStartTime(Date startTime) {
        this.startTime = startTime;
    }

    public Date getEndTime() {
        return endTime;
    }

    public void setEndTime(Date endTime) {
        this.endTime = endTime;
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
                ", tagsId=" + tagId +
                ", startTime=" + startTime +
                ", endTime=" + endTime +
                ", draft=" + draft +
                '}';
    }
}
