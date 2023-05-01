package ma.enset.gestion_abonnements.repositories;

import ma.enset.gestion_abonnements.entities.Abonnement;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AbonnementRepository extends JpaRepository<Abonnement,Long> {

}
