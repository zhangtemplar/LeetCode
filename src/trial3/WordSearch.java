package trial3;

public class WordSearch {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}
	public boolean exist(char[][] board, String word) {
        if (board==null || board.length<1 || board[0]==null || board[0].length<1)
        {
            return word==null || word.length()<1;
        }
        boolean[][] used=new boolean[board.length][board[0].length];
        for (int y=0; y<board.length; y++)
        {
            for (int x=0; x<board[y].length; x++)
            {
                if (exist(board, word, 0, x, y, used))
                {
                    return true;
                }
            }
        }
        return false;
    }
    
    private boolean exist(char[][] board, String word, int index, int x, int y, boolean[][] used)
    {
        if (index>=word.length())
        {
            return true;
        }
        else
        {
            if (used[y][x]==false && word.charAt(index)==board[y][x])
            {
                used[y][x]=true;
                if (exist(board, word, index+1, x, y, used))
                {
                    return true;
                }
                used[y][x]=false;
            }
            if (x>0 && used[y][x-1]==false && word.charAt(index)==board[y][x-1])
            {
                used[y][x-1]=true;
                if (exist(board, word, index+1, x-1, y, used))
                {
                    return true;
                }
                used[y][x-1]=false;
            }
            if (y>0 && used[y-1][x]==false && word.charAt(index)==board[y-1][x])
            {
                used[y-1][x]=true;
                if (exist(board, word, index+1, x, y-1, used))
                {
                    return true;
                }
                used[y-1][x]=false;
            }
            if (x<board[y].length-1 && used[y][x+1]==false && word.charAt(index)==board[y][x+1])
            {
                used[y][x+1]=true;
                if (exist(board, word, index+1, x+1, y, used))
                {
                    return true;
                }
                used[y][x+1]=false;
            }
            if (y<board.length-1 && used[y+1][x]==false && word.charAt(index)==board[y+1][x])
            {
                used[y+1][x]=true;
                if (exist(board, word, index+1, x, y+1, used))
                {
                    return true;
                }
                used[y+1][x]=false;
            }
            return false;
        }
    }
}
