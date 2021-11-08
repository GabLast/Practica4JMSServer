package edu.pucmm.eict.Services;

import edu.pucmm.eict.Models.Message;
import edu.pucmm.eict.Repositories.MessageRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class MessageServices {

    @Autowired
    MessageRepository  messageRepository;
    @Value("${mode}")
    private String url;

    @Transactional()
    public void insert(Message message){

        messageRepository.save(message);
    }

    public List<Message> findAll(){
        return messageRepository.findAll();
    }

    public Message findLastInsert() {
        return findAll().get(findAll().size()-1);
    }


    public String getUrl() {
        return url;
    }
}
