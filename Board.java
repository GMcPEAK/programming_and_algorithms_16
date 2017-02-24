/** Grady McPeak
 * Dr. Brown
 * 
 * G Period Programming and Algorithms
 * 6/8/16
 * 
 * "Board"
 * 
 * See also "TTT Grady" and "Piece"
 */

/** PROGRAM DESCRPTION
 * This is a companion program to "TTT Grady" and it handles many of the board's functions such as getting and setting pieces
 */


public class Board
{
    private String [][] spaces = new String [4][4];
    private String gameImage = ""; 
    private Piece thisPiece = new Piece ();
    
    public void setSpace (int row, int column, int turn)
    
    /** VARIABLE DICTIONARY
     * row (int) - the row in which the piece will be set
     * column (int) - the column in which the piece will be set
     * turn (int) - the current number turn
     */
    
    {
        spaces[row][column] = thisPiece.setWhichPiece(turn);
    }
    
    public String getImage ()
    
    /**VARIABLE DICTIONARY
     * gameImage (String) - the ASCII graphic game board
     * count1, count2 (int) - used to construct the game image
     */
    
    {
        gameImage = "        1            2           3\n";
        
        for (int count1 = 1; count1 <= 3; count1 ++)
        {
            gameImage = gameImage + (count1 + "    ");
            for (int count2 = 1; count2 <= 3; count2 ++)
            {
                gameImage = gameImage + spaces[count1][count2];
            }
            
            gameImage = gameImage + "\n";
        }
        
        return (gameImage);
    }
    
    public void initializeBoard ()
    
    /**VARIABLE DICTIONARY
     * count1, count2 (int) - used to construct the game image
     */
    
    {
        for (int count1 = 1; count1 <= 3; count1 ++) //sets up the board for use
        {
            for (int count2 = 1; count2 <= 3; count2 ++)
            {
                spaces [count1] [count2] = "[_____]";
            }
        }
    }
    
    public String getSpaces (int first, int second)
    
    /**VARIABLE DICTIONARY
     * first (int) - the row to set
     * second (int) - the column to set
     */
    
    {
        return (spaces[first][second]);
    }
    
    public boolean checkIfUsed (int row, int column, boolean used)
    
    /**VARIABLE DICTIONARY
     * column (int) - the column to check in
     * row (int) - the row to check in
     * used (boolean) - whether or not the desired space is already used
     */
    
    {
        if (spaces[row][column].compareTo ("[__X__]") ==0 || spaces[row][column].compareTo ("[__O__]") ==0)
        {
            used = true;
        }
        else
        {
            used = false;
        }
        
        return (used);
    }
}


