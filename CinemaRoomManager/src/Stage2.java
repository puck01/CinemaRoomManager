import java.util.Scanner;
public class Stage2 {

    public static void main(String[] args) {
        // Write your code here
        System.out.println("Cinema:");
        System.out.println("1 2 3 4 5 6 7 8");
        System.out.println("1 S S S S S S S S");
        System.out.println("2 S S S S S S S S");
        System.out.println("3 S S S S S S S S");
        System.out.println("4 S S S S S S S S");
        System.out.println("5 S S S S S S S S");
        System.out.println("6 S S S S S S S S");
        System.out.println("7 S S S S S S S S");

        Scanner sc = new Scanner(System.in);
        System.out.println("Enter the number of rows:");
        int rows = sc.nextInt();
        System.out.println("Enter the number of seats in each row:");
        int seats = sc.nextInt();
        int income;
        int totalSeats = rows*seats;
        int frontHalf,backHalf;

        if(totalSeats <= 60){
            income = seats*rows*10;
            System.out.println("Total income:");
            System.out.println("$"+income);
            //break;
        }
        else if(totalSeats>=60 && rows%2==0){
            frontHalf = rows/2;
            backHalf = rows/2;
            System.out.println("Total income:");
            int frontPay = frontHalf*10;
            int backPay = backHalf*8;
            int pay = frontPay+backPay;
            System.out.println("$"+pay*seats);
        }
        else if(rows%2!=0){
            int frontHalf1 = rows/2;
            int backHalf1 = rows/2+1;
            int frontPay1 = frontHalf1*10;
            int backPay1 = backHalf1*8;
            System.out.println("$"+(frontPay1+backPay1)*seats);
        }

    }
}