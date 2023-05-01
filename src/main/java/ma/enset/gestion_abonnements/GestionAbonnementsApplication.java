package ma.enset.gestion_abonnements;

import ma.enset.gestion_abonnements.entities.Abonnement;
import ma.enset.gestion_abonnements.entities.Client;
import ma.enset.gestion_abonnements.enums.TypeAbonnemnt;
import ma.enset.gestion_abonnements.repositories.AbonnementRepository;
import ma.enset.gestion_abonnements.repositories.ClientRepository;
import ma.enset.gestion_abonnements.services.AbonnementService;
import ma.enset.gestion_abonnements.services.ClientServiceImpl;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import java.util.Date;
import java.util.List;
import java.util.stream.Stream;

@SpringBootApplication
public class GestionAbonnementsApplication {


    public static void main(String[] args) {
        SpringApplication.run(GestionAbonnementsApplication.class, args);
    }

    @Bean
    CommandLineRunner commandLineRunner(ClientServiceImpl clientService, AbonnementService abonnementService) {
        return args -> {
            Stream.of("hasnae","abderrahmane","mohame").forEach(name->{
                Client client = new Client();
                client.setNom(name);
                client.setEmail(name+"@gmail.com");
                client.setUsername(name+"1");
                clientService.saveClient(client);
            });
            List<Client> clients = clientService.getClientList();
            clients.forEach(c -> {
                abonnementService.saveAbonnement(TypeAbonnemnt.GSM,Math.random()*15000,Math.random()*564060,c.getId());
            });

        };
    }
}
