
import java.util.Scanner;

public class Stage3 {
    private static char[][] cinemaHall;
    private static final char SEAT = 'S';
    private static final char BUSY = 'B';
    private static final Scanner scanner = new Scanner(System.in);
    private static final int frontHalf = 10;
    private static final int backHalf = 8;

    public static void main(String[] args) {
        createCinema();
       printCinemaHall(cinemaHall);
       // takeTicket(cinemaHall);
       // printCinemaHall(cinemaHall);

    }

    public static void createCinema() {
        System.out.println("Enter the number of rows:");
        int rows = scanner.nextInt();
        System.out.println("Enter the number of seats in each row:");
        int seats = scanner.nextInt();
        cinemaHall = new char[rows][seats];
        if (rows <= 9 && seats <= 9) {
            for (int i = 0; i < rows; i++) {
                for (int j = 0; j < seats; j++) {
                    cinemaHall[i][j] = SEAT;
                }
            }
        } else {
            System.out.println("Error!!!");
        }
    }

    public static void printCinemaHall(char[][] cinemaHall) {
        System.out.println("Cinema:");
        System.out.print(" ");
        for (int i = 1; i <= cinemaHall[0].length; i++) {
            System.out.print(" " + i);
        }
        System.out.println();
        for (int i = 0; i < cinemaHall.length; i++) {
            System.out.print(i + 1);
            for (int j = 0; j < cinemaHall[0].length; j++) {
                System.out.print(" " + cinemaHall[i][j]);
            }
            System.out.println();
        }
    }
    public static void takeTicket(char[][] cinemaHall) {
        System.out.println("Enter a row number:");
        int rowNumber = scanner.nextInt();
        System.out.println("Enter a seat number in that row:");
        int seatNumber = scanner.nextInt();
        cinemaHall[rowNumber - 1][seatNumber - 1] = BUSY;
        int totalPlaces = cinemaHall.length * cinemaHall[0].length;
        int seatPrice;
        if (totalPlaces <= 60) {
            seatPrice = frontHalf;
        } else {
            int halfOfRows = cinemaHall.length / 2;
            if (rowNumber <= halfOfRows) {
                seatPrice = frontHalf;
            } else {
                seatPrice = backHalf;
            }
        }
        System.out.println("Ticket price: $" + seatPrice);
    }
}