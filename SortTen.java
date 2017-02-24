/** Grady McPeak
 * Dr. Brown
 * G Period Programming and Algorithms
 * 2/10/16
 */


/** PROGRAM DESCRIPTION
 * This program asks the user to input ten integers
 * Then, the ten numbers are sorted least to greatest using a physical exchange sorting algorithm.
 * Finally, both the original order and the new, sorted order are printed.
 */

/** VARIABLE DICTIONARY
 * "dynamicPointer" (int) marks a second element to compare to the other element (see "staticPointer")
 * "inputCount" (int) - keeps track of how many integers the user has input (the limit is ten integers)
 * "numberChosen" (int) - the integer version of the user's input number(s)
 * "originalPlaces" (String) - the print-ready list of the original order of the numbers
 * "sortedPlaces" (String) - a list of all the numbers in their least-to-greatest order
 * "sorter" (int []) - the array in whcih all the integers are put into and sorted in
 * "staticPointer" (int) - marks a first element to compare to the other elements in the array (see "dynamicPointer")
 * "userInput" (String) - varible user inputs numbers into
 */

import javax.swing.JOptionPane;

public class SortTen
{
    public static void main (String args [])
    { 
        String userInput; userInput = "";
        int numberChosen; numberChosen = 0;
        int sorter[] = new int[11];
        String originalPlaces = "";
       
        for (int inputCount = 1; inputCount <= 10; inputCount ++) //creates an array of ten user-input integers to sort later
        {
            userInput = JOptionPane.showInputDialog ("Input ten integers, and I will sort them for you!");
            numberChosen = Integer.parseInt(userInput);
            sorter[inputCount] = numberChosen;
            originalPlaces = originalPlaces + sorter[inputCount] + ", ";
        }
        
        int sortedNumbers[] = new int [11];
        String sortedPlaces = "";
        
        //beginning of sort
        for (int staticPointer=1; staticPointer<=10; staticPointer++)//creates a pointer to mark one of two elements to compare 
          {
            for (int dynamicPointer = staticPointer+1; dynamicPointer <= 10; dynamicPointer++) //second pointer
                if (sorter[staticPointer] > sorter[dynamicPointer]) //commences swapping
                {
                    sorter[0] = sorter[staticPointer];
                    sorter[staticPointer] = sorter[dynamicPointer];
                    sorter[dynamicPointer] = sorter[0];
                }
            sortedPlaces = sortedPlaces + sorter[staticPointer] + ", "; //puts all numbers, now sorted, in a single variable
          }
        
        JOptionPane.showMessageDialog(null, "The ten numbers you entered were " + originalPlaces + "in that" +
            " order. \nSorted, they are " + sortedPlaces + "from least to greatest.");
    }
}
