package management.user;

import management.interfaces.Manageable;

public class Tenant implements Manageable
{
    private String username;
    private int contactNumber;
    private String password;

    public Tenant(String username, String password, int contactNumber){
        this.username = username;
        this.contactNumber = contactNumber;
        this.password = password;
        System.out.println("Tenant account created:  "+ this.username);
    }
    public boolean login(String username, String password){
        return this.username == username && this.password == password;
    } 
            
    public boolean logout() {
        System.out.println("You logged out successfully. ");
        return false;
    }

    public int getContact(){
        return this.contactNumber;
    }

    public String getUsername(){
        return this.username;
    }

}
