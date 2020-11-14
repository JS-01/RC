
package numbersorting;
import java.util.Scanner;
import java.util.ArrayList;
import java.util.Arrays;

public class NumberSorting {


    public static void main(String[] args) {
// set up the scanner
    Scanner input = new Scanner(System.in);
    
// have the user input a string of numbers
    System.out.println("How many numbers would you like to sort?");
    int NumberToSort = input.nextInt();
    System.out.println("Please enter the numbers you want sorted (please press enter after each number)");
    
// set up the array for the numbers to be stored in (sorted and unsorted)
    int[] Unsorted = new int[NumberToSort];
    int[] Sorted = new int[NumberToSort];

// store those in the unsorted array
    for (int i=0; i<NumberToSort; i++) {
        Unsorted[i] = input.nextInt();
    }

// print the unsorted numbers:
    System.out.println("The numbers before they are sorted:");
    for (int i=0; i<Unsorted.length; i++) {
        System.out.print(Unsorted[i] +" ");
    }
    
// start sorting the unsorted array using a bubble sort method (swaping the numbers)
    int PlaceHolder = 0; // this a value that will be used as a place holder during the swaping
    for (int i=0; i<Unsorted.length; i++) { // go though every int in Unsorted
        for (int x=1; x<(Unsorted.length - i); x++) { // this is value used for the comparing ---- x cant be 0 otherwise i get a -1 error
            if (Unsorted[x-1] > Unsorted[x]) {
                PlaceHolder = Unsorted[x-1]; // you -1 to make sure it is the int below Unsorted[x]
                Unsorted[x-1] = Unsorted[x]; // this makes the int below Unsorted[x] become Unsorted[x]
                Unsorted[x] = PlaceHolder; // this makes Unsorted[x] the int that is above it
            }
        }
    }
    for (int i=0; i<Unsorted.length; i++) {
        Sorted[i] = Unsorted[i];
    }
    
// Print out the sorted array
    System.out.println("\nAnd your new sorted numbers are:");
    for (int i=0; i<Unsorted.length; i++) {
        System.out.print(Sorted[i]+" ");
    }
    
// find the average
    int Total = 0;
    for (int i=0; i<Sorted.length; i++) {
        Total = Total + Sorted[i];
    }
    int Average = Total%Sorted.length;
    
// find the max and min
    int max = Sorted.length-1;
    int min = 0;
    
// print them both
    System.out.println("\nThe average is: " + Average);
    System.out.println("The maximum is: " + Sorted[max]);
    System.out.println("The minimum is: " + Sorted[min]);
    
    
    
    }
    
}
