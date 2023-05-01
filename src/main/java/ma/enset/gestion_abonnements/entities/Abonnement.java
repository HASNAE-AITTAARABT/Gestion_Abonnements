package ma.enset.gestion_abonnements.entities;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import ma.enset.gestion_abonnements.enums.TypeAbonnemnt;

import java.util.Date;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Abonnement {
    @Id
    @GeneratedValue( strategy = GenerationType.IDENTITY)
    private Long id;
    @Temporal(TemporalType.DATE)
    private Date dateAbonnement;
    @Enumerated(EnumType.STRING)
    private TypeAbonnemnt typeAbonnement;
    private double solde;
    private double montantMensuel;
    @ManyToOne()
    private Client client;
}
