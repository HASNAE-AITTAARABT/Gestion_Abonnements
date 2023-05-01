package ma.enset.gestion_abonnements.repositories;

import ma.enset.gestion_abonnements.entities.Client;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ClientRepository  extends JpaRepository<Client,Long> {
    public Page<Client> findByNomContains(String keyword, Pageable pageable);
}
