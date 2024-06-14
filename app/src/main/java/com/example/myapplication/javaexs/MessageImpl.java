package com.example.myapplication.javaexs;

public class MessageImpl implements IMessage{
    @Override
    public void sendMessage() {
        System.out.println("sending message from impl");
    }
}
