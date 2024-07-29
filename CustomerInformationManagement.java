package AdditionalProblems;
import java.util.ArrayList;
import java.util.Scanner;

class Policy {
    private String policyNumber;
    private String insuranceType;
    private double coverageAmount;

    public Policy(String policyNumber, String insuranceType, double coverageAmount) {
        this.policyNumber = policyNumber;
        this.insuranceType = insuranceType;
        this.coverageAmount = coverageAmount;
    }

    @Override
    public String toString() {
        return "Policy{" +
                "policyNumber='" + policyNumber + '\'' +
                ", insuranceType='" + insuranceType + '\'' +
                ", coverageAmount=" + coverageAmount +
                '}';
    }
}

class Customer {
    private String customerID;
    private String name;
    private String address;
    private String phoneNumber;
    private ArrayList<policy> policies;

    public Customer(String customerID, String name, String address, String phoneNumber) {
        this.customerID = customerID;
        this.name = name;
        this.address = address;
        this.phoneNumber = phoneNumber;
        this.policies = new ArrayList<>();
    }

    public String getCustomerID() {
        return customerID;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public void addPolicy(policy policy) {
        policies.add(policy);
    }

    public ArrayList<policy> getPolicies() {
        return policies;
    }

    @Override
    public String toString() {
        return "Customer{" +
                "customerID='" + customerID + '\'' +
                ", name='" + name + '\'' +
                ", address='" + address + '\'' +
                ", phoneNumber='" + phoneNumber + '\'' +
                ", policies=" + policies +
                '}';
    }
}

public class CustomerInformationManagement {
    private ArrayList<Customer> customers;

    public CustomerInformationManagement() {
        customers = new ArrayList<>();
    }

    public void addCustomer(Customer customer) {
        customers.add(customer);
    }

    public void updateCustomerDetails(String customerID, String name, String address, String phoneNumber) {
        for (Customer customer : customers) {
            if (customer.getCustomerID().equals(customerID)) {
                customer.setName(name);
                customer.setAddress(address);
                customer.setPhoneNumber(phoneNumber);
                System.out.println("Customer details updated.");
                return;
            }
        }
        System.out.println("Customer not found.");
    }

    public void retrievePolicies(String customerID) {
        for (Customer customer : customers) {
            if (customer.getCustomerID().equals(customerID)) {
                System.out.println("Policies for customer " + customerID + ": " + customer.getPolicies());
                return;
            }
        }
        System.out.println("Customer not found.");
    }

    public static void main(String[] args) {
        CustomerInformationManagement system = new CustomerInformationManagement();
        Scanner scanner = new Scanner(System.in);

        while (true) {
            System.out.println("1. Add Customer");
            System.out.println("2. Update Customer Details");
            System.out.println("3. Retrieve Policies");
            System.out.println("4. Exit");
            System.out.print("Choose an option: ");
            int choice = scanner.nextInt();
            scanner.nextLine();  // Consume newline

            switch (choice) {
                case 1:
                    System.out.print("Enter customer ID: ");
                    String customerID = scanner.nextLine();
                    System.out.print("Enter name: ");
                    String name = scanner.nextLine();
                    System.out.print("Enter address: ");
                    String address = scanner.nextLine();
                    System.out.print("Enter phone number: ");
                    String phoneNumber = scanner.nextLine();
                    Customer customer = new Customer(customerID, name, address, phoneNumber);
                    system.addCustomer(customer);
                    break;
                case 2:
                    System.out.print("Enter customer ID: ");
                    String updateCustomerID = scanner.nextLine();
                    System.out.print("Enter new name: ");
                    String newName = scanner.nextLine();
                    System.out.print("Enter new address: ");
                    String newAddress = scanner.nextLine();
                    System.out.print("Enter new phone number: ");
                    String newPhoneNumber = scanner.nextLine();
                    system.updateCustomerDetails(updateCustomerID, newName, newAddress, newPhoneNumber);
                    break;
                case 3:
                    System.out.print("Enter customer ID: ");
                    String retrieveCustomerID = scanner.nextLine();
                    system.retrievePolicies(retrieveCustomerID);
                    break;
                case 4:
                    System.out.println("Exiting...");
                    return;
                default:
                    System.out.println("Invalid choice. Please try again.");
            }
        }
    }
}
