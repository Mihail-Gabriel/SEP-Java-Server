package com.sep.SepJavaServer.model;

public class Message {
    private String content;

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public Message(String content) {
        this.content = content;
    }

    public Message() {
    }
}
