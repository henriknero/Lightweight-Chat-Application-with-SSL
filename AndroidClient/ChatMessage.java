package com.henriknero.chatapplication;

import java.util.Date;

/**
 * Created by henri on 2017-03-21.
 */

public class ChatMessage {
    private String messageText;
    private String messageUser;
    private long messageTime;

    public ChatMessage(String messageText, String messageUser) {
        this.messageText = messageText;
        this.messageUser = messageUser;
        this.messageTime = new Date().getTime();
    }

    public ChatMessage(String messageText, String messageUser, long messageTime) {
        this.messageText = messageText;
        this.messageUser = messageUser;
        this.messageTime = messageTime;
    }

    public ChatMessage() {
    }

    public String getMessageText() {
        return messageText;
    }

    public void setMessageText(String messageText) {
        this.messageText = messageText;
    }

    public String getMessageUser() {
        return messageUser;
    }

    public void setMessageUser(String messageUser) {
        this.messageUser = messageUser;
    }

    public long getMessageTime() {
        return messageTime;
    }

    public void setMessageTime(long messageTime) {
        this.messageTime = messageTime;
    }
}
/**
 * Links that were used during process
 * -----------------------------------
 * https://www.youtube.com/watch?v=Xn0tQHpMDnM&t=1532s
 */
