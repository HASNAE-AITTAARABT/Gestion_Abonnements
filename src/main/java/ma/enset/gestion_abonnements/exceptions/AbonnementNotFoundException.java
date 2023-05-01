package ma.enset.gestion_abonnements.exceptions;

import ma.enset.gestion_abonnements.entities.Abonnement;

public class AbonnementNotFoundException extends RuntimeException {
    public AbonnementNotFoundException(String exceptionMessage){
        super(exceptionMessage);
    }
}
