package rafflewithprizestorage;

import java.util.Scanner;
import java.util.Random;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.PrintWriter;
import java.util.ArrayList;

public class RaffleWithPrizeStorage {

    //setup public vars and arrays
    public static ArrayList<String> NamesAndNumbers = new ArrayList<>();
    public static String fullDir;
    public static int TicketNumber;

    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);

        boolean Continue = false;
        while (Continue == false) {
            //get the directory for txt file
            getDir();

            //Have the user chose if they want an raffle ticket or check result
            EntryScreen(); //in this method there is also the purches and check methods

            while (true) {
                //check if there is anyone else
                try {
                    System.out.println("Does anyone else want to purchess a ticket or check a ticket? \n for yes type 1 and for no type 2");
                    int CarryOn = input.nextInt();
                    if (CarryOn != 1 || CarryOn != 2) {
                        System.out.println("Please enter either 1 or 2");
                    }
                    if (CarryOn == 1) {
                        Continue = true;
                    }
                    if (CarryOn == 2) {
                        break;
                    }

                } catch (Exception e) {
                    System.out.println("Error: " + e);
                }
            }
        }

    }

//get the directory for txt file
    public static void getDir() {
        fullDir = System.getProperty("user.dir") + "\\myText.txt";
    }

    //Have the user chose if they want an raffle ticket or check result
    public static void EntryScreen() {
        //setup imports
        Scanner input = new Scanner(System.in);

        while (true) {
            try {
                System.out.println("Hello and welcome to my raffle, if you would like a ticket type \"1\" if you want to check a ticket type \"2\" if you don't want to do anything type \"3\"");
                int Userinput = input.nextInt();
                if (Userinput == 1) {
                    PurchessTicket();
                    break;
                }
                if (Userinput == 2) {
                    ReadTxtDocAndCheck(CheckTicketNumber());
                    break;
                }
                if (Userinput == 3) {
                    break;
                }
            } catch (Exception e) {
                System.out.println("Error: " + e);
            }
            System.out.println("Please enter ether 1,2 or 3");
        }
    }

    //have the user buy a ticket 1 or  a strip (5)      also has the method to write their name on the document
    public static void PurchessTicket() {
        // setup the imports
        Scanner input = new Scanner(System.in);

        //write the users name and sir name to the txt doc
        NameWriter();

        //asks how many tickets the user wants to purchess
        while (true) {
            try {
                System.out.println("How many tickets would you like to buy?");
                System.out.println("For 1 ticket type \"1\" for a strip of tickets (5) type \"2\"");
                int AmountChoice = input.nextInt();

                if (AmountChoice == 1) {
                    System.out.println("So you want one ticket, here is your number: ");
                    TicketNumGenerator();
                    TicketNumberWriter();
                    break;
                }
                if (AmountChoice == 2) {
                    System.out.println("So you want a strip of tickets, here are your numbers: ");
                    for (int i = 0; i < 5; i++) {
                        TicketNumGenerator();
                        TicketNumberWriter();
                    }
                    break;
                }

            } catch (Exception e) {
                System.out.println("Error: " + e);
            }
            System.out.println("Please enter either 1 or 2");
        }
    }

    //this writes there name on the txt document
    public static void NameWriter() {
        Scanner input = new Scanner(System.in);
        System.out.println("Enter Name and Surname");
        String myStr = input.nextLine();

        try {
            FileWriter writeToFile = new FileWriter(fullDir, true);
            PrintWriter printToFile = new PrintWriter(writeToFile);
            printToFile.println(myStr);
            printToFile.close();
            writeToFile.close();
        } catch (Exception e) {
            System.out.println("Error: " + e);
        }
    }

    //generates the numbers for the tickets
    public static void TicketNumGenerator() {
        //setup the imports
        Random random = new Random();

        //generate 1 random number between 1-100 for the ticket number
        TicketNumber = random.nextInt(99) + 1;

        System.out.println(TicketNumber);
    }

    //writes the ticket number to the txt document
    public static void TicketNumberWriter() {
        try {
            FileWriter writeToFile = new FileWriter(fullDir, true);
            PrintWriter printToFile = new PrintWriter(writeToFile);
            printToFile.println(TicketNumber);
            printToFile.close();
            writeToFile.close();
        } catch (Exception e) {
            System.out.println("Error: " + e);
        }
    }

    //reads the txt document and adds the items to an array called NamesAndNumbers
    public static void ReadTxtDoc() {
        String inputLine;
        try {
            BufferedReader read = new BufferedReader(new FileReader(fullDir));
            while ((inputLine = read.readLine()) != null) {
                NamesAndNumbers.add(inputLine);
            }
        } catch (Exception e) {
            System.out.println("Error: " + e);
        }
    }

    //prints the document
    public static void PrintTxtDoc() {
        for (int i = 0; i < NamesAndNumbers.size(); i++) {
            System.out.println(NamesAndNumbers.get(i));
        }
    }

    public static String CheckTicketNumber() {
        Scanner input = new Scanner(System.in);

        //reads the txt doc to check the names and numbers
        ReadTxtDoc();

        //askes the user for their name
        System.out.println("What is your name?");
        String UserName = input.next();

        return UserName;
    }

    public static void ReadTxtDocAndCheck(String x) {
        String inputLine;
        try {
            BufferedReader read = new BufferedReader(new FileReader(fullDir));
            while ((inputLine = read.readLine()) != null) {
                NamesAndNumbers.add(inputLine);
                for (int i = 0; i < NamesAndNumbers.size(); i++) {
                    if (NamesAndNumbers.get(i).equalsIgnoreCase(x)) {
                        String TicketNumberString = NamesAndNumbers.get(i + 1);
                        TicketNumber = Integer.parseInt(TicketNumberString);
                        System.out.println("We are checking your ticket number now ^o^");
                        break;
                    }
                }
            }
            System.out.println("Sorry we couldn't find your name on our sheet, please buy a ticket");
        } catch (Exception e) {
            System.out.println("Error: " + e);
        }
    }

}
