package ma.enset.gestion_abonnements.services;

import ma.enset.gestion_abonnements.entities.Client;

import java.util.List;
import java.util.Optional;

public interface ClientService {
    Client saveClient(Client client);
    void deleteClient(Long id);
    Client updateClient(Client client);
    Client getClient(Long id);
    List<Client> getClientList();

}
