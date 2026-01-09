package com.scsxw.entity;

import java.time.LocalDateTime;

/**
 * ʫ�������ʵ����
 */
public class PoetryTheme {
    // ���ݿ��ֶ�
    private Long id;                 // ����ID
    private String name;             // �������ƣ��磺˼�硢����ȣ�
    private String description;      // ��������
    private LocalDateTime createTime;  // ����ʱ��
    private LocalDateTime updateTime;  // ����ʱ��

    // �޲ι���
    public PoetryTheme() {}

    // ȫ�ι���
    public PoetryTheme(Long id, String name, String description, 
                      LocalDateTime createTime, LocalDateTime updateTime) {
        this.id = id;
        this.name = name;
        this.description = description;
        this.createTime = createTime;
        this.updateTime = updateTime;
    }

    // Getter & Setter
    public Long getId() { return id; }
    public void setId(long id) { this.id = (long) id; }

    public String getName() { return name; }
    public void setName(String name) { this.name = name; }

    public String getDescription() { return description; }
    public void setDescription(String description) { this.description = description; }

    public LocalDateTime getCreateTime() { return createTime; }
    public void setCreateTime(LocalDateTime createTime) { this.createTime = createTime; }

    public LocalDateTime getUpdateTime() { return updateTime; }
    public void setUpdateTime(LocalDateTime updateTime) { this.updateTime = updateTime; }

    @Override
    public String toString() {
        return "PoetryTheme{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", description='" + description + '\'' +
                '}';
    }

	public void setContent(String string) {
		// TODO Auto-generated method stub
		
	}

	public void setContent1(String string) {
		// TODO Auto-generated method stub
		
	}
}