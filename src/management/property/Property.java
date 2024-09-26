package management.property;

import management.interfaces.PropertyInterface;

public class Property implements PropertyInterface{
    private String propertyName;
    private String propertyType;
    private float price;

    public boolean createProperty(String propertyName, String propertyType, float price){
        this.propertyName = propertyName;
        this.propertyType = propertyType;
        this.price = price;
        System.out.println("----------------------------------------------------");
        System.out.println("|Property: "+  "\n" + "                               |"+
                        "|    Property Name: "+ propertyName + "\n" + "           |"+
                        "|    Property Type: "+ propertyType + "\n" + "           |"+
                        "|    Price: "+ price + "\n" + "                          |"+
                        "|Created                                                 |"+
                        "|---------------------------------------------------------");
        return true;
    }
    public boolean updatePropertyName(String propertyName){
        this.propertyName = propertyName;
        System.out.println("Property Name changed to: " + propertyName);
        return true;
    }
    public boolean updatePropertyType(String propertyType){
        this.propertyType = propertyType;
        System.out.println("Property Type changed to: " + propertyType);
        return true;
    }

    public boolean updatePrice(int propertyPrice){
        this.price = propertyPrice;
        System.out.println("Property Price changed to: " + propertyPrice);
        return true;
    }
    public boolean deleteProperty(){
        System.out.println("----------------------------------------------------");
        System.out.println("|Property: "+  "\n" + "                               |"+
                        "|    Property Name: "+ propertyName + "\n" + "           |"+
                        "|    Property Type: "+ propertyType + "\n" + "           |"+
                        "|    Price: "+ price + "\n" + "                          |"+
                        "|Deleted                                                 |"+
                        "|---------------------------------------------------------");
    return true;
    }
}