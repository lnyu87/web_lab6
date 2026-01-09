package com.scsxw.entity;

public class Test {
    private Integer id;
    private String title;
    private String content;

    public Test() {}

    public Test(Integer id, String title, String content) {
        this.id = id;
        this.title = title;
        this.content = content;
    }

    public Integer getId() { return id; }
    public void setId(Integer id) { this.id = id; }
    public String getTitle() { return title; }
    public void setTitle(String title) { this.title = title; }
    public String getContent() { return content; }
    public void setContent(String content) { this.content = content; }

    @Override
    public String toString() {
        return "Test{id=" + id + ", title='" + title + "', content='" + content + "'}";
    }

	public Object getDescription() {
		// TODO Auto-generated method stub
		return null;
	}

	public Object getCreateTime() {
		// TODO Auto-generated method stub
		return null;
	}
}