package edu.pucmm.eict.Controllers;

import edu.pucmm.eict.Models.GraphData;
import edu.pucmm.eict.Models.Message;
import edu.pucmm.eict.Services.MessageServices;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/messages")
public class MessagesController {

    @Autowired
    private MessageServices messageServices;

    @GetMapping("/list")
    public String list(Model model) {
//        model.addAttribute("list", messageServices.findAll());
        return "ListMessages";
    }

    @GetMapping("/list-nosocket")
    public String list2(Model model) {
        model.addAttribute("listamsg", messageServices.findAll());
        return "ListMessages2";
    }


    @GetMapping("/graph")
    public String viewgraphs(Model model) {

        boolean firstlap = true;
        long aux = -1;
        GraphData graphDataDevice1 = new GraphData();
        GraphData graphDataDevice2 = new GraphData();

        for(Message message : messageServices.findAll()){

            if(firstlap){
                aux = message.getIdDispositivo();
                firstlap = false;
            }

            if(message.getIdDispositivo() == aux){
                graphDataDevice1.setIdDispositivo(message.getIdDispositivo());
                graphDataDevice1.getTemps().add(message.getTemperatura());
                graphDataDevice1.getHumidities().add(message.getHumedad());
                graphDataDevice1.getTimes().add(message.getFechaGeneracion());
            }else {
                graphDataDevice2.setIdDispositivo(message.getIdDispositivo());
                graphDataDevice2.getTemps().add(message.getTemperatura());
                graphDataDevice2.getHumidities().add(message.getHumedad());
                graphDataDevice2.getTimes().add(message.getFechaGeneracion());
            }

        }

//        System.out.println(graphDataDevice1.getTemps().size() + "---> Total temps ---" + graphDataDevice1.getTimes().get(0).toLocalTime());

        model.addAttribute("dataDevice1", graphDataDevice1);
        model.addAttribute("dataDevice2", graphDataDevice2);

        model.addAttribute("sizeDataDevice1", graphDataDevice1.getTemps().size());
        model.addAttribute("sizeDataDevice2", graphDataDevice2.getTemps().size());

        return "ViewGraphs";
    }

}
