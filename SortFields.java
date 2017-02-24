/**Grady McPeak
 * Dr. Brown
 * Programming and Algorithms - G period
 * 2/18/16
 */
/**PROGRAM DESCRIPTION
 * Title: "Sort Fields"
 * This program can take in ten inputs, 3 fields each, and sort the ten inputs alphabetically.
 * Then, both the original order and the new order are printed.
 */
/**VARIABLE DICTIONARY
 * ages (int, []) - the array of input ages for the ten people
 * concatCount (int) - counts the amoun
 * firstComparer (int) - marks one out of the two numbers being compared in the sort
 * inputCount (int) - keeps track of amount of inputs made
 * names (String, []) - array of ten input names of people to sort later
 * originalData (String) - a concatenated list of the inputs in their original order, used to print results
 * pointer (int, []) - the pointer array used to label / order the input data
 * salaries (double, []) - the respective salaries of people in the array "names"
 * secondComparer (int) - marks the second out of two numbers being compared during a sort
 * sortedOutput (String) - a list of all the data, sorted, and ready for printing
 */


import javax.swing.JOptionPane;

public class SortFields
{
    public static void main (String args [])
    {
        //setting up all the arrays for the data to be input into
        String names[] = new String [11];
        int ages[] = new int [11];
        double salaries[] = new double [11];
        int pointer[] = new int[11];
        String originalData = "The data you input was \n";
        
            for (int inputCount = 1; inputCount <= 10; inputCount ++) //user inputs data for ten people's names, ages, and salaries
            {
                if (inputCount == 1)
                {
                    names [inputCount] = JOptionPane.showInputDialog ("This program can take ten people's name, age , and salaries and sort them alphabetically. " + 
                    "Enter a name!");
                }
                else
                {
                    names [inputCount] = JOptionPane.showInputDialog ("You've entered " + (inputCount - 1) + " out of 10 people in the sort. Enter another name!");
                }
                    ages[inputCount] = Integer.parseInt(JOptionPane.showInputDialog ("What is " + names[inputCount] + "'s age?"));
                    salaries[inputCount] = Double.parseDouble(JOptionPane.showInputDialog ("How much would you like to pay " + names[inputCount] + "?"));
                    pointer[inputCount] = inputCount;
                    originalData = originalData + names[inputCount] + ", age " + ages[inputCount] +
                                ", will be paid $" + salaries[inputCount] + ", \n";
    
            }
            
            for (int firstComparer = 1; firstComparer <= pointer.length-2; firstComparer++) //moves data's respective pointers to sort quickly
                for (int secondComparer = firstComparer +1; secondComparer <= pointer.length-1; secondComparer++)
                    if (names[pointer[firstComparer]].compareTo (names[pointer[secondComparer]])>0)
                    { //swaps are made below
                     pointer[0] = pointer[firstComparer];
                     pointer[firstComparer] = pointer[secondComparer];
                     pointer[secondComparer] = pointer[0];
                    }
                    
        String sortedOutput = "The same data, sorted, is \n";
        
            for (int concatCount = 1; concatCount < names.length; concatCount++) //puts all data into one String for easy printing
            {
               sortedOutput = sortedOutput + names[pointer[concatCount]] + ", age " + 
               ages[pointer[concatCount]] + ", is being paid $" + salaries[pointer[concatCount]] + " \n ";
            }
           
        JOptionPane.showMessageDialog (null, originalData + "\n \n" + sortedOutput);
    }
}

