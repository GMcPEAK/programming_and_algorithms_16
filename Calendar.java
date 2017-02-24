/** Grady McPeak
 * Dr. Brown
 * G Period Programming and Algorithms
 * 5/3/16
 * program "Calendar"
 */

/**PROGRAM DESCRIPTION
 * This is a calendar, composed of twelve months with thirty-one days in each month. Users can write notes corresponding with each day or read previosuly written notes.
 * SEE ALSO, program "Months”
 */

import javax.swing.JOptionPane;

public class Calendar
{
    /**VARIABLE DICTIONARY (main)
     * choice (String) - allows user to indicate if they wish to write or read a note or exit the program.
     * done (boolean) - determines if the user has finished using the program yet.
     */
    public static void main (String args [])
    {
        start();
        
        boolean done = false;
        while (done == false)
        {
            String choice = JOptionPane.showInputDialog ("Which would you like to do, write a note or search for old notes? Type 'w' for write, 'r' for read, and 'e' for end program.");
            
            if (choice .compareTo ("w") ==0)
            {
                write();
            }
            else
            if (choice .compareTo ("r") ==0)
            {
                read();
            }
            else
            if (choice .compareTo ("e") ==0)
            {
                done = true; //they have told the program they are done using it...
            }
            else
            {
                JOptionPane.showMessageDialog (null, "Invalid input!");
            }
        }
        
        JOptionPane.showMessageDialog (null, "Thank you for using this Calendar. See you later!");
    }
    
    public static void start ()
    {
        JOptionPane.showMessageDialog (null, "Hello! This program is a calendar, with all twelve months and thrity-one days per month." +
            "\nYou, the user, can write notes and input the notes into a corresponding day, as well as read notes already written for a certain day.");
            
        Months.initializeMonths();
    }
    
    /**VARIABLE DICTIONARY (write)
     * day (int) - the day the user has chosen to write in
     * month (String) - the month the use wishes to make a note in
     * note (String) - the text of the note the user wishes to write
     */
    public static void write ()
    {
        String month = "";
        int day = 0;
        
        month = selectMonth(month);
        day = selectDay (day);
        
        String note = JOptionPane.showInputDialog ("What note would you like to save for " + month + " " + day + "?");
        
        Months.setNote (month, day, note); //writes note in selected month/day
        
        JOptionPane.showMessageDialog (null, "Note successfully saved!");
    }
    
    /**VARIABLE DICTIONARY (read)
     * day (int) - the day the user has chosen to read from
     * month (String) - the month the use wishes to read a note from
     * note (String) - the text of the note the user wishes to read
     */
    public static void read ()
    {
        String month = "";
        int day = 0;
        
        month = selectMonth (month);
        day = selectDay (day);
        
        String message = "";
        message = Months.getNote (month, day, message); //finds note written in selected month/day
        JOptionPane.showMessageDialog (null, message);
    }
    
    /**VARIABLE DICTIONARY (selectMonth)
     * month (String) - the month the user has selected to read or write in/from
     */
    public static String selectMonth (String month)
    {
        month = "";
        
        while (month == "")
        {
            month = JOptionPane.showInputDialog ("Type in a month..."); //user inputs month they'd like to select
        
            if (month.compareTo ("January") == 0) //checks if January
            {
                month = "January";
            }
            else
            if (month .compareTo ("February") == 0) //checks if February
            {
                month = "February";
            }
            else
            if (month .compareTo ("March") == 0) //and so on
            {
                month = "March";
            }
            else
            if (month .compareTo ("April") == 0)
            {
                month = "April";
            }
            else
            if (month .compareTo ("May") == 0)
            {
                month = "May";
            }
            else
            if (month .compareTo ("June") == 0)
            {
                month = "June";
            }
            else
            if (month .compareTo ("July") == 0)
            {
                month = "July";
            }
            else 
            if (month .compareTo ("August") == 0)
            {   
                month = "August";
            }
            else
            if (month .compareTo ("September") == 0)
            {
                month = "September";
            }
            else
            if (month .compareTo ("October") == 0)
            {
                month = "October";
            }
            else
            if (month .compareTo ("November") == 0)
            {
                month = "November";
            }
            else
            if (month .compareTo ("December") == 0)
            {
                month = "December";
            }
            else
            {
                month = "";
                JOptionPane.showMessageDialog (null, "Invalid input!");
            }
        }
        
        return (month);
    }
    
    /**VARIABLE DICTIONARY (selectDay)
     * day (int) - the day the user has input
     */
    public static int selectDay(int day)
    {
        day = Integer.parseInt (JOptionPane.showInputDialog ("What day do you want? (1-31)"));
        
        return (day);
    }
}
