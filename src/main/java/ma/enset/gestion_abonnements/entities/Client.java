package ma.enset.gestion_abonnements.entities;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;


@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Client {

    @Id @GeneratedValue( strategy = GenerationType.IDENTITY)
    private Long id;
    private  String nom;
    private  String email;
    private  String username;
    @OneToMany(mappedBy = "client",fetch = FetchType.LAZY)
    private List<Abonnement> abonnements;
}
