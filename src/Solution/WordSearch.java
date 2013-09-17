package Solution;

public class WordSearch {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		WordSearch instance=new WordSearch();
		char[][]board={{'a'}};
		String word="a";
		System.out.println(instance.exist(board, word));
	}

	public boolean exist(char[][] board, String word) {
        // Start typing your Java solution below
        // DO NOT write main() function
        // one way is too use DFS
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
    
    /**
     * check the substring for word[idx: end] with char at board[row][col]
     */
    private boolean exist(char [][]board, int row, int col, String word, int idx)
    {
        if (idx>=word.length())
        {
            return true;
        }
        else
        {
            if (word.charAt(idx)!=board[row][col])
            {
                return false;
            }
            else
            {
            	if (idx==word.length()-1)
            	{
            		return true;
            	}
                boolean result=false;
                // mark out the curent word
                board[row][col]=0;
                if (row>0)
                {
                    result=exist(board, row-1, col, word, idx+1);
                    if (result)
                    {
                        return true;
                    }
                }
                if (row<board.length-1)
                {
                    result=exist(board, row+1, col, word, idx+1);
                    if (result)
                    {
                        return true;
                    }
                }
                if (col>0)
                {
                    result=exist(board, row, col-1, word, idx+1);
                    if (result)
                    {
                        return true;
                    }
                }
                if (col<board[row].length-1)
                {
                    result=exist(board, row, col+1, word, idx+1);
                    if (result)
                    {
                        return true;
                    }
                }
                // recover it
                board[row][col]=word.charAt(idx);
                return false;
            }
            
        }
    }
}
