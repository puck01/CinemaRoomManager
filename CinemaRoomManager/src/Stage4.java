import java.util.Scanner;

public class Stage4 {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.println("Enter the number of rows:");
        int rows = sc.nextInt();
        System.out.println("Enter the number of seats in each row:");
        int seats = sc.nextInt();

        int[][] cinema = new int[rows][seats];
        printMenu();

        while (sc.hasNext()) {
            int i = sc.nextInt();
            switch (i) {
                case 0 : return;
                case 1 : showSeats(cinema);
                    System.out.println();
                    printMenu();
                    break;
                case 2 : buyTicket(cinema);
                    System.out.println();
                    printMenu();
                    break;
            }
        }
    }

    public static void buyTicket(int[][] arr) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter a row number:");
        int row = sc.nextInt();
        System.out.println("Enter a seat number in that row:");
        int seat = sc.nextInt();
        // mark the purchased ticket
        arr[row - 1][seat - 1] = 1;

        // print the ticket price
        int price;
        // rows = arr.length
        // seats = arr[0].length
        if (arr.length * arr[0].length <= 60) {
            price = 10;
        }
        else {
            int frontRows = arr.length / 2;
            price = row > frontRows ? 8 : 10;
        }
        System.out.println("Ticket price: $" + price);
    }

    public static void showSeats(int[][] arr) {
        System.out.println("Cinema:");
        System.out.print(" ");
        // rows = arr.length
        // seats = arr[0].length
        for (int j = 1; j <= arr[0].length; j++) {
            System.out.print(" " + j);
        }
        System.out.println();
        for (int i = 0; i < arr.length; i++) {
            System.out.print(i + 1 + " ");
            for (int j = 0; j < arr[i].length; j++) {
                System.out.print(arr[i][j] == 0 ? "S " : "B ");
            }
            System.out.println();
        }
    }

    public static void printMenu() {
        System.out.println("1. Show the seats");
        System.out.println("2. Buy a ticket");

        System.out.println("0. Exit");
    }
}