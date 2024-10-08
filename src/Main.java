import java.util.Scanner;
import java.util.ArrayList;
import management.user.*;


//The main driver for our program
public class Main {
    static Scanner scan = new Scanner(System.in);
    public static void main(String[] args) {
        Tenant tenant = null;  //this will be used to validate session
        Agent agent = null;    //this will be used to validate session
        Database db = new Database();   //this object will handle read and write operations on the arraylists of tenant and agents
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
                       //this will show all properties  of different agents
                        db.showPropertyListing();
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
                        agent.showPropertyListing();
                        break;
                    case 3:
                        System.out.println("Show property lease request: ...");
                        break;
                    case 4:
                        agent.createProperty();
                        break;
                    case 5:
                        agent.deleteProperty();
                        break;
                    case 6:
                        agent.updateProperty();
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
                                System.out.println("Enter your username: ");
                                username = scan.next();
                                System.out.println("Enter your password: ");
                                password = scan.next();
                                //calling function to validate tenant login credentials in Tenants array list
                                tenant = db.ValidateTenantLogin(username, password);
                                if(tenant == null){
                                    System.out.println("Invalid credentials.");
                                }else{
                                    System.out.println("Logged in successfully as Tenant.");
                                }
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
        scan.nextLine(); //to handle enter key after a numeric input
    }
}

class Database{
    private ArrayList<Tenant> tenants = new  ArrayList<Tenant>();
    private ArrayList<Agent> agents = new ArrayList<Agent>();
    public Tenant AddTenentAccount(String username, String password , int contact){
        Tenant tenant = new Tenant(username, password, contact);
        tenants.add(tenant);
        System.out.println(tenants.get(0).getUsername());
        return tenant;
    }
    public Agent AddAgentAccount(String username, String password,int contact){
        Agent agent = new Agent(username, password, contact);
        agents.add(agent);
        return agent;
    }

    public Tenant ValidateTenantLogin(String username, String password){
        for(Tenant tenant : tenants){
            if(tenant.getUsername().equals(username)){
                System.out.println("test in login if");
                return tenant;
            }
        }
        return null;
    }

    public void showPropertyListing(){
        System.out.println("Showing property listing: ..."); 
        for(Agent agent : agents){
            System.out.println("Agent: " + agent.getUsername());
            agent.showPropertyListing();
        }
    }
}