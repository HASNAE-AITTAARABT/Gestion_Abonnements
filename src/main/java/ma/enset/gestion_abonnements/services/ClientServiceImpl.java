package ma.enset.gestion_abonnements.services;

import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import ma.enset.gestion_abonnements.entities.Client;
import ma.enset.gestion_abonnements.exceptions.CustomerNotFoundException;
import ma.enset.gestion_abonnements.repositories.ClientRepository;
import org.springframework.stereotype.Service;

import java.util.List;


@Service
@AllArgsConstructor
@Slf4j
public class ClientServiceImpl implements ClientService{
    private ClientRepository clientRepository;

    @Override
    public Client saveClient(Client client) {
        return  clientRepository.save(client);
    }

    @Override
    public void deleteClient(Long id) {
        clientRepository.deleteById(id);
    }

    @Override
    public Client updateClient(Client client) {
        return  clientRepository.save(client);
    }

    @Override
    public Client getClient(Long id) {
    Client client = clientRepository.findById(id).orElseThrow(()->new CustomerNotFoundException("Client Not Found"));
    return client;
    }

    @Override
    public List<Client> getClientList() {
        List<Client> clients = clientRepository.findAll();
        return clients;
    }
}
