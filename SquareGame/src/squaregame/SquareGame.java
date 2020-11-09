
package squaregame;
import java.util.Scanner;
import java.util.Random;

public class SquareGame {


    public static void main(String[] args) {
// set up Scanner and Random
        Scanner input = new Scanner(System.in);
        Random rand = new Random();
        
// get how many turns
// check it is above 10
        int Turns=0;
        do {
            System.out.println("How many turns do you want the game to go on for? (must be over 10)");
            Turns = input.nextInt();
        } while (Turns<10);
        
// set up the Scores
        int User=0;
        int Comp=0;

// set up the array        
        String[][] Grid = new String[10][10];
        for (int i=0; i<10; i++) {
            for (int x=0; x<10; x++) {
                Grid[i][x] = "[]";
            }
        }

// have the user input their name        
        System.out.println("Please enter your name");
        String Name = input.next();
        
        do{
//                                  USER GO            
// check it is not x>10     
            int x=0;
            do {
            System.out.println("Please enter a x corrdinate, make sure it is between 0-10");
            x = input.nextInt();
            } while (x>=10);
// check it is not y>10    
            int y=0;
            do {
            System.out.println("Please enter a y corrdinate, make sure it is between 0-10");
            y = input.nextInt();
            } while (y>=10);
// continue with normal
            Grid[x][y] = Name;
            User++;
            if (Grid[x][y]=="Comp") {
                Comp--;
            }
            
//                                 COMPUTER GO
// have a x value
            int ComputerX = rand.nextInt((10-0)+1)+0;
// have a y value
            int ComputerY = rand.nextInt((10-0)+1)+0;
            Grid[ComputerX][ComputerY] = "Comp";
            Comp++;
            if (Grid[x][y]==Name) {
                User--;
            }
            
// take away 1 from turns
            Turns--;
        } while (Turns!=0);
        
// total up the Scores        
        if (User>Comp) {
            System.out.println("WOOOOO you won ^o^");
        }
        if (User<Comp) {
            System.out.println("Sorry you lost :(");
        }
        if (User==Comp) {
            System.out.println("WOW you drew with the computer");
        }

    }    
}
