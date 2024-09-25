package management.interfaces;

public interface LeaseInterface {
    abstract public boolean signLease();
    abstract public boolean terminateLease();
    abstract public boolean updateLease();
    abstract public boolean deleteLease();
}
