package edu.pucmm.eict.Services;

import edu.pucmm.eict.Models.Message;
import edu.pucmm.eict.Repositories.MessageRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class MessageServices {

    @Autowired
    MessageRepository  messageRepository;

    public List<Message> findAll(){
        return messageRepository.findAll();
    }
}
