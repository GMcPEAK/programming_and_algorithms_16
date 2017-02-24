/** Grady McPeak
 * Dr. Brown
 * 
 * G Period Programming and Algorithms
 * 6/8/16
 * 
 * "Piece"
 * 
 * See also "TTT Grady" and "Board"
 */

/** PROGRAM DESCRPITION
 * A companion piece to "TTT Grady". Sets and gets pieces
 */

import javax.swing.JOptionPane;

public class Piece
{
    private String whichPiece;
    private String [] player = new String [3];
    
    public String setWhichPiece (int turn)
    
    /**VARIABLE DICTIONARY
     * turn (int) - the current turn in the game
     */
    
    {
        if (turn % 2 == 0)
        {
            whichPiece = "[__O__]";
        }
        else
        {
            whichPiece = "[__X__]";
        }
        
        return (whichPiece);
    }
    
    public String getWhichPlayer (int turn)
    
     /**VARIABLE DICTIONARY
     * turn (int) - the current turn in the game
     */
    
    {
        if (turn % 2 == 0)
        {
            return (player[2]);
        }
        else
        {
            return (player[1]);
        }
    }
    
    public void setWhichPlayer ()
    {
        player [1] = JOptionPane.showInputDialog ("Player one, what is your name?");
        player [2] = JOptionPane.showInputDialog ("What is player two's name?");
    }
}

