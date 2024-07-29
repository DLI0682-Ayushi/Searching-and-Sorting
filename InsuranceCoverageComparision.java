package AdditionalProblems;
import java.util.ArrayList;
import java.util.Scanner;

class CoverageOption {
    private String coverageType;
    private double coverageAmount;
    private double premium;

    public CoverageOption(String coverageType, double coverageAmount, double premium) {
        this.coverageType = coverageType;
        this.coverageAmount = coverageAmount;
        this.premium = premium;
    }

    public String getCoverageType() {
        return coverageType;
    }

    public double getCoverageAmount() {
        return coverageAmount;
    }

    public double getPremium() {
        return premium;
    }

    @Override
    public String toString() {
        return "CoverageOption{" +
                "coverageType='" + coverageType + '\'' +
                ", coverageAmount=" + coverageAmount +
                ", premium=" + premium +
                '}';
    }
}

public class InsuranceCoverageComparision {
    private ArrayList<CoverageOption> coverageOptions;

    public InsuranceCoverageComparision() {
        coverageOptions = new ArrayList<>();
    }

    public void addCoverageOption(CoverageOption option) {
        coverageOptions.add(option);
    }

    public void compareCoverageOptions() {
        if (coverageOptions.isEmpty()) {
            System.out.println("No coverage options available to compare.");
            return;
        }

        CoverageOption bestOption = coverageOptions.get(0);
        for (CoverageOption option : coverageOptions) {
            if (option.getCoverageAmount() > bestOption.getCoverageAmount() && option.getPremium() <= bestOption.getPremium()) {
                bestOption = option;
            }
        }

        System.out.println("Best coverage option based on coverage amount and premium:");
        System.out.println(bestOption);
    }

    public void listAllCoverageOptions() {
        for (CoverageOption option : coverageOptions) {
            System.out.println(option);
        }
    }

    public static void main(String[] args) {
        InsuranceCoverageComparision system = new InsuranceCoverageComparision();
        Scanner scanner = new Scanner(System.in);

        while (true) {
            System.out.println("1. Add Coverage Option");
            System.out.println("2. Compare Coverage Options");
            System.out.println("3. List All Coverage Options");
            System.out.println("4. Exit");
            System.out.print("Choose an option: ");
            int choice = scanner.nextInt();
            scanner.nextLine();  // Consume newline

            switch (choice) {
                case 1:
                    System.out.print("Enter coverage type: ");
                    String coverageType = scanner.nextLine();
                    System.out.print("Enter coverage amount: ");
                    double coverageAmount = scanner.nextDouble();
                    System.out.print("Enter premium: ");
                    double premium = scanner.nextDouble();
                    scanner.nextLine();  // Consume newline
                    CoverageOption option = new CoverageOption(coverageType, coverageAmount, premium);
                    system.addCoverageOption(option);
                    break;
                case 2:
                    system.compareCoverageOptions();
                    break;
                case 3:
                    system.listAllCoverageOptions();
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
