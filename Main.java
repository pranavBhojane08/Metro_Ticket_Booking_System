package Metro;

import java.util.Scanner;

public class Main {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        LoginService loginService = new LoginService();
        MetroService metroService = new MetroService();

        System.out.println("===== PUNE METRO LOGIN =====");

        try {
            System.out.print("Username: ");
            String username = sc.nextLine();

            System.out.print("Password: ");
            String password = sc.nextLine();

            String role = loginService.login(username, password);
            System.out.println("✅ Login Successful | Role: " + role);

        } catch (AuthenticationException e) {
            System.out.println("❌ Login Failed: " + e.getMessage());
            return; // exit only if login fails
        }

        // 🔁 MAIN MENU LOOP (Program will NOT exit automatically)
        while (true) {
            try {
                System.out.println("\n===== PUNE METRO TICKET BOOKING =====");
                System.out.println("1. View Stations");
                System.out.println("2. Book Ticket");
                System.out.println("3. View All Tickets");
                System.out.println("4. Exit");
                System.out.print("Enter choice: ");

                int choice = sc.nextInt();
                sc.nextLine();

                switch (choice) {
                    case 1:
                        metroService.showStations();
                        break;

                    case 2:
                        System.out.print("Passenger Name: ");
                        String name = sc.nextLine();

                        System.out.print("Source Station: ");
                        String source = sc.nextLine();

                        System.out.print("Destination Station: ");
                        String dest = sc.nextLine();

                        metroService.bookTicket(name, source, dest);
                        break;

                    case 3:
                        metroService.viewTickets();
                        break;

                    case 4:
                        System.out.println("🚇 Thank you for using Pune Metro");
                        System.exit(0); // ONLY exit here

                    default:
                        System.out.println("❌ Invalid choice. Try again.");
                }

            } catch (InvalidInputException e) {
                System.out.println("❌ " + e.getMessage());
            } catch (Exception e) {
                System.out.println("❌ Invalid input. Please try again.");
                sc.nextLine(); // clear buffer
            }
        }
    }
}
