package management.property;

import management.interfaces.Requestable;
import java.util.Date;

public class Payment implements Requestable {
    private int paymentId;
    private float amount;
    private Date paymentDate;

    public boolean recordPayment(){
        return false;
    }

    public void generateInvoice(){
        
    }

    public String processRequest(){
        return "failed";
    }

    public boolean logRequest(){
        return false;
    }
}
