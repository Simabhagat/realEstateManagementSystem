package management.user;

import management.interfaces.AgentInterface;
import management.property.Property;
import java.util.Scanner;
import java.util.ArrayList;

public class Agent extends Tenant implements AgentInterface {
    static Scanner scan = new Scanner(System.in);

    // each agent will have their own properties listed
    ArrayList<Property> properties = new ArrayList<Property>();

    public Agent(String username, String password, int contactNumber) {
        super(username, password, contactNumber);
    }

    public boolean createProperty() {
        Property property = new Property();
        property = property.createProperty();
        properties.add(property);
        return true;
    }

    public boolean updateProperty() {
        showPropertyListing();
        System.out.println("Select the index of the property to update: ");
        int index = scan.nextInt();

        if(index>=0 && index<properties.size()){
            properties.get(index).updateProperty();
            return true;
        }
        System.out.println("Invalid index selected. ");
        return false;
    }

    public boolean deleteProperty() {
        System.out.println("Select a current property from the list of properties: ");
        showPropertyListing();
        int index = scan.nextInt();
        if(index >=0 && index < properties.size()) {
            properties.get(index).deleteProperty();
            properties.remove(index);
            showPropertyListing();
            return true;
        }
        System.out.println("Select a valid index. ");
        return false;
    }

    public void showPropertyListing(){
        if(properties.isEmpty()){
            System.out.println("----------------------------------------------------");
            System.out.println("| Property Listing:                                  |");
            System.out.println("| No properties listed currently.                    |");
            System.out.println("----------------------------------------------------");
        }
        else{
            System.out.println("----------------------------------------------------");
            System.out.println("| Property Listing:                                  |");
            for(int i = 0; i< properties.size(); i++){
                Property p = properties.get(i);
                System.out.println("----------------------------------------------------");
                System.out.println("| Index: " + i);
                System.out.println("| Property Name: " + p.getPropertyName());
                System.out.println("| Property Type: " + p.getPropertyType());
                System.out.println("| Price: " + p.getPrice());
            } 
            System.out.println("----------------------------------------------------");

        }
    }

    public void disableProperty() {

    }

    public boolean createLease() {
        return false;
    }

    public boolean updateLease() {
        return false;
    }

    public boolean deleteLease() {
        return false;
    }
}