package trial3;

import java.util.Stack;

public class SurroundedRegions {
	public static void main(String[] args)
	{
		char[][]board={{'X','X','X','X'},{'X','O','O','X'},{'X','X','O','X'},{'X','O','X','X'}};
		System.out.println(board);
		new SurroundedRegions().solve(board);
		System.out.println(board);
	}
	/**
     * we can use bfs for this problem
     * starting with a point which is o in the boundary
     * if this point is O/I, check its neighbor, if any O, change to I
     * add the neighbor to the list
     * to do that, we also need to mark the point visited before
     * we use upper case for all the points we have already visited
     * 
     * we will use lower case for visited points
     * we will use 'I' for 'O's kept, 'O' for 'O' to be changed
     */
    public void solve(char[][] board) {
        if (board==null || board.length<1 || board[0]==null || board[0].length<1)
        {
            return;
        }
        char lowerToUpper='a'-'A';
        // we use a stack to store the touched point
        Stack<Integer> stackX=new Stack<Integer>();
        Stack<Integer> stackY=new Stack<Integer>();
        
        // push the 'O' in the boundary to the stack first
        for (int x=0; x<board[0].length; x++)
        {
            if (board[0][x]=='O')
            {
                stackX.push(x);
                stackY.push(0);
            }
        }
        for (int x=0; x<board[board.length-1].length; x++)
        {
            if (board[board.length-1][x]=='O')
            {
                stackX.push(x);
                stackY.push(board.length-1);
            }
        }
        for (int y=0; y<board.length; y++)
        {
            if (board[y][0]=='O')
            {
                stackX.push(0);
                stackY.push(y);
            }
            if (board[y][board[y].length-1]=='O')
            {
                stackX.push(board[y].length-1);
                stackY.push(y);
            }
        }
        
        // start BFS from those points and add any 'O's to the list
        while(!stackX.isEmpty())
        {
            int x=stackX.pop();
            int y=stackY.pop();
            
            // mark this as visited
            board[y][x]='i';
            
            // check the neighbor
            if (x>0 && board[y][x-1]=='O')
            {
                board[y][x-1]='i';
                stackX.push(x-1);
                stackY.push(y);
            }
            if (x<board[y].length-1 && board[y][x+1]=='O')
            {
                board[y][x+1]='i';
                stackX.push(x+1);
                stackY.push(y);
            }
            if (y>0 && board[y-1][x]=='O')
            {
                board[y-1][x]='i';
                stackX.push(x);
                stackY.push(y-1);
            }
            if (y<board.length-1 && board[y+1][x]=='O')
            {
                board[y+1][x]='i';
                stackX.push(x);
                stackY.push(y+1);
            }
        }
        
        // change upper case to lower case
        for (int i=0; i<board.length; i++)
        {
            for (int j=0; j<board[i].length; j++)
            {
                // change all visited 'O's (changed to 'i') to 'O'
                if (board[i][j]=='i')
                {
                    board[i][j]='O';
                }
                else
                {
                    board[i][j]='X';
                }
            }
        }
    }
}
