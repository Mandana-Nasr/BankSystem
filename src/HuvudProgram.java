import java.util.Scanner;

public class HuvudProgram {

    static void main() {
        BankFacade bank = new BankFacade();
        Scanner scanner = new Scanner(System.in);
        boolean running = true;

        System.out.println("=== Välkommen till Banksystemet ===");

        while (running) {
            System.out.println("\n1. Skapa konto");
            System.out.println("2. Logga in");
            System.out.println("3. Avsluta");
            System.out.print("Val: ");

            int choice = scanner.nextInt();
            scanner.nextLine(); // rensa buffert

            switch (choice) {

                case 1:
                    System.out.print("Välj kontotyp (savings / transaction): ");
                    String type = scanner.nextLine();

                    System.out.print("Ange konto-ID: ");
                    String accountId = scanner.nextLine();

                    bank.createAccount(type, accountId);
                    System.out.println("Konto skapat!");
                    break;

                case 2:
                    System.out.print("Ange konto-ID: ");
                    String loginId = scanner.nextLine();

                    if (bank.login(loginId)) {
                        System.out.println("Inloggning lyckades!");
                        loggedInMenu(bank, scanner);
                    } else {
                        System.out.println("Fel konto-ID.");
                    }
                    break;

                case 3:
                    running = false;
                    System.out.println("Programmet avslutas.");
                    break;

                default:
                    System.out.println("Ogiltigt val.");
            }
        }

        scanner.close();
    }

    private static void loggedInMenu(BankFacade bank, Scanner scanner) {

        boolean loggedIn = true;

        while (loggedIn) {
            System.out.println("\n--- Konto meny ---");
            System.out.println("1. Visa saldo");
            System.out.println("2. Sätt in pengar");
            System.out.println("3. Ta ut pengar");
            System.out.println("4. Visa transaktionshistorik");
            System.out.println("5. Logga ut");
            System.out.print("Val: ");

            int choice = scanner.nextInt();

            switch (choice) {

                case 1:
                    System.out.println("Saldo: " + bank.getBalance());
                    break;

                case 2:
                    System.out.print("Belopp att sätta in: ");
                    double deposit = scanner.nextDouble();
                    bank.deposit(deposit);
                    System.out.println("Insättning genomförd.");
                    break;

                case 3:
                    System.out.print("Belopp att ta ut: ");
                    double withdraw = scanner.nextDouble();
                    bank.withdraw(withdraw);
                    System.out.println("Uttag genomfört.");

                    break;

                case 4:
                    bank.showTransactionHistory();
                    break;

                case 5:
                    bank.logout();
                    loggedIn = false;
                    System.out.println("Du har loggat ut.");
                    break;


                default:
                    System.out.println("Ogiltigt val.");
            }
        }
    }

}

