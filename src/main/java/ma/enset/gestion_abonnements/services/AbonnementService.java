package ma.enset.gestion_abonnements.services;

import ma.enset.gestion_abonnements.entities.Abonnement;
import ma.enset.gestion_abonnements.entities.Client;
import ma.enset.gestion_abonnements.enums.TypeAbonnemnt;

import java.util.List;
import java.util.Optional;

public interface AbonnementService {

    Abonnement saveAbonnement(TypeAbonnemnt typeAbonnemnt,double solde, double montantMensuel , Long clientId );
    void deleteAbonnement(Long id);
    Abonnement updateAbonnement(TypeAbonnemnt typeAbonnemnt,double solde, double montantMensuel , Long clientId );
    Abonnement getAbonnement(Long id);
    List<Abonnement> getAbonnementList();
}
