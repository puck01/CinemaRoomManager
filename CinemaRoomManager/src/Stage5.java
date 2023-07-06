import java.util.Scanner;

public class Stage5 {
    static Scanner sc = new Scanner(System.in);
    static int row = 0;
    static int seatsPerRow = 0;
    static int rowNum = 0;
    static int colNum = 0;
    static int totalSeats = 0;
    static int ticketPrice = 0;
    static int chooseMenu;
    static char[][] seatingPlan;
    static int soldTicket = 0;
    static double percentSold = 0;
    static int currentIncome = 0;
    static int totIncome = 0;

    public static void main(String[] args) {
        System.out.println("Enter the number of rows:");
        row = sc.nextInt();
        System.out.println("Enter the number of seats in each row:");
        seatsPerRow = sc.nextInt();
        System.out.println();

        totalSeats = row * seatsPerRow;
        totIncome = totalIncome();
        seatingPlan = new char[row][seatsPerRow];
        for (int i = 0; i < seatingPlan.length; i++) {
            for (int j = 0; j < seatingPlan[i].length; j++) {
                seatingPlan[i][j] = 'S';
            }
        }

        do {
            printMenu();
            chooseMenu = sc.nextInt();
            switch(chooseMenu) {
                case 1:
                    showTheSeats();
                    break;
                case 2:
                    buyATicket();
                    break;
                case 3:
                    statistics();
                    break;
                case 0:
                    return;
            }
        }while(chooseMenu != 0);
    }
    public static void printMenu() {
        System.out.println("1. Show the seats");
        System.out.println("2. Buy a ticket");
        System.out.println("3. Statistics");
        System.out.println("0. Exit");
        System.out.println();
    }
    public static void showTheSeats() {
        System.out.println("Cinema:");
        System.out.print("  ");
        for (int i = 1; i <= seatsPerRow; i++) {
            System.out.printf("%d ", i);
        }
        System.out.println("");

        for (int i = 1; i <= row; i++) {
            System.out.printf("%d ", i);
            for (int j = 1; j <= seatsPerRow; j++) {
                System.out.printf("%c ", seatingPlan[i - 1][j - 1]);
            }
            System.out.print("\n");
        }
        System.out.println();
    }
    public static void buyATicket() {
        System.out.println();
        String errorMsg = "";
        do {
            System.out.println("Enter a row number:");
            rowNum = sc.nextInt();
            System.out.println("Enter a seat number in that row:");
            colNum = sc.nextInt();

            if(rowNum > row || colNum > seatsPerRow) {
                errorMsg = "Wrong input!";
                System.out.println(errorMsg);
                System.out.println();
            } else if (seatingPlan[rowNum - 1][colNum - 1] == 'B') {
                errorMsg = "That ticket has already been purchased!";
                System.out.println(errorMsg);
                System.out.println();
            } else {
                errorMsg = "";
                ticketPrice();
                System.out.println();
            }
        } while (errorMsg != "");
    }
    public static void ticketPrice() {
        if (totalSeats <= 60) {
            ticketPrice = 10;
        } else {
            ticketPrice = rowNum <= row / 2 ? 10 : 8;
        }
        seatingPlan[rowNum - 1][colNum - 1] = 'B';
        soldTicket += 1;
        percentSold = soldTicket/(double)totalSeats*100;
        currentIncome += ticketPrice;
        System.out.printf("Ticket price: $%d%n", ticketPrice);
    }
    public static int totalIncome() {
        if (totalSeats <= 60) {
            return totalSeats * 10;
        } else {
            return (row / 2 * 10 + (row - row / 2) * 8) * seatsPerRow;
        }
    }
    public static void statistics() {
        System.out.println();
        System.out.printf("Number of purchased tickets: %d%n", soldTicket);
        System.out.printf("Percentage: %.2f%%%n", percentSold);
        System.out.printf("Current income: $%d%n", currentIncome);
        System.out.printf("Total income: $%d%n", totIncome);
        System.out.println();
    }
}