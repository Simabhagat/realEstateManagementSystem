package management.user;

import management.interfaces.AgentInterface;

public class Agent extends Tenant implements AgentInterface
{
     public Agent(String username, String password, int contactNumber) {
      super(username, password, contactNumber);
   }
   public boolean createProperty(){
        return false;
     } 
     public boolean updateProperty(){
        return false;
     }
     public boolean deleteProperty(){
        return false;
     }
     public void disableProperty(){

     }
     public boolean createLease(){
        return false;
     }
     public boolean updateLease(){
        return false;
     }
     public boolean deleteLease(){
        return false;
     }
}