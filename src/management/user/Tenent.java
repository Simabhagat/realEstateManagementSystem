package management.user;

import management.interfaces.Manageable;

public class Tenent implements Manageable
{
    private String username;
    private int contactNumber;
    private String password;

    public boolean register(String username, String password, boolean isAgent){
        return false;
    }
    public boolean login(String username, String password){
        return this.username == username && this.password == password;
    }

    public boolean logout() {
        return false;
    }

    public int getContact(){
        return this.contactNumber;
    }

}
