package com.balceda.ws.model;

public class Content {
    private String data;

    public Content(String content) {
	this.data = content;
    }

    public Content() {
    }

    public String getData() {
	return data;
    }

    public void setData(String data) {
	this.data = data;
    }
}
