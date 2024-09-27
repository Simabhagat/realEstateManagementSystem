package management.property;

import management.interfaces.PropertyInterface;
import java.util.Scanner;

public class Property implements PropertyInterface {
    private static final Scanner scan = new Scanner(System.in); // Shared scanner, not to be closed
    private String propertyName;
    private String propertyType;
    private float price;

    // Method to create a new property object
    public Property createProperty() {
        System.out.println("Enter property name: ");
        this.propertyName = scan.next();
        System.out.println("Enter property type: ");
        this.propertyType = scan.next();
        System.out.println("Enter leasing price: ");
        this.price = scan.nextFloat();  // Use nextFloat for float type
        
        System.out.println("----------------------------------------------------");
        System.out.println("|Property:\n" +
                           "|    Property Name: " + propertyName + "\n" +
                           "|    Property Type: " + propertyType + "\n" +
                           "|    Price: " + price + "\n" +
                           "|Created \n" +
                           "|---------------------------------------------------------");
        
        return this; // Return the current object
    }

    // Method to update property details
    public boolean updateProperty() {
        int choice;
        System.out.println("Select a field to update: \n" +
                            "  1. Property name. \n" +
                            "  2. Property type. \n" +
                            "  3. Leasing price. \n");
        choice = scan.nextInt();

        switch (choice) {
            case 1:
                System.out.println("Enter new property name: ");
                this.propertyName = scan.next();
                System.out.println("Property name changed successfully. ");
                break;
            case 2:
                System.out.println("Enter new property type: ");
                this.propertyType = scan.next();
                System.out.println("Property type changed successfully. ");
                break;
            case 3:
                System.out.println("Enter new leasing price: ");
                this.price = scan.nextFloat();
                System.out.println("Property leasing price changed successfully. ");
                break; // Adding break to avoid fall-through
            default:
                System.out.println("Enter a valid option");
                return false; // Indicate unsuccessful update due to invalid input
        }
        
        System.out.println("Property updated successfully.");
        return true; // Indicate a successful update
    }

    // Method to delete property (Just for display here, no real deletion logic)
    public boolean deleteProperty() {
        System.out.println("----------------------------------------------------");
        System.out.println("|Property: \n" +
                           "|    Property Name: " + propertyName + "\n" +
                           "|    Property Type: " + propertyType + "\n" +
                           "|    Price: " + price + "\n" +
                           "|Deleted \n" +
                           "|---------------------------------------------------------");
        return true;
    }

    public String getPropertyName() {
        return this.propertyName;
    }

    public String getPropertyType() {
        return this.propertyType;
    }

    public float getPrice() {
        return this.price;
    }
}
