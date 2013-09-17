package Solution;

import java.util.Arrays;
import java.util.HashMap;
import java.util.LinkedList;

public class SudokuSolver {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		SudokuSolver instance=new SudokuSolver();
		String []board2={"..9748...","7........",".2.1.9...","..7...24.",".64.1.59.",".98...3..","...8.3.2.","........6","...2759.."};
		char[][]board=new char[9][];
		for (int i=0; i<9; i++)
		{
			board[i]=board2[i].toCharArray();
		}
//		char[][] board={{'5','3','.','.','7','.','.','.','.'},
//				{'6','.','.','1','9','5','.','.','.'},
//				{'.','9','8','.','.','.','.','6','.'},
//				{'8','.','.','.','6','.','.','.','3'},
//				{'4','.','.','8','.','3','.','.','1'},
//				{'7','.','.','.','2','.','.','.','6'},
//				{'.','6','.','.','.','.','2','8','.'},
//				{'.','.','.','4','1','9','.','.','5'},
//				{'.','.','.','.','8','.','.','7','9'}};
		instance.solveSudoku(board);
		instance.printSudoku(board);
	}

	public void printSudoku(char[][] board)
	{
		for (int i=0; i<9; i++)
		{
			for (int j=0; j<9; j++)
			{
				System.out.print(board[i][j]);
			}
			System.out.println();
		}
	}
	
	public void solveSudoku(char[][] board) {
        // Start typing your Java solution below
        // DO NOT write main() function
        // we formulate it as graph problem
        // in this graph, we will only store the empty lot
        // the edge is build between two nodes, if they are in the same line or block
        // check the input first
        if (board==null || board.length!=9)
        {
            return;
        }
        for (int i=0; i<9; i++)
        {
            if (board[i]==null || board[i].length!=9)
            {
                return;
            }
        }
        // build the map
        HashMap<Location, Node> map=new HashMap<Location, Node>();
        for (int i=0; i<9; i++)
        {
            for (int j=0; j<9; j++)
            {
                if (board[i][j]=='.')
                {
                    Location loc=new Location(i, j);
                    Node node=new Node(loc);
                    // set the valid choice
                    for (int k=0; k<9; k++)
                    {
                        if (board[i][k]>='1' && board[i][k]<='9')
                        {
                        	node.invalid(board[i][k]-'0');
                        }
                        else
                        {
                        	Location next=new Location(i, k);
                            if (map.containsKey(next))
                            {
                                Node neighbor=map.get(next);
                                // to make the map undirected
                                neighbor.adjacency.add(node);
                                node.adjacency.add(neighbor);
                            }
                        }
                    }
                    for (int k=0; k<9; k++)
                    {
                        if (board[k][j]>='1' && board[k][j]<='9')
                        {
                        	node.invalid(board[k][j]-'0');
                        }
                        else
                        {
                        	Location next=new Location(k, j);
                            if (map.containsKey(next))
                            {
                                Node neighbor=map.get(next);
                                // to make the map undirected
                                neighbor.adjacency.add(node);
                                node.adjacency.add(neighbor);
                            }
                        }
                    }
                    for (int ii=i/3*3; ii<i/3*3+3; ii++)
                    {
                        for (int jj=j/3*3; jj<j/3*3+3; jj++)
                        {
                            if (board[ii][jj]>='1' && board[ii][jj]<='9')
                            {
                            	node.invalid(board[ii][jj]-'0');
                            }
                            else
                            {
                                Location next=new Location(ii, jj);
                                if (map.containsKey(next))
                                {
                                    Node neighbor=map.get(next);
                                    // to make the map undirected
                                    neighbor.adjacency.add(node);
                                    node.adjacency.add(neighbor);
                                }
                            }
                        }
                    }
                    map.put(loc, node);
                }
            }
        }
        // now we have a undirected graph, where each node is the slot to be filled
        // with the list of its neighbor and current valid numbers for this slot
        // we start with the nodes with only 1 valid number
        LinkedList<Node> queue=new LinkedList<Node>(map.values());
        boolean flag=false;
        while (!queue.isEmpty())
        {
            flag=false;
            for (Node node: queue)
            {
//                if (node.num_valid==0)
//                {
//                    // an error happens
//                    return;
//                }
                if (node.num_valid==1)
                {
                    // we can start here
                	int i;
                    for (i=1; i<10; i++)
                    {
                        if (node.valid[i])
                        {
                            board[node.loc.x][node.loc.y]=(char)(i+'0');
                            node.invalid(i);
                            break;
                        }
                    }
                    // change the valid of its neighbor
                    for (Node next: node.adjacency)
                    {
                    	next.invalid(i);
                        // remove the neighbor
                        next.adjacency.remove(node);
                    }
	                // remove this node
                    // it will invoke checkForComodification error
//	                queue.remove(node);
	                flag=true;
                }
            }
            if (flag==false)
            {
                // some error also happens here
                return;
            }
        }
    }
}

class Node implements Comparable<Node>
{
    boolean[] valid;
    int num_valid;
    LinkedList<Node> adjacency;
    Location loc;
    
    public Node(Location l)
    {
        valid=new boolean[10];
        Arrays.fill(valid, true);
        adjacency=new LinkedList<Node>();
        num_valid=9;
        loc=l;
    }
    
    public void invalid(int i)
    {
    	// make one digit invalid
    	if (i>=1 && i<=9 && valid[i])
    	{
    		valid[i]=false;
    		num_valid--;
    	}
    }
    
    public int compareTo(Node node)
    {
        return num_valid-node.num_valid;
    }
    
    public String toString()
    {
    	return new String("["+num_valid+","+loc.toString()+"]");
    }
}

class Location
{
    int x;
    int y;
    
    public Location(int c, int r)
    {
        x=c;
        y=r;
    }
    
    public String toString()
    {
    	return new String("("+x+","+y+")");
    }
    
    public boolean equals(Object loc)
    {
    	if (loc instanceof Location)
    	{
    		return (((Location)loc).x==x) && (((Location)loc).y==y);
    	}
    	return false;
    }
    
    public int hashCode()
    {
    	return y*9+x;
    }
}
