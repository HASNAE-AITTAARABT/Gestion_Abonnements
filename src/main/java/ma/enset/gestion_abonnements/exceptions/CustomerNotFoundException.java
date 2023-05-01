package ma.enset.gestion_abonnements.exceptions;

public class CustomerNotFoundException extends RuntimeException {
    public CustomerNotFoundException(String exceptionMessage){
        super(exceptionMessage);
    }
}
