package AdditionalProblems;
import java.util.ArrayList;
import java.util.Scanner;

class Claim {
    private String claimNumber;
    private String policyNumber;
    private String claimantName;
    private double claimAmount;
    private String status;

    public Claim(String claimNumber, String policyNumber, String claimantName, double claimAmount, String status) {
        this.claimNumber = claimNumber;
        this.policyNumber = policyNumber;
        this.claimantName = claimantName;
        this.claimAmount = claimAmount;
        this.status = status;
    }

    public String getClaimNumber() {
        return claimNumber;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getStatus() {
        return status;
    }

    @Override
    public String toString() {
        return "Claim{" +
                "claimNumber='" + claimNumber + '\'' +
                ", policyNumber='" + policyNumber + '\'' +
                ", claimantName='" + claimantName + '\'' +
                ", claimAmount=" + claimAmount +
                ", status='" + status + '\'' +
                '}';
    }
}

public class ClaimTrackingSystem {
    private ArrayList<Claim> claims;

    public ClaimTrackingSystem() {
        claims = new ArrayList<>();
    }

    public void addClaim(Claim claim) {
        claims.add(claim);
    }

    public void updateClaimStatus(String claimNumber, String newStatus) {
        for (Claim claim : claims) {
            if (claim.getClaimNumber().equals(claimNumber)) {
                claim.setStatus(newStatus);
                System.out.println("Claim status updated.");
                return;
            }
        }
        System.out.println("Claim not found.");
    }

    public void generateReport() {
        for (Claim claim : claims) {
            System.out.println(claim);
        }
    }

    public static void main(String[] args) {
        ClaimTrackingSystem system = new ClaimTrackingSystem();
        Scanner scanner = new Scanner(System.in);

        while (true) {
            System.out.println("1. Add Claim");
            System.out.println("2. Update Claim Status");
            System.out.println("3. Generate Report");
            System.out.println("4. Exit");
            System.out.print("Choose an option: ");
            int choice = scanner.nextInt();
            scanner.nextLine();  // Consume newline

            switch (choice) {
                case 1:
                    System.out.print("Enter claim number: ");
                    String claimNumber = scanner.nextLine();
                    System.out.print("Enter policy number: ");
                    String policyNumber = scanner.nextLine();
                    System.out.print("Enter claimant name: ");
                    String claimantName = scanner.nextLine();
                    System.out.print("Enter claim amount: ");
                    double claimAmount = scanner.nextDouble();
                    scanner.nextLine();  // Consume newline
                    System.out.print("Enter status: ");
                    String status = scanner.nextLine();
                    Claim claim = new Claim(claimNumber, policyNumber, claimantName, claimAmount, status);
                    system.addClaim(claim);
                    break;
                case 2:
                    System.out.print("Enter claim number: ");
                    String updateClaimNumber = scanner.nextLine();
                    System.out.print("Enter new status: ");
                    String newStatus = scanner.nextLine();
                    system.updateClaimStatus(updateClaimNumber, newStatus);
                    break;
                case 3:
                    system.generateReport();
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
