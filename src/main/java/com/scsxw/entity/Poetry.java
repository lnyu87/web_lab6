package com.scsxw.entity;
import java.time.LocalDateTime;
import java.util.List;

/**
 * 诗词表实体类（含非数据库关联字段）
 */
public class Poetry {
    // -------------------------- 数据库字段 --------------------------
    private Long id;                 // 诗词ID
    private String title;            // 诗词标题
    private String content;          // 诗词内容
    private String dynasty;          // 所属朝代
    private String pic;              // 诗词图片URL
    private Long authorId;           // 作者ID（关联author表）
    private String authorName;       // 诗人姓名
    private Long typeId;             // 类型ID（关联poetry_type表）
    private Long themeId;            // 主题ID（关联poetry_theme表）
    private String notes;            // 注释
    private Integer likeCount;       // 点赞数
    private Integer viewCount;       // 浏览量
    private Integer collectCount;    // 收藏数
    private Integer commentCount;    // 评论数
    private LocalDateTime createTime;  // 创建时间
    private LocalDateTime updateTime;  // 更新时间

    // -------------------------- 非数据库关联字段（用于查询） --------------------------
    private Author author;           // 关联作者对象（非数据库字段）
    private PoetryType poetryType;   // 关联类型对象（非数据库字段）
    private PoetryTheme poetryTheme; // 关联主题对象（非数据库字段）
    private String typeName;   // 类型名称（如“唐诗”）
    private String themeName;  // 主题名称（如“思乡”）
    private List<Comment> comments;  // 关联评论列表（非数据库字段）

    // 无参构造
    public Poetry() {}

    // 全参构造（仅包含数据库字段，关联字段通过setter设置）
    public Poetry(Long id, String title, String content, String dynasty, String pic, 
                 Long authorId, String authorName, Long typeId, Long themeId, String notes, 
                 Integer likeCount, Integer viewCount, Integer collectCount, Integer commentCount, 
                 LocalDateTime createTime, LocalDateTime updateTime) {
        this.id = id;
        this.title = title;
        this.content = content;
        this.dynasty = dynasty;
        this.pic = pic;
        this.authorId = authorId;
        this.authorName = authorName;
        this.typeId = typeId;
        this.themeId = themeId;
        this.notes = notes;
        this.likeCount = likeCount;
        this.viewCount = viewCount;
        this.collectCount = collectCount;
        this.commentCount = commentCount;
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

    public String getDynasty() { return dynasty; }
    public void setDynasty(String dynasty) { this.dynasty = dynasty; }

    public String getPic() { return pic; }
    public void setPic(String pic) { this.pic = pic; }

    public Long getAuthorId() { return authorId; }
    public void setAuthorId(Long authorId) { this.authorId = authorId; }

    public String getAuthorName() { return authorName; }
    public void setAuthorName(String authorName) { this.authorName = authorName; }

    public Long getTypeId() { return typeId; }
    public void setTypeId(Long typeId) { this.typeId = typeId; }

    public Long getThemeId() { return themeId; }
    public void setThemeId(Long themeId) { this.themeId = themeId; }

    public String getNotes() { return notes; }
    public void setNotes(String notes) { this.notes = notes; }

    public Integer getLikeCount() { return likeCount; }
    public void setLikeCount(Integer likeCount) { this.likeCount = likeCount; }

    public Integer getViewCount() { return viewCount; }
    public void setViewCount(Integer viewCount) { this.viewCount = viewCount; }

    public Integer getCollectCount() { return collectCount; }
    public void setCollectCount(Integer collectCount) { this.collectCount = collectCount; }

    public Integer getCommentCount() { return commentCount; }
    public void setCommentCount(Integer commentCount) { this.commentCount = commentCount; }

    public LocalDateTime getCreateTime() { return createTime; }
    public void setCreateTime(LocalDateTime createTime) { this.createTime = createTime; }

    public LocalDateTime getUpdateTime() { return updateTime; }
    public void setUpdateTime(LocalDateTime updateTime) { this.updateTime = updateTime; }

    // 关联字段的Getter & Setter
    public Author getAuthor() { return author; }
    public void setAuthor(Author author) { this.author = author; }

    public PoetryType getPoetryType() { return poetryType; }
    public void setPoetryType(PoetryType poetryType) { this.poetryType = poetryType; }

    public PoetryTheme getPoetryTheme() { return poetryTheme; }
    public void setPoetryTheme(PoetryTheme poetryTheme) { this.poetryTheme = poetryTheme; }

    public List<Comment> getComments() { return comments; }
    public void setComments(List<Comment> comments) { this.comments = comments; }
    public String getTypeName() { return typeName;}
    public void setTypeName(String typeName) { this.typeName = typeName; }

    public String getThemeName() { return themeName;}
    public void setThemeName(String themeName) {this.themeName = themeName;}
    @Override
    public String toString() {
        return "Poetry{" +
                "id=" + id +
                ", title='" + title + '\'' +
                ", authorName='" + authorName + '\'' +
                ", likeCount=" + likeCount +
                ", viewCount=" + viewCount +
                '}';
    }
}