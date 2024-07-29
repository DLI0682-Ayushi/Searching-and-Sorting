package AdditionalProblems;
 import java.util.ArrayList;
import java.util.Scanner;

class PolicyPremium {
    public String policyType;
    private double basePremium;
    private double riskFactor;
    private double calculatedPremium;

    public PolicyPremium(String policyType, double basePremium, double riskFactor) {
        this.policyType = policyType;
        this.basePremium = basePremium;
        this.riskFactor = riskFactor;
        this.calculatedPremium = calculatePremium();
    }

    public double calculatePremium() {
        return basePremium * riskFactor;
    }

    public void updateRiskFactor(double newRiskFactor) {
        this.riskFactor = newRiskFactor;
        this.calculatedPremium = calculatePremium();
    }

    public double getCalculatedPremium() {
        return calculatedPremium;
    }

    @Override
    public String toString() {
        return "Policy{" +
                "policyType='" + policyType + '\'' +
                ", basePremium=" + basePremium +
                ", riskFactor=" + riskFactor +
                ", calculatedPremium=" + calculatedPremium +
                '}';
    }
}

public class PremiumCalculation {
    private ArrayList<PolicyPremium> policies;

    public PremiumCalculation() {
        policies = new ArrayList<>();
    }

    public void addPolicy(PolicyPremium policyPremium) {
        policies.add(policyPremium);
    }

    public void updatePolicyRiskFactor(String policyType, double newRiskFactor) {
        for (PolicyPremium policyPremium : policies) {
            if (policyPremium.policyType.equals(policyType)) {
                policyPremium.updateRiskFactor(newRiskFactor);
                System.out.println("Risk factor updated for policy type: " + policyType);
                return;
            }
        }
        System.out.println("Policy type not found.");
    }

    public void generatePremiumReport() {
        for (PolicyPremium policyPremium : policies) {
            System.out.println(policyPremium);
        }
    }

    public static void main(String[] args) {
        PremiumCalculation system = new PremiumCalculation();
        Scanner scanner = new Scanner(System.in);

        while (true) {
            System.out.println("1. Add Policy");
            System.out.println("2. Update Policy Risk Factor");
            System.out.println("3. Generate Premium Report");
            System.out.println("4. Exit");
            System.out.print("Choose an option: ");
            int choice = scanner.nextInt();
            scanner.nextLine();  // Consume newline

            switch (choice) {
                case 1:
                    System.out.print("Enter policy type: ");
                    String policyType = scanner.nextLine();
                    System.out.print("Enter base premium: ");
                    double basePremium = scanner.nextDouble();
                    System.out.print("Enter risk factor: ");
                    double riskFactor = scanner.nextDouble();
                    scanner.nextLine();  // Consume newline
                    PolicyPremium policyPremium = new PolicyPremium(policyType, basePremium, riskFactor);
                    system.addPolicy(policyPremium);
                    break;
                case 2:
                    System.out.print("Enter policy type: ");
                    String updatePolicyType = scanner.nextLine();
                    System.out.print("Enter new risk factor: ");
                    double newRiskFactor = scanner.nextDouble();
                    scanner.nextLine();  // Consume newline
                    system.updatePolicyRiskFactor(updatePolicyType, newRiskFactor);
                    break;
                case 3:
                    system.generatePremiumReport();
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
