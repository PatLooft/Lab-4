package paystation;

import java.util.HashMap.*;
import java.util.Map.*;
import java.util.Map;
import java.util.HashMap;
import java.util.Scanner;

public class PaystationMain {

    public static void main(String args[]) throws IllegalCoinException {
        int input = 0;
        int coinInput = 0;
        Scanner reader = new Scanner(System.in);

        PayStationImpl p = new PayStationImpl();

        while (true) {
            System.out.println("Please enter one of the following options:"
                    + "\n1)Deposit coins\n2)Display\n3)Buy ticket"
                    + "\n4)cancel\n5)Change rate Strategy \n6) Exit Program\n");
            if (reader.hasNextInt()) {
                input = reader.nextInt();
            }
            else {
                reader.next(); //clears reader
                System.out.println("Invalid input");
                continue;
                
            }
            switch (input) {
                case 1:
                    //Deposit
                    System.out.println("How much would you like to deposit? Enter "
                            + "0 when you are done.");
                    coinInput = reader.nextInt();
                    p.addPayment(coinInput);
                    break;
                case 2:
                    //Display
                    System.out.println("You have " + p.readDisplay() + " minutes");
                    break;
                case 3:
                    //Buy Ticket
                    System.out.println("Time Bought " + p.buy().value() + " minutes");
                    break;
                case 4:
                    //Cancel
                    System.out.println("How many of each coin was inserted: " + p.cancel());

                    break;
                case 5:
                    //Change rate strategy
                    do {
                        System.out.println("Which rate strategy would you like to use?\n1)Linear\n2)Progressive\n3}Alternating\n\n");
                        input = reader.nextInt();
                    }while(input != 1 && input != 2 && input != 3);

                    p.switchRateStrategy(input);
                    break;
                case 6:
                    //Will exit the system
                    System.out.println("Have a nice day. (:");
                    System.exit(0);
                default:
                    System.out.println("Please choose 1 through 6");
                    input = reader.nextInt();
            }
        }
//test
    }
}
