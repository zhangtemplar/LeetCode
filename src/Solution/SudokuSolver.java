public class Solution {
    public void solveSudoku(char[][] board) {
        // IMPORTANT: Please reset any member data you declared, as
        // the same Solution instance will be reused for each test case.
        // the basic idea is simple, we check each cell, row and column to put the solution in
        // we will use backtrace
        solveSudoku(board, 0, 0);
    }
    
    /**
     * this function try a value at position (row, col), if the value there is unkown
     * if this value is valid so far, we will continue to the next cell
     * otherwise, we take one step back
     * @param board the current board
     * @param row col the position we are currently working on
     * @return whether current configuration is valid or not
     */
    private boolean solveSudoku(char[][] board, int row, int col)
    {
        // we alread finish the board
        if (row>=board.length || col>=board[row].length)
        {
            return true;
        }
        // this position is known
        else if (board[row][col]!='.')
        {
            // we just check the next ones
            if (col==board[row].length-1)
            {
                return solveSudoku(board, row+1, 0);
            }
            else
            {
                return solveSudoku(board, row, col+1);
            }
        }
        // try value in this position
        else
        {
            // we check every value from '1' to '9'
            for (char i='1'; i<='9'; i++)
            {
                boolean used=false;
                // check whether i is used in the row
                for (int j=0; j<board[row].length; j++)
                {
                    if (board[row][j]==i)
                    {
                        used=true;
                        break;
                    }
                }
                // this value is used, so try the next value
                if (used)
                {
                    continue;
                }
                // then check the column
                for (int j=0; j<board.length; j++)
                {
                    if (board[j][col]==i)
                    {
                        used=true;
                        break;
                    }
                }
                if (used)
                {
                    continue;
                }
                // check the 3x3 cell
                for (int j=row/3*3; j<(row/3+1)*3; j++)
                {
                    for (int l=col/3*3; l<(col/3+1)*3; l++)
                    {
                        if (board[j][l]==i)
                        {
                            used=true;
                            break;
                        }
                    }
                }
                if (used)
                {
                    continue;
                }
                // so far so good, so we can continue with this value
                board[row][col]=i;
                // check the remaining
                if (col==board[row].length-1)
                {
                    if (solveSudoku(board, row+1, 0))
                    {
                        return true;
                    }
                }
                else if (solveSudoku(board, row, col+1))
                {
                    return true;
                }
                // this value dosen't work, so we take one step back and recover the value
                board[row][col]='.';
            }
            return false;
        }
    }
}
