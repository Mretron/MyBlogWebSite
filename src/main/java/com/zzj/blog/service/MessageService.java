package com.zzj.blog.service;

import com.zzj.blog.pojo.Message;

import java.util.List;

public interface MessageService {


    List<Message> listMessages();


    Message saveMessage(Message message);

}
