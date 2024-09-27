

import management.user.Agent;

public class Test {
    public static void main(String[] args) {
        // Create an agent object
        Agent agent = new Agent("john_doe", "password123", 123456789);

        // Create a property for the agent
        System.out.println("Creating a property:");
        agent.createProperty();
        
        // Show the property listing
        System.out.println("Current property listing:");
        agent.showPropertyListing();

        // Update the property
        System.out.println("Updating the first property:");
        agent.updateProperty();

        // Show the property listing after the update
        System.out.println("Property listing after update:");
        agent.showPropertyListing();

        // Delete the property
        System.out.println("Deleting the first property:");
        agent.deleteProperty();

        // Show the property listing after deletion
        System.out.println("Property listing after deletion:");
        agent.showPropertyListing();
    }
}
