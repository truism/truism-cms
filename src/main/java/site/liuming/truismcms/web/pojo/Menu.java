package site.liuming.truismcms.web.pojo;

import java.io.Serializable;

public class Menu implements Serializable {
    private Long id;

    private String name;

    private String component;

    private String router;

    private String iconCls;

    private Byte keepAlive;

    private Byte requireAuth;

    private Integer parentId;

    private static final long serialVersionUID = 1L;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getComponent() {
        return component;
    }

    public void setComponent(String component) {
        this.component = component;
    }

    public String getRouter() {
        return router;
    }

    public void setRouter(String router) {
        this.router = router;
    }

    public String getIconCls() {
        return iconCls;
    }

    public void setIconCls(String iconCls) {
        this.iconCls = iconCls;
    }

    public Byte getKeepAlive() {
        return keepAlive;
    }

    public void setKeepAlive(Byte keepAlive) {
        this.keepAlive = keepAlive;
    }

    public Byte getRequireAuth() {
        return requireAuth;
    }

    public void setRequireAuth(Byte requireAuth) {
        this.requireAuth = requireAuth;
    }

    public Integer getParentId() {
        return parentId;
    }

    public void setParentId(Integer parentId) {
        this.parentId = parentId;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(getClass().getSimpleName());
        sb.append(" [");
        sb.append("Hash = ").append(hashCode());
        sb.append(", id=").append(id);
        sb.append(", name=").append(name);
        sb.append(", component=").append(component);
        sb.append(", router=").append(router);
        sb.append(", iconCls=").append(iconCls);
        sb.append(", keepAlive=").append(keepAlive);
        sb.append(", requireAuth=").append(requireAuth);
        sb.append(", parentId=").append(parentId);
        sb.append(", serialVersionUID=").append(serialVersionUID);
        sb.append("]");
        return sb.toString();
    }
}