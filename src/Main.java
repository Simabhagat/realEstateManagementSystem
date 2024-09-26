import java.util.Scanner;
import java.util.ArrayList;
import management.user.*;

public class Main {
    static Scanner scan = new Scanner(System.in);
    public static void main(String[] args) {
        Tenant tenant = null;  //this will be used to validate session
        Agent agent = null;    //this will be used to validate session
        Database db = new Database();
        String username, password;
        int contact,choice;

        while (true) {
            if(tenant != null){ //user interface after login as tenant
                System.out.println("Welcome, " + tenant.getUsername() + "! " + "\n" + 
                        "Menu: " + "\n" + 
                        "     1. View My Details \n" + 
                        "     2. Show property Lists \n"+
                        "     3. Apply for leasing \n"+
                        "     4. logout\n ");
                choice = scan.nextInt();
                switch (choice) {
                    case 1:
                        System.out.println("Username: " + tenant.getUsername());
                        System.out.println("Contact Number: " + tenant.getContact());
                        break;
                    case 2:
                        System.out.println("Showing property listing: ...");
                        break;
                    case 3:
                        System.out.println("applied for leasing");
                        break;
                    case 4:
                        tenant = null;
                        System.out.println("Logged out successfully.");
                        break;
                    default:
                        System.out.println("Invalid choice. Please select 1 or 2.");
                } waitForInput();
            }
            else if(agent!= null){ //user interface after login as agent
                System.out.println("Welcome, " + agent.getUsername() + "! " + "\n" + 
                        "Menu: " + "\n" + 
                        "     1. View My Details \n" + 
                        "     2. Show Property Listing \n" + 
                        "     3. View lease requests\n" +
                        "     4. Add Property \n" + 
                        "     5. Remove Property \n" + 
                        "     6. Edit Property \n" + 
                        "     7. Logout \n" );
                choice = scan.nextInt();
                switch (choice) {
                    case 1:
                        System.out.println("Username: " + agent.getUsername());
                        System.out.println("Contact Number: " + agent.getContact());
                        break;
                    case 2:
                        System.out.println("Showing property listing: ...");
                        break;
                    case 3:
                        System.out.println("Show property lease request: ...");
                        break;
                    case 4:
                        System.out.println("Add property: ...");
                        break;
                    case 5:
                        System.out.println("Remove property: ...");
                        break;
                    case 6:
                        System.out.println("edit property: ...");
                        break;
                    case 7:
                        agent = null;
                        System.out.println("Logged out successfully.");
                        break;
                } waitForInput(); 
            }
            else{   //user interface before login 
                System.out.println("Menu: " + "\n" + 
                "     1. Login \n" + 
                "     2. Register  \n"+
                "     3. Exit Application \n");
                choice = scan.nextInt();
                switch (choice) {
                    case 1:
                        System.out.println("Select type of account:");
                        System.out.println("1. Tenant");
                        System.out.println("2. Agent");
                        System.out.print("Enter your choice: ");
                        int loginType = scan.nextInt();
                        
                        switch (loginType) {
                            case 1:
                                System.out.println("You have chosen to login as Tenant.");
                                // Handle tenant login logic here
                                break;
                            case 2:
                                System.out.println("You have chosen to login as Agent.");
                                // Handle agent login logic here
                                break;
                            default:
                                System.out.println("Invalid choice. Please select 1 or 2.");
                        } waitForInput();
                        break;
        
                    case 2:
                        System.out.println("Select which type of account to create:");
                        System.out.println("1. Tenant");
                        System.out.println("2. Agent");
                        System.out.print("Enter your choice: ");
                        int registerType = scan.nextInt();
                        
                        switch (registerType) {
                            case 1:
                                System.out.println("You have chosen to register as Tenant.");
                                System.out.println("Enter your username: ");
                                username = scan.next();
                                System.out.println("Enter your password: ");
                                password = scan.next();
                                System.out.println("Enter your contact information: ");
                                contact = scan.nextInt();
                                //calling function to add a new tenant in Tenants array list
                                tenant = db.AddTenentAccount(username, password, contact);
                                if(tenant == null){
                                    System.out.println("Failed to create a tenant");
                                }
                                System.out.println("Account successfully created. ");
                                break;
                            case 2:
                                System.out.println("You have chosen to register as Agent.");
                                System.out.println("Enter your username: ");
                                username = scan.next();
                                System.out.println("Enter your password: ");
                                password = scan.next();
                                System.out.println("Enter your contact information: ");
                                contact = scan.nextInt();
                                //calling function to add a new agent in agents array list
                                agent = db.AddAgentAccount(username, password, contact);
                                if(agent == null){
                                    System.out.println("Failed to create an agent");
                                }
                                System.out.println("Account successfully created. ");
                                break;
                            default:
                                System.out.println("Invalid choice. Please select 1 or 2.");
                        }
                        break;
        
                    case 3:
                        System.out.println("Exiting App. Goodbye!");
                        scan.close(); 
                        return; 
        
                    default:
                        System.out.println("Invalid choice. Please select 1 or 2.");
                    } waitForInput();
                }
            }
    }

    //this method is used to wait an input before continuing execution
    public static void waitForInput(){
        System.out.println("Press Enter to continue...");
        scan.nextLine();
    }
}

class Database{
    private ArrayList<Tenant> tenants = new  ArrayList<Tenant>();
    private ArrayList<Agent> agents = new ArrayList<Agent>();
    public Tenant AddTenentAccount(String username, String password , int contact){
        Tenant tenant = new Tenant(username, password, contact);
        tenants.add(tenant);
        return tenant;
    }
    public Agent AddAgentAccount(String username, String password,int contact){
        Agent agent = new Agent(username, password, contact);
        agents.add(agent);
        return agent;
    }

}