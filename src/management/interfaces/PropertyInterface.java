package management.interfaces;

public interface PropertyInterface{
    abstract public boolean createProperty(String propertyName, String propertyType, float price);
    abstract public boolean updatePropertyName(String propertyName);
    abstract public boolean updatePropertyType(String propertyType);
    abstract public boolean updatePrice(int propertyPrice);
    abstract public boolean deleteProperty();
 
}
