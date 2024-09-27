package management.interfaces;

import management.property.Property;

public interface PropertyInterface{
    abstract public Property createProperty();
    abstract public boolean updateProperty();
    abstract public boolean deleteProperty();
    abstract public String getPropertyName();
    abstract public String getPropertyType();
    abstract public float getPrice();
}
