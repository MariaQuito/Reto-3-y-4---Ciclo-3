package com.example.reto3.service;

import com.example.reto3.entities.Message;
import com.example.reto3.repository.MessageRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class MessageService {

    @Autowired
    private MessageRepository messageRepository;

    public List<Message> getAll(){return messageRepository.getAll();}
    public Optional<Message> getMessage(int id){return messageRepository.getMessage(id);}
    public Message save(Message a){
        if(a.getIdMessage()==null){
            return messageRepository.save(a);
        } else{
            Optional<Message> e = messageRepository.getMessage(a.getIdMessage());
            if (e.isPresent()){
                return a;
            } else {
                return messageRepository.save(a);
            }
        }
    }

    public Message update(Message a){
        if(a.getIdMessage()!= null){
            Optional<Message> q = messageRepository.getMessage(a.getIdMessage());
            if (q.isPresent()){
                if (a.getMessageText() != null){
                    q.get().setMessageText(a.getMessageText());
                }
                messageRepository.save(q.get());
                return q.get();
            } else {
                return a;
            }
        } else {
            return a;
        }
    }
    public boolean delete(int id){
        boolean flag=false;
        Optional<Message> a = messageRepository.getMessage(id);
        if (a.isPresent()){
            messageRepository.delete(a.get());
            flag =true;
        }
        return flag;
    }
}


