package ma.enset.gestion_abonnements.web;

import lombok.AllArgsConstructor;
import ma.enset.gestion_abonnements.entities.Client;
import ma.enset.gestion_abonnements.exceptions.CustomerNotFoundException;
import ma.enset.gestion_abonnements.repositories.ClientRepository;
import ma.enset.gestion_abonnements.services.ClientServiceImpl;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@AllArgsConstructor
@RestController
public class ClientRestController {
    ClientServiceImpl clientService;
    ClientRepository clientRepository;

    @GetMapping("/clients")
    List<Client> getClientList(){
        List<Client> clients = clientService.getClientList();
        return clients;
    }
    @GetMapping("/clients/{id}")
    public Client getClient(@PathVariable(name = "id") Long clientId) throws CustomerNotFoundException {
        Client client= clientService.getClient(clientId);
        return client;
    }

    @PostMapping("/clients")
    public Client SaveClient(@RequestBody Client client){
        Client client1= clientService.saveClient(client);
        return client1;
    }

    @PutMapping("/clients/{id}")
    public Client UpdateClient(@RequestBody Client client, @PathVariable(name = "id") Long clientId){
        client.setId(clientId);
        Client client1 = clientService.saveClient(client);
        return client1;
    }


    @DeleteMapping("/clients/{id}")
    public  void DeleteClient(@PathVariable(name = "id") Long id){
        clientService.deleteClient(id);
    }

}
