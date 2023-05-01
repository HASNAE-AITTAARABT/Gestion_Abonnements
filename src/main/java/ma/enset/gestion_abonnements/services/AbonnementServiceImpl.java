package ma.enset.gestion_abonnements.services;

import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import ma.enset.gestion_abonnements.entities.Abonnement;
import ma.enset.gestion_abonnements.entities.Client;
import ma.enset.gestion_abonnements.enums.TypeAbonnemnt;
import ma.enset.gestion_abonnements.exceptions.AbonnementNotFoundException;
import ma.enset.gestion_abonnements.exceptions.CustomerNotFoundException;
import ma.enset.gestion_abonnements.repositories.AbonnementRepository;
import ma.enset.gestion_abonnements.repositories.ClientRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Date;
import java.util.List;
import java.util.Optional;


@Service
@AllArgsConstructor
@Slf4j
public class AbonnementServiceImpl implements AbonnementService{
    private AbonnementRepository abonnementRepository;
    private ClientRepository clientRepository;

    @Override
    public Abonnement saveAbonnement(TypeAbonnemnt typeAbonnemnt, double solde, double montantMensuel, Long clientId) {
        Client client = clientRepository.findById(clientId).orElse(null);
        Abonnement abonnement = new Abonnement();
        abonnement.setTypeAbonnement(typeAbonnemnt);
        abonnement.setDateAbonnement(new Date());
        abonnement.setClient(client);
        abonnement.setSolde(solde);
        abonnement.setMontantMensuel(montantMensuel);
        return abonnementRepository.save(abonnement);
    }

    @Override
    public void deleteAbonnement(Long id) {
        abonnementRepository.deleteById(id);
    }

    @Override
    public Abonnement updateAbonnement(TypeAbonnemnt typeAbonnemnt, double solde, double montantMensuel, Long clientId) {
        return saveAbonnement(typeAbonnemnt, solde,montantMensuel,clientId);
    }

    @Override
    public Abonnement getAbonnement(Long id) {
        return abonnementRepository.findById(id).orElseThrow(()->new AbonnementNotFoundException("Abonnement Not Found"));
    }

    @Override
    public List<Abonnement> getAbonnementList() {
        return  abonnementRepository.findAll();
    }
}
