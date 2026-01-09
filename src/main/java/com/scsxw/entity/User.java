package com.scsxw.entity;
import java.time.LocalDateTime;

/**
 * 用户表实体类
 */
public class User {
    // 数据库字段
    private Long id;                 // 用户ID
    private String username;         // 用户名
    private String password;         // 密码（加密存储）
    private String nickname;         // 昵称
    private String email;            // 邮箱
    private String avatar;           // 头像URL
    private String role;             // 角色（admin/user）
    private Integer status;          // 状态（0-禁用，1-正常）
    private LocalDateTime registerTime;  // 注册时间
    private LocalDateTime lastLoginTime;  // 最后登录时间
    private LocalDateTime updateTime;  // 更新时间

    // 无参构造
    public User() {}

    // 全参构造
    public User(Long id, String username, String password, String nickname, String email, 
               String avatar, String role, Integer status, LocalDateTime registerTime, 
               LocalDateTime lastLoginTime, LocalDateTime updateTime) {
        this.id = id;
        this.username = username;
        this.password = password;
        this.nickname = nickname;
        this.email = email;
        this.avatar = avatar;
        this.role = role;
        this.status = status;
        this.registerTime = registerTime;
        this.lastLoginTime = lastLoginTime;
        this.updateTime = updateTime;
    }

    // Getter & Setter
    public Long getId() { return id; }
    public void setId(Long id) { this.id = id; }

    public String getUsername() { return username; }
    public void setUsername(String username) { this.username = username; }

    public String getPassword() { return password; }
    public void setPassword(String password) { this.password = password; }

    public String getNickname() { return nickname; }
    public void setNickname(String nickname) { this.nickname = nickname; }

    public String getEmail() { return email; }
    public void setEmail(String email) { this.email = email; }

    public String getAvatar() { return avatar; }
    public void setAvatar(String avatar) { this.avatar = avatar; }

    public String getRole() { return role; }
    public void setRole(String role) { this.role = role; }

    public Integer getStatus() { return status; }
    public void setStatus(Integer status) { this.status = status; }

    public LocalDateTime getRegisterTime() { return registerTime; }
    public void setRegisterTime(LocalDateTime registerTime) { this.registerTime = registerTime; }

    public LocalDateTime getLastLoginTime() { return lastLoginTime; }
    public void setLastLoginTime(LocalDateTime lastLoginTime) { this.lastLoginTime = lastLoginTime; }

    public LocalDateTime getUpdateTime() { return updateTime; }
    public void setUpdateTime(LocalDateTime updateTime) { this.updateTime = updateTime; }

    @Override
    public String toString() {
        return "User{" +
                "id=" + id +
                ", username='" + username + '\'' +
                ", nickname='" + nickname + '\'' +
                ", role='" + role + '\'' +
                ", status=" + status +
                '}';
    }
}