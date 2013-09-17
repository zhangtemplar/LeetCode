package Solution;

import java.util.Arrays;

public class ValidSudoku {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		ValidSudoku instance=new ValidSudoku();
		char[][] board={{'5','3','.','.','7','.','.','.','.'},
				{'6','.','.','1','9','5','.','.','.'},
				{'.','9','8','.','.','.','.','6','.'},
				{'8','.','.','.','6','.','.','.','3'},
				{'4','.','.','8','.','3','.','.','1'},
				{'7','.','.','.','2','.','.','.','6'},
				{'.','6','.','.','.','.','2','8','.'},
				{'.','.','.','4','1','9','.','.','5'},
				{'.','.','.','.','8','.','.','7','9'}};
		instance.isValidSudoku(board);
	}

	public boolean isValidSudoku(char[][] board) {
        // Start typing your Java solution below
        // DO NOT write main() function
        // simple solution yet complete
        // we search for each 3x3 block and each line (vertical and horizontal)
        // to check whether there are duplicate element
        // check the input first
        if (board==null || board.length!=9)
        {
            return false;
        }
        for (int i=0; i<9; i++)
        {
            if (board[i]==null || board[i].length!=9)
            {
                return false;
            }
        }
        // for each line first
        boolean duplication[]=new boolean[10];
        for (int i=0; i<9; i++)
        {
            Arrays.fill(duplication, true);
            for (int j=0; j<9; j++)
            {
                if (board[i][j]>='0' && board[i][j]<='9')
                {
                    if (duplication[board[i][j]-'0']==false)
                    {
                        return false;
                    }
                    else
                    {
                        duplication[board[i][j]-'0']=false;
                    }
                }
            }
        }
        // for eahc line
        for (int j=0; j<9; j++)
        {
            Arrays.fill(duplication, true);
            for (int i=0; i<9; i++)
            {
                if (board[i][j]>='0' && board[i][j]<='9')
                {
                    if (duplication[board[i][j]-'0']==false)
                    {
                        return false;
                    }
                    else
                    {
                        duplication[board[i][j]-'0']=false;
                    }
                }
            }
        }
        // for each 3x3 block
        for (int i=0; i<9; i+=3)
        {
            for (int j=0; j<9; j+=3)
            {
                Arrays.fill(duplication, true);
                for (int ii=0; ii<3; ii++)
                {
                    for (int jj=0; jj<3; jj++)
                    {
                        if (board[i+ii][j+jj]>='0' && board[i+ii][j+jj]<='9')
                        {
                            if (duplication[board[i+ii][j+jj]-'0']==false)
                            {
                                return false;
                            }
                            else
                            {
                                duplication[board[i+ii][j+jj]-'0']=false;
                            }
                        }
                    }
                }
            }
        }
        return true;
    }
}
