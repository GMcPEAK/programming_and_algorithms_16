/** Grady McPeak
 * Dr. Brown
 * G Period Programming and Algorithms
 * 3/13/16
 * "Factorial Solve"
 */

/** PROGRAM DESCRIPTION
 * This program takes in an input number from the user and asks how they want to find the factorial: iteratively or recursively or both.
 * Then, the program solves the factorial in the specified way and prints the result.
 */

import javax.swing.JOptionPane;

public class FactorialSolve
{
    /** VARIABLE DICTIONARY (main method)
     * input (String) - the input number to find the facorial of
     * number (int) the variable used to find the factorial of the original number
     * option (String) - the user-selected method of solving the factorial
     * originalNumber (int) - the parsed version of "input" and used to keep track of the number before the factorial was found
     * selection (boolean) determines if a method of solving has been found yet
     */

    public static void main (String args [])
    {
       String input = JOptionPane.showInputDialog ("This program can take a number and find it's factorial iteratively OR recursively OR both. \n" + 
            "Which number would you like to know the factorial of?");
            
        int originalNumber = Integer.parseInt (input);
        int number = originalNumber;
        boolean selection = false;
        String option = JOptionPane.showInputDialog ("How would you like to solve it? Type 'r' for recursively, 'i' for iteratively, and 'b' for both...");
        
       while (selection == false) //loop determines which method of solving user picked
       {
            if (option.equals("i"))
            {
                selection = true;
                number = iterativeSolve (number);
            }  
                else
                if (option.equals("r"))
                {
                    selection = true;
                    number = recursiveSolve (number);
                }
                    
                    else
                    if (option.equals("b"))
                    {
                        selection = true;
                        number = iterativeSolve (number);
                        number = recursiveSolve (number);
                    }
                        else
                        {
                            JOptionPane.showMessageDialog (null, "Invalid input!");
                            option = JOptionPane.showInputDialog ("Try again. Type 'r' for recursively, 'i' for iteratively, and 'b' for both...");
                        }
       }
        
        JOptionPane.showMessageDialog (null, "The factorial of " + originalNumber + " is " + number + ".");
    }
    
    /** VARIABLE DICTIONARY (iterativeSolve)
     * count (int) - keeps track of how many multiplications have been made when finding factorial
     * factor (int) - the factorial as it is being multiplied by itself
     * num (int) - the number to find the factorial of
     */
    public static int iterativeSolve (int num)
    {
        int factor = 1;
        
        for (int count = 1; count <= num; count ++) //multiplies the number by itself until the factorial is found
        {
            factor = factor*count;
        }
        
        return factor;
    }
    
    /** VARIABLE DICTIONARY (recursiveSolve)
     * numb (int) - the number that the factorial of is found
     */
    public static int recursiveSolve (int numb)
    {
        if (numb == 0 || numb == 1) //recursive method of solving for factorial
        {
            return 1;
        }
        else
        {
            return numb * recursiveSolve(numb - 1); //adds another layer to the stack of multiplications
        }
    }
}
