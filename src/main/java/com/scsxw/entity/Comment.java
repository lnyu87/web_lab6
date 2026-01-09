package com.scsxw.entity;
import java.time.LocalDateTime;
import java.util.List;

/**
 * 评论表实体类（含非数据库关联字段）
 */
public class Comment {
    // -------------------------- 数据库字段 --------------------------
    private Long id;                 // 评论ID
    private String title;            // 评论标题
    private String content;          // 评论内容
    private Long poetryId;           // 关联的诗词ID
    private Long userId;             // 评论用户ID
    private Long parentId;           // 父评论ID（用于回复功能）
    private LocalDateTime createTime;  // 创建时间
    private LocalDateTime updateTime;  // 更新时间

    // -------------------------- 非数据库关联字段（用于查询） --------------------------
    private User user;               // 关联评论用户对象（非数据库字段）
    private List<Comment> replyList; // 关联子评论列表（非数据库字段）

    // 无参构造
    public Comment() {}

    // 全参构造（仅包含数据库字段）
    public Comment(Long id, String title, String content, Long poetryId, Long userId, 
                  Long parentId, LocalDateTime createTime, LocalDateTime updateTime) {
        this.id = id;
        this.title = title;
        this.content = content;
        this.poetryId = poetryId;
        this.userId = userId;
        this.parentId = parentId;
        this.createTime = createTime;
        this.updateTime = updateTime;
    }

    // Getter & Setter（包含关联字段）
    public Long getId() { return id; }
    public void setId(Long id) { this.id = id; }

    public String getTitle() { return title; }
    public void setTitle(String title) { this.title = title; }

    public String getContent() { return content; }
    public void setContent(String content) { this.content = content; }

    public Long getPoetryId() { return poetryId; }
    public void setPoetryId(Long poetryId) { this.poetryId = poetryId; }

    public Long getUserId() { return userId; }
    public void setUserId(Long userId) { this.userId = userId; }

    public Long getParentId() { return parentId; }
    public void setParentId(Long parentId) { this.parentId = parentId; }

    public LocalDateTime getCreateTime() { return createTime; }
    public void setCreateTime(LocalDateTime createTime) { this.createTime = createTime; }

    public LocalDateTime getUpdateTime() { return updateTime; }
    public void setUpdateTime(LocalDateTime updateTime) { this.updateTime = updateTime; }

    // 关联字段的Getter & Setter
    public User getUser() { return user; }
    public void setUser(User user) { this.user = user; }

    public List<Comment> getReplyList() { return replyList; }
    public void setReplyList(List<Comment> replyList) { this.replyList = replyList; }

    @Override
    public String toString() {
        return "Comment{" +
                "id=" + id +
                ", content='" + content + '\'' +
                ", userId=" + userId +
                ", parentId=" + parentId +
                '}';
    }
}
