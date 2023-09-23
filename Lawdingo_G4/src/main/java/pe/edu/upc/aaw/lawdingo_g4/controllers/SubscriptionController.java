package pe.edu.upc.aaw.lawdingo_g4.controllers;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import pe.edu.upc.aaw.lawdingo_g4.dtos.SubscriptionDTO;
import pe.edu.upc.aaw.lawdingo_g4.dtos.UsersBySubscriptionDTO;
import pe.edu.upc.aaw.lawdingo_g4.entities.Subscription;
import pe.edu.upc.aaw.lawdingo_g4.serviceinterfaces.ISubscriptionService;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/subscription")
public class SubscriptionController {


    @Autowired
    private ISubscriptionService uS;

    @PostMapping
    public void create(@RequestBody SubscriptionDTO dto){
        ModelMapper m = new ModelMapper();
        Subscription c =m.map(dto,Subscription.class);
        uS.create(c);
    }

    @GetMapping("/name")
    public List<Subscription> list(@PathVariable String name) {
        return uS.list(name);
    }




    @GetMapping("/cantidausuarioporsuscripcion")
    public List<UsersBySubscriptionDTO>cantidausuarioporsuscripcion (){
        List<String[]> lista = uS.querieSubscription();
        List<UsersBySubscriptionDTO> listDTO = new ArrayList<>();
        for(String[] data : lista){
            UsersBySubscriptionDTO dto = new UsersBySubscriptionDTO();
            dto.setNameSubscription(data[0]);
            dto.setCountUsers(Integer.parseInt(data[1]));
            listDTO.add(dto);

        }
        return listDTO;
    }




    @DeleteMapping("/{id}")
    public void delete(@PathVariable("id") Integer id){
        uS.delete(id);
    }




}
