/** Grady McPeak
 * Dr. Brown
 * G Period Programming and Algorithms
 * 3/8/16
 * Title: DEDUPLICATE AND SEARCH
 */

/** PROGRAM DESCRIPTION
 * Generates and array of 500 elements of int.
 * Sorts them and then changes any and all duplicates in the array.
 * Then tests a binary search function by printing out the numbers in elements one, fourty-seven,two hundred ninety-nine, three hundred seventy-five, and five hundred.
 * Then asks the user to type in any of those numbers (or a different number, whichever they like) and the computer will conduct a binary search to fns the number or find out it isn't there.
 */

import javax.swing.JOptionPane;

public class DeDuplicateAndSearch
{
    /** VARIABLE DICTIONARY (main method)
     * "allTheNumbers" (String) - a concatenated list of the entire array, after it has been deduplicated
     * "changes" (int) - the total number of changes made to the elements of the array
     * "counter" (int) used to concatenate the array "numbers" into the String "allTheNumbers"
     * "numbers" (int []) - the array of numbers to be sorted and deduplicated
     */
    
    public static void main (String args [])
    {
        int[] numbers = new int [501];
        int changes = 0;
        createArray (numbers);
        insertionSort (numbers);
        changes = deDuplication (numbers, changes);
        insertionSort (numbers);
        
        String allTheNumbers = "";
        
        int counter = 1;
        
        for (counter = 1; counter < numbers.length; counter++)
        {
            allTheNumbers = allTheNumbers + " " + Integer.toString(numbers[counter]);
            
            if (counter%20 == 0)
            {
                allTheNumbers = allTheNumbers + "\n";
            }
        }
        
        JOptionPane.showMessageDialog (null, "The " + (counter-1) + "-number array created has been de-duplicated, meaning there are no duplicated numbers in the array." +
        "\n In order to do this, " + changes + " changes had to be made. \n Click OK to see the entire array. \n After seeing the entire array, we wil conduct a binary search test.");
        
        JOptionPane.showMessageDialog (null, "Here is the array: \n" + allTheNumbers);
        
        String answer = searchNums (numbers);
        JOptionPane.showMessageDialog (null, answer);
    }
    
    /** VARIABLE DICTIONARY (method "createArray")
     * count (int) - used to randomly generate a number in each element of the array
     * number (int []) - the array of numbers to be randomly generated
     */
    
    public static void createArray (int [] number)
    {
        for (int count = 1; count < number.length; count ++)
        {
            number[count] = (int)(Math.random ()*999)+1;
        }
    }
    
    /** VARIABLE DICTIONARY (method "insertionSort")
     * i (int) - the second sub-array in the insertion sort (see j, key)
     * j (int) - the first sub-array in the insertion sort (see i, key)
     * key (int) - the specific number being sorted at a given time (see i, j)
     * num (int []) - the array of numbers being sorted
     */
    
    public static void insertionSort (int [] num)
    {
        int j = 0;                  // the number of items sorted so far
        int key;                // the item to be inserted
        int i = 0; 

        for (j = 1; j < num.length; j++)    // Start with 1 (not 0)
        {
          key = num[ j ];
          for(i = j - 1; (i >= 0) && (key < num [i]); i--)   // larger values are moving up
          {
                 num[ i+1 ] = num[ i ];
          }
          num[ i+1 ] = key;// Put the key in its proper location
        }
    }
    
    /** VARIABLE DICTIONARY (method "deDuplication")
     * change (int) - the amount of changes made in a specific run through the method
     * secondPointer (int) - second of two number being compared, also number that's changed if a duplicate is found (see "firstPointer")
     * firstPointer (int) - one of two numbers being compared at any given time (see "dynamicPointer")
     * numbs (int []) - the array of numbers being deduplicated
     */
    public static int deDuplication (int [] numbs, int change)
    {
        change = change;

        for (int firstPointer=1; firstPointer<500; firstPointer++)//creates a pointer to mark one of two elements to compare 
        {
            for (int secondPointer = firstPointer+1; secondPointer <= 500; secondPointer++) //second pointer
            {
                if (numbs[firstPointer] == numbs[secondPointer])  //determines if two numbers are equal. if they are, one of them changes               
                {
                    numbs[secondPointer] = numbs[secondPointer] +1;
                    change = change +1;
                    if (numbs[firstPointer] > 1000)
                    {
                        numbs[firstPointer] = 1;
                        change = change +1;
                    }
                }
            }
        }
        
        return change;
    }
    
    /** VARIABLE DICTIONARY (method "searchNums)
     * lowerBound (int) the lowest element in the possible elements the number could be in
     * probe (int) - the halfway point between the range of elements from the upper bound to the lower bound, and used to search for the number the user input
     * searched (int) - the number the user asked to search for
     * upperbound (int) the highest element in the range of possible elements the number could be in  
     */
    public static String searchNums (int [] numbrs)
    {
        JOptionPane.showMessageDialog (null, "Now begins the search test. Wrtie these numbers and their corresponding array elements down. In element one is " +
        numbrs[1] + ", element 47 is " + numbrs[47] + ", element 299 is " + numbrs[299] + ", element 375 is " + numbrs[375] + ", and element 500 is " + 
        numbrs[500] + ".");
        
        int searched = Integer.parseInt (JOptionPane.showInputDialog ("What number would you like to find?"));
        int lowerBound = 1;
        int upperBound = numbrs.length;
        int probe = 0;
        String answer = "Number not found!";
        

        while (lowerBound < upperBound && searched != numbrs[probe]) // creates a range of elements and slowly narrows them down
        {
            probe = (lowerBound + upperBound)/2; //probe is the average of the upper bound and the lower bound
            
            if (searched < numbrs[probe]) //cuts data set into upper half of last one
            {
                upperBound = probe;
            }
            else
            if (searched > numbrs[probe]) //cuts into lower half
            {
                lowerBound = probe;
            }
            else
            if (searched == numbrs[probe]) //number is found
            {
                answer = ("The number " + searched + " was found in element " + probe + ".");
            }    
        }
        
        return (answer);
    }
}

