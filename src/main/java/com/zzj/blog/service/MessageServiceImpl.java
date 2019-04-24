package com.zzj.blog.service;

import com.zzj.blog.dao.MessageRepository;
import com.zzj.blog.pojo.Message;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class MessageServiceImpl implements MessageService {

    @Autowired
    private MessageRepository messageRepository;


    @Transactional
    @Override
    public List<Message> listMessages() {

        Sort sort = new Sort("createTime");


        return messageRepository.findAll(sort.descending());
    }


    @Transactional
    @Override
    public Message saveMessage(Message message) {
        return messageRepository.save(message);
    }
}
