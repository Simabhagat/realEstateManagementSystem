package management.interfaces;

import java.lang.String;

public interface Manageable {
    abstract public boolean login(String username,String password);
    abstract public boolean logout();
    abstract public boolean register(String username, String password, boolean isAgent,int contactNumber);
    abstract public int getContact();
}
