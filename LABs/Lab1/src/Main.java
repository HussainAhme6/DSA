import java.util.Random;
import java.util.Arrays;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

        // Take input the size of an array
        Scanner sc = new Scanner(System.in);  // Create a Scanner object
        System.out.println("Enter the size of an Array");
        int size = sc.nextInt();  // Read user input

        //create array with the input size on random value
        Random rd = new Random(); // creating Random object
        rd.setSeed(System.currentTimeMillis()); // use current time as a seed
        // fill the data array with pseudo-random numbers from 0 to 99,
        int[] arr = new int[size];
        for (int i = 0; i < arr.length; i++)
            arr[i] = rd.nextInt(100); // storing random integers in an array


        //Display the defined array
        System.out.println(Arrays.toString(arr));

        //delete an element from array
        arr = MyArray.removeTheElement(arr, 2);
        System.out.println(Arrays.toString(arr));
    }
}