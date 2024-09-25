package management.property;

import management.interfaces.Requestable;
import java.util.Date;
public class MaintenanceRequest implements Requestable{
    int requestId;
    String StringDescription;
    Date requestDate;
    String status;

    public String processRequest(){
        return "failed";
    }
    public String updateRequest(){
        return "failed";
    }

    public boolean logRequest(){
        return false;
    }
}
