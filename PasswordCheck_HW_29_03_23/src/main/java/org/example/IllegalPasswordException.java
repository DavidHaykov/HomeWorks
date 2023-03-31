package org.example;

public class IllegalPasswordException extends Exception {

    private String[] messages;

    public IllegalPasswordException(String[] messages) {
        this.messages = messages;
    }

    public String[] getMessages() {
        return messages;
    }
}
