package management.property;

import management.interfaces.LeaseInterface;
import java.util.Date;

public class Lease implements LeaseInterface{
    private int leaseId;
    private Date startDate, enDate;
    private float rentAmount;   


    public boolean signLease(){
        return false;
    }

    public boolean terminateLease(){
        return false;
    }
    public boolean updateLease(){
        return false;
    }
public boolean deleteLease(){
        return false;
    }
}
