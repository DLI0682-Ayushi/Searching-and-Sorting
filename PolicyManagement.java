package AdditionalProblems;

import java.util.ArrayList;
import java.util.Scanner;

class policy {
    private String policyNumber;
    private String policyholderName;
    private String insuranceType;
    private double coverageAmount;

    public policy(String policyNumber, String policyholderName, String insuranceType, double coverageAmount) {
        this.policyNumber = policyNumber;
        this.policyholderName = policyholderName;
        this.insuranceType = insuranceType;
        this.coverageAmount = coverageAmount;
    }

    public String getPolicyNumber() {
        return policyNumber;
    }

    public String getInsuranceType() {
        return insuranceType;
    }

    public void setPolicyholderName(String policyholderName) {
        this.policyholderName = policyholderName;
    }

    public void setInsuranceType(String insuranceType) {
        this.insuranceType = insuranceType;
    }

    public void setCoverageAmount(double coverageAmount) {
        this.coverageAmount = coverageAmount;
    }

    @Override
    public String toString() {
        return "Policy{" +
                "policyNumber='" + policyNumber + '\'' +
                ", policyholderName='" + policyholderName + '\'' +
                ", insuranceType='" + insuranceType + '\'' +
                ", coverageAmount=" + coverageAmount +
                '}';
    }
}

public class PolicyManagement {
    private ArrayList<policy> policies;

    public PolicyManagement() {
        policies = new ArrayList<>();
    }

    public void addPolicy(policy policy) {
        policies.add(policy);
    }

    public void removePolicyByNumber(String policyNumber) {
        policies.removeIf(policy -> policy.getPolicyNumber().equals(policyNumber));
    }

    public void updatePolicyDetails(String policyNumber, String policyholderName, String insuranceType, double coverageAmount) {
        for (AdditionalProblems.policy policy : policies) {
            if (policy.getPolicyNumber().equals(policyNumber)) {
                policy.setPolicyholderName(policyholderName);
                policy.setInsuranceType(insuranceType);
                policy.setCoverageAmount(coverageAmount);
                System.out.println("Policy details updated.");
                return;
            }
        }
        System.out.println("Policy not found.");
    }

    public void listPoliciesByType(String insuranceType) {
        for (AdditionalProblems.policy policy : policies) {
            if (policy.getInsuranceType().equals(insuranceType)) {
                System.out.println(policy);
            }
        }
    }

    public static void main(String[] args) {
        PolicyManagement system = new PolicyManagement();
        Scanner scanner = new Scanner(System.in);

        while (true) {
            System.out.println("1. Add Policy");
            System.out.println("2. Remove Policy by Number");
            System.out.println("3. Update Policy Details");
            System.out.println("4. List Policies by Type");
            System.out.println("5. Exit");
            System.out.print("Choose an option: ");
            int choice = scanner.nextInt();
            scanner.nextLine();  // Consume newline

            switch (choice) {
                case 1:
                    System.out.print("Enter policy number: ");
                    String policyNumber = scanner.nextLine();
                    System.out.print("Enter policyholder's name: ");
                    String policyholderName = scanner.nextLine();
                    System.out.print("Enter insurance type: ");
                    String insuranceType = scanner.nextLine();
                    System.out.print("Enter coverage amount: ");
                    double coverageAmount = scanner.nextDouble();
                    scanner.nextLine();  // Consume newline
                    policy policy = new policy(policyNumber, policyholderName, insuranceType, coverageAmount);
                    system.addPolicy(policy);
                    break;
                case 2:
                    System.out.print("Enter policy number: ");
                    String removePolicyNumber = scanner.nextLine();
                    system.removePolicyByNumber(removePolicyNumber);
                    break;
                case 3:
                    System.out.print("Enter policy number: ");
                    String updatePolicyNumber = scanner.nextLine();
                    System.out.print("Enter new policyholder's name: ");
                    String newPolicyholderName = scanner.nextLine();
                    System.out.print("Enter new insurance type: ");
                    String newInsuranceType = scanner.nextLine();
                    System.out.print("Enter new coverage amount: ");
                    double newCoverageAmount = scanner.nextDouble();
                    scanner.nextLine();  // Consume newline
                    system.updatePolicyDetails(updatePolicyNumber, newPolicyholderName, newInsuranceType, newCoverageAmount);
                    break;
                case 4:
                    System.out.print("Enter insurance type: ");
                    String listInsuranceType = scanner.nextLine();
                    system.listPoliciesByType(listInsuranceType);
                    break;
                case 5:
                    System.out.println("Exiting...");
                    return;
                default:
                    System.out.println("Invalid choice. Please try again.");
            }
        }
    }
}
