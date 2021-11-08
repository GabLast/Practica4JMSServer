package edu.pucmm.eict.Controllers;

import edu.pucmm.eict.Models.Message;
import edu.pucmm.eict.Services.MessageServices;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.messaging.handler.annotation.MessageMapping;
import org.springframework.messaging.handler.annotation.SendTo;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/")
public class WebSocketController {

    @Autowired
    private MessageServices messageServices;

    @MessageMapping("/socket")
    @SendTo("/messages/list")
    public Message sendList() {
        return messageServices.findLastInsert();
    }
}
