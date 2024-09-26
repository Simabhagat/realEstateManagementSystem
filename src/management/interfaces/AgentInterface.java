package management.interfaces;

public interface AgentInterface {
    abstract public boolean createProperty();
    abstract public boolean updateProperty();
    abstract public boolean deleteProperty();
    abstract public void disableProperty();
    abstract public boolean createLease();
    abstract public boolean updateLease();
    abstract public boolean deleteLease();
    
}
