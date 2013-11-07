public class Solution {
    public void solve(char[][] board) {
        // IMPORTANT: Please reset any member data you declared, as
        // the same Solution instance will be reused for each test case.
        // the idea is simple, we set every element to 'x', if it is not 'o' and it is not connected to the bound with a path with only 'o'
        if (board==null || board.length<3 || board[0]==null || board[0].length<3)
        {
            return;
        }
        // preprocess the bound, we set the 'o' on the bound to 'O'
        // we will use a array to store the 'O' which won't be changed
        LinkedList<Integer> x=new LinkedList<Integer>();
        LinkedList<Integer> y=new LinkedList<Integer>();
        for (int i=0; i<board.length; i++)
        {
            if (board[i][0]=='O')
            {
                x.add(0);
                y.add(i);
            }
            if (board[i][board[i].length-1]=='O')
            {
                x.add(board[i].length-1);
                y.add(i);
            }
        }
        for (int i=0; i<board[0].length; i++)
        {
            if (board[0][i]=='O')
            {
                x.add(i);
                y.add(0);
            }
        }
        for (int i=0; i<board[board.length-1].length; i++)
        {
            if (board[board.length-1][i]=='O')
            {
                x.add(i);
                y.add(board.length-1);
            }
        }
        while(!x.isEmpty() && !y.isEmpty())
        {
            int j=x.remove();
            int i=y.remove();
            board[i][j]='o';
            if (i>0 && board[i-1][j]=='O')
            {
                x.add(j);
                y.add(i-1);
            }
            if (i<board.length-1 && board[i+1][j]=='O')
            {
                x.add(j);
                y.add(i+1);
            }
            if (j>0 && board[i][j-1]=='O')
            {
                x.add(j-1);
                y.add(i);
            }
            if (j<board[i].length-1 && board[i][j+1]=='O')
            {
                x.add(j+1);
                y.add(i);
            }
        }
        for (int i=0; i<board.length; i++)
        {
            for (int j=0; j<board[i].length; j++)
            {
                if (board[i][j]=='o')
                {
                    board[i][j]='O';
                }
                else if(board[i][j]=='O')
                {
                    board[i][j]='X';
                }
            }
        }
    }
}
