import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        List<Roommate> roommates = Arrays.asList(
                new Roommate("Roommate-1"),
                new Roommate("Roommate-2 "),
                new Roommate("Roommate-3"),
                new Roommate("Roommate-4"),
                new Roommate("Roommate-5"),
                new Roommate("Roommat-6")
        );

        Scheduler scheduler = new Scheduler(roommates);

        try (Scanner scanner = new Scanner(System.in)) {
            while (true) {
                System.out.println("\nCleanup Scheduler Menu:");
                System.out.println("1. View Cleaning Schedule");
                System.out.println("2. Regenerate Schedule");
                System.out.println("3. Exit");
                System.out.print("Enter choice: ");

                int choice = scanner.nextInt();

                switch (choice) {
                    case 1:
                        scheduler.displaySchedule();
                        break;
                    case 2:
                        scheduler.generateMonthlySchedule();
                        System.out.println("Schedule regenerated.");
                        break;
                    case 3:
                        System.out.println("Exiting...");
                        return;
                    default:
                        System.out.println("Invalid choice. Please try again.");
                }
            }
        }
    }
}
