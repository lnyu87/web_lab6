package com.scsxw.entity;

import java.time.LocalDateTime;

/**
 * 作者表（诗人信息）实体类
 */
public class Author {
    // 数据库字段
    private Long id;                 // 作者ID
    private String name;             // 作者姓名
    private String dynasty;          // 所处朝代
    private String pic;              // 诗人头像URL
    private String birthYear;        // 出生年份
    private String deathYear;        // 逝世年份
    private String alias;            // 别名/字号
    private String biography;        // 生平简介
    private String representativeWorks;  // 代表作品
    private LocalDateTime createTime;  // 记录创建时间
    private LocalDateTime updateTime;  // 记录更新时间

    // 无参构造
    public Author() {}

    // 全参构造
    public Author(Long id, String name, String dynasty, String pic, String birthYear, 
                  String deathYear, String alias, String biography, String representativeWorks, 
                  LocalDateTime createTime, LocalDateTime updateTime) {
        this.id = id;
        this.name = name;
        this.dynasty = dynasty;
        this.pic = pic;
        this.birthYear = birthYear;
        this.deathYear = deathYear;
        this.alias = alias;
        this.biography = biography;
        this.representativeWorks = representativeWorks;
        this.createTime = createTime;
        this.updateTime = updateTime;
    }

    // Getter & Setter
    public Long getId() { return id; }
    public void setId(Long id) { this.id = id; }

    public String getName() { return name; }
    public void setName(String name) { this.name = name; }

    public String getDynasty() { return dynasty; }
    public void setDynasty(String dynasty) { this.dynasty = dynasty; }

    public String getPic() { return pic; }
    public void setPic(String pic) { this.pic = pic; }

    public String getBirthYear() { return birthYear; }
    public void setBirthYear(String birthYear) { this.birthYear = birthYear; }

    public String getDeathYear() { return deathYear; }
    public void setDeathYear(String deathYear) { this.deathYear = deathYear; }

    public String getAlias() { return alias; }
    public void setAlias(String alias) { this.alias = alias; }

    public String getBiography() { return biography; }
    public void setBiography(String biography) { this.biography = biography; }

    public String getRepresentativeWorks() { return representativeWorks; }
    public void setRepresentativeWorks(String representativeWorks) { this.representativeWorks = representativeWorks; }

    public LocalDateTime getCreateTime() { return createTime; }
    public void setCreateTime(LocalDateTime createTime) { this.createTime = createTime; }

    public LocalDateTime getUpdateTime() { return updateTime; }
    public void setUpdateTime(LocalDateTime updateTime) { this.updateTime = updateTime; }

    // toString方法（便于日志打印）
    @Override
    public String toString() {
        return "Author{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", dynasty='" + dynasty + '\'' +
                ", birthYear='" + birthYear + '\'' +
                ", deathYear='" + deathYear + '\'' +
                ", alias='" + alias + '\'' +
                '}';
    }
}