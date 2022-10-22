package com.yasmin.solace_application.ui;

public class MsgModal {

    // string to store our message and sender
    private String message;
    private String sender;

    // constructor.
    public MsgModal(String message, String sender) {
        this.message = String.valueOf(message);
        this.sender = sender;
    }

    // getter and setter methods.
    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public String getSender() {
        return sender;
    }

    public void setSender(String sender) {
        this.sender = sender;
    }
}