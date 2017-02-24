/** Grady McPeak
 * "Find Greatest"
 * G Period Programming and Algorithms
 * 1/27/16
 */

import javax.swing.JOptionPane;

public class FindGreatest
{
    public static void main (String args [])
    {
        
        int count = 0;
        int value = 0;
        String inputNumber;
        int numberInput;
        String listOfNumbers;
        
        listOfNumbers = " ";
        
        while (count < 7)
        { 
            inputNumber = JOptionPane.showInputDialog ("This program can take 7 non-negative numbers and compare them. Input your numbers here...");
            
            listOfNumbers = listOfNumbers + inputNumber + ", ";
            
            numberInput = Integer.parseInt (inputNumber);
            
            if (numberInput > value)
            value = numberInput;
            
            count = (count + 1);
        
    }
    JOptionPane.showMessageDialog (null, "Out of all the numbers you typed in, which were"
    + listOfNumbers + value + " was the greatest.");
}
}
