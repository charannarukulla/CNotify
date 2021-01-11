package com.charannarukulla.cnotify;
public class Sendnotification {
    private String to ;

    notification notification=new notification();

    public String getTo() {
        return to;
    }

    public void setTo(String to) {
        this.to = to;
    }

    public notification getNotification() {
        return notification;
    }

    public void setNotification(notification notification) {
        this.notification = notification;
    }

    public Sendnotification() {
    }
}
