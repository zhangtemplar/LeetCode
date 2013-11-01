public class Solution {
    public boolean exist(char[][] board, String word) {
        // IMPORTANT: Please reset any member data you declared, as
        // the same Solution instance will be reused for each test case.
        if (board==null || board.length<1 || board[0]==null || board[0].length<1)
        {
            return word==null || word.length()<1;
        }
        for (int i=0; i<board.length; i++)
        {
            for (int j=0; j<board[i].length; j++)
            {
                if (exist(board, i, j, word, 0))
                {
                    return true;
                }
            }
        }
        return false;
    }
    
    private boolean exist(char[][] board, int row, int col, String word, int start)
    {
        if (start>=word.length())
        {
            return true;
        }
        // this word is used before
        else if (board[row][col]==0)
        {
            return false;
        }
        else
        {
            // check current location
            if (board[row][col]!=word.charAt(start))
            {
                return false;
            }
            else if(start==word.length()-1)
            {
                return true;
            }
            // mark the current location
            board[row][col]=0;
            // check the next ones
            if (row>0 && exist(board, row-1, col, word, start+1))
            {
                return true;
            }
            if (row<board.length-1 && exist(board, row+1, col, word, start+1))
            {
                return true;
            }
            if (col>0 && exist(board, row, col-1, word, start+1))
            {
                return true;
            }
            if (col<board[row].length-1 && exist(board, row, col+1, word, start+1))
            {
                return true;
            }
            // recover the current location
            board[row][col]=word.charAt(start);
            return false;
        }
    }
}
