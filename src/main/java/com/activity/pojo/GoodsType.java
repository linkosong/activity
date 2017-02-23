package com.activity.pojo;

public class GoodsType {
    private Long id;

    private Long pid;

    private Long level;
    
    private String levelName;

    private String levelPicUrl;
    
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getPid() {
        return pid;
    }

    public void setPid(Long pid) {
        this.pid = pid;
    }

    public Long getLevel() {
        return level;
    }

    public void setLevel(Long level) {
        this.level = level;
    }

	public String getLevelName() {
		return levelName;
	}

	public void setLevelName(String levelName) {
		this.levelName = levelName;
	}

	public String getLevelPicUrl() {
		return levelPicUrl;
	}

	public void setLevelPicUrl(String levelPicUrl) {
		this.levelPicUrl = levelPicUrl;
	}
}