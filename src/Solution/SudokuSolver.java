public class Solution {
    public boolean isValidSudoku(char[][] board) {
        // Note: The Solution object is instantiated only once and is reused by each test case.
        // we just check whether each row/column/cell contain duplicate elements
        if (board==null || board.length!=9 || board[0]==null || board[0].length!=9)
        {
            return false;
        }
        // for each row
        for (int i=0; i<9; i++)
        {
            HashSet<Character> set=new HashSet<Character>();
            for (int j=0; j<9; j++)
            {
                if (board[i][j]>='0' && board[i][j]<='9')
                {
                    // a duplicate detected
                    if (set.add(board[i][j])==false)
                    {
                        return false;
                    }
                }
                else if(board[i][j]!='.')
                {
                    return false;
                }
            }
        }
        // for each row
        for (int i=0; i<9; i++)
        {
            HashSet<Character> set=new HashSet<Character>();
            for (int j=0; j<9; j++)
            {
                if (board[j][i]>='0' && board[j][i]<='9')
                {
                    // a duplicate detected
                    if (set.add(board[j][i])==false)
                    {
                        return false;
                    }
                }
                else if(board[j][i]!='.')
                {
                    return false;
                }
            }
        }
        // for each cell
        for (int i=0; i<3; i++)
        {
            for (int j=0; j<3; j++)
            {
                HashSet<Character> set=new HashSet<Character>();
                for (int ii=0; ii<3; ii++)
                {
                    for (int jj=0; jj<3; jj++)
                    {
                        if (board[i*3+ii][j*3+jj]>='0' && board[i*3+ii][j*3+jj]<='9')
                        {
                            // a duplicate detected
                            if (set.add(board[i*3+ii][j*3+jj])==false)
                            {
                                return false;
                            }
                        }
                        else if(board[i*3+ii][j*3+jj]!='.')
                        {
                            return false;
                        }
                    }
                }
            }
        }
        return true;
    }
}
