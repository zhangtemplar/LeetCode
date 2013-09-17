package Solution;

import java.util.ArrayList;
import java.util.HashMap;

public class SurroundedRegions {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		char [][]board={{'X','O','X','O','X','O','O','O','X','O'},
		{'X','O','O','X','X','X','O','O','O','X'},
		{'O','O','O','O','O','O','O','O','X','X'},
		{'O','O','O','O','O','O','X','O','O','X'},
		{'O','O','X','X','O','X','X','O','O','O'},
		{'X','O','O','X','X','X','O','X','X','O'},
		{'X','O','X','O','O','X','X','O','X','O'},
		{'X','X','O','X','X','O','X','O','O','X'},
		{'O','O','O','O','X','O','X','O','X','O'},
		{'X','X','O','X','X','X','X','O','O','O'}};
		SurroundedRegions instance=new SurroundedRegions();
		instance.solve(board);
		System.out.println(board);
	}

	public void solve(char[][] board) {
        // Start typing your Java solution below
        // DO NOT write main() function
        // the algorithm is simple, we remove every element, unless it is connected to 
        // an element on boundary or such an element
        if (board==null || board.length<1 || board[0]==null || board[0].length<1)
        {
            return;
        }
        ArrayList<Integer> bound_x=new ArrayList<Integer>();
        ArrayList<Integer> bound_y=new ArrayList<Integer>();
        // intialization
        // make the boundaty
        for (int i=0; i<board.length; i++)
        {
            if (board[i][0]=='O')
            {
            	bound_x.add(0);
            	bound_y.add(i);
            }
            if (board[i][board[i].length-1]=='O')
            {
            	bound_x.add(board[i].length-1);
            	bound_y.add(i);
            }
        }
        for (int j=0; j<board[0].length; j++)
        {
            if (board[0][j]=='O')
            {
            	bound_x.add(j);
            	bound_y.add(0);
            }
        }
        for (int j=0; j<board[board.length-1].length; j++)
        {
            if (board[board.length-1][j]=='O')
            {
            	bound_x.add(j);
            	bound_y.add(board.length-1);
            }
        }
        int k=0;
        while(k<bound_x.size())
        {
        	int x=bound_x.get(k);
        	int y=bound_y.get(k);
        	board[y][x]='o';
        	if (x>0 && board[y][x-1]=='O')
        	{
        		bound_x.add(x-1);
        		bound_y.add(y);
        	}
        	if (y>0 && board[y-1][x]=='O')
        	{
        		bound_x.add(x);
        		bound_y.add(y-1);
        	}
        	if (x<board[y].length-1 && board[y][x+1]=='O')
        	{
        		bound_x.add(x+1);
        		bound_y.add(y);
        	}
        	if (y<board.length-1 && board[y+1][x]=='O')
        	{
        		bound_x.add(x);
        		bound_y.add(y+1);
        	}
        	k++;
        }
        // final scan, set every 'O' to 'X' and every 'o' to 'O'
        for (int i=0; i<board.length; i++)
        {
            for (int j=0; j<board[i].length; j++)
            {
                // check the neighbor
                if (board[i][j]=='O')
                {
                    board[i][j]='X';
                }
                if (board[i][j]=='o')
                {
                    board[i][j]='O';
                }
            }
        }
    }
	
	public void solveSlow(char[][] board) {
        // Start typing your Java solution below
        // DO NOT write main() function
        // the problem can be intepreted as follows
        //  1) find all the connected components
        //  2) flip the components which is not adjacent to the bound
		if(board==null || board.length<1 || board[0]==null || board[0].length<1)
        {
            return;
        }
        int [][]label=new int[board.length][board[0].length];
        for (int i=0; i<board.length; i++)
        {
            for (int j=0; j<board[i].length; j++)
            {
                label[i][j]=board[i][j]=='X'?0:1;
            }
        }
        // variables
        HashMap<Integer, Boolean> on_boundary=new HashMap<Integer, Boolean>();
        on_boundary.put(1, false);
        DisjointSets equivalent=new DisjointSets(10000);
        connectedComponent(label, on_boundary, equivalent);
        // second scan: capture the regions
        for (int i=0; i<label.length; i++)
        {
        	for (int j=0; j<label[i].length; j++)
        	{
        		if (label[i][j]>0 && !on_boundary.get(equivalent.find(label[i][j])))
        		{
        			board[i][j]='X';
        		}
        	}
        }
    }
	
	private void connectedComponent(int[][] label, HashMap<Integer, Boolean> on_boundary, DisjointSets equivalent)
	{
		// the index of equivalent class
        int start=2;
		// [0][0]
		if (label[0][0]!=0)
		{
			label[0][0]=start++;
			on_boundary.put(label[0][0], true);
		}
		// [0][j>0]
		for (int j=1; j<label[0].length; j++)
		{
			if (label[0][j]!=0)
            {
                // we have found an 'o'
                // check whether it is connected to other o?
                if (label[0][j-1]<=1)
                {
                    // updated the component
                    label[0][j]=start++;
                    on_boundary.put(label[0][j], true);
                }
                else
                {
                	label[0][j]=label[0][j-1];
                }
            }			
		}
        // find the connected component
        for (int i=1; i<label.length; i++)
        {
        	// [i>0][0]
        	if (label[i][0]!=0)
            {
                // we have found an 'o'
                // check whether it is connected to other o?
                if (label[i-1][0]<=1)
                {
                    // updated the component
                    label[i][0]=start++;
                    on_boundary.put(label[i][0], true);
                }
                else
                {
                	label[i][0]=label[i][0];
                }
            }		
        	// [i>0][j>0]
            for (int j=1; j<label[i].length; j++)
            {
                if (label[i][j]!=0)
                {
                    // we have found an 'o'
                    boolean flag=i==0 || j==0 || i==label.length-1 || j==label[i].length-1;
                    // check whether it is connected to other o?
                    if (label[i][j-1]<=1 && label[i-1][j]<=1)
                    {
                        // updated the component
	                    label[i][j]=start++;
                        on_boundary.put(label[i][j], flag);
                    }
                    else
                    {
                        // otherwise, we need to build the equvilant class
                        if (label[i][j-1]>1)
                        {
                            label[i][j]=equivalent.find(label[i][j-1]);
                            on_boundary.put(label[i][j], flag || on_boundary.get(label[i][j]));
                            if (label[i-1][j]>1)
                            {
                                // build the equvalent class
                                on_boundary.put(equivalent.find(label[i][j]), on_boundary.get(equivalent.find(label[i][j])) || on_boundary.get(equivalent.find(label[i-1][j])));
                                equivalent.union(label[i][j], label[i-1][j]);
                            }
                        }
                        else// if (label[i-1][j]>1)
                        {
                            label[i][j]=equivalent.find(label[i-1][j]);
                            on_boundary.put(label[i][j], flag || on_boundary.get(label[i][j]));
                        }
                    }
                }
            }
        }
	}
}

class DisjointSets {

  private int[] array;

  /**
   *  Construct a disjoint sets object.
   *
   *  @param numElements the initial number of elements--also the initial
   *  number of disjoint sets, since every element is initially in its own set.
   **/
  public DisjointSets(int numElements) {
    array = new int [numElements];
    for (int i = 0; i < array.length; i++) {
      array[i] = -1;
    }
  }

  /**
   *  union() unites two disjoint sets into a single set.  A union-by-rank
   *  heuristic is used to choose the new root.  This method will corrupt
   *  the data structure if root1 and root2 are not roots of their respective
   *  sets, or if they're identical.
   *
   *  @param root1 the root of the first set.
   *  @param root2 the root of the other set.
   **/
  public void union(int root1, int root2) {
    if (array[root2] < array[root1]) {
      array[root1] = root2;             // root2 is taller; make root2 new root
    } else {
      if (array[root1] == array[root2]) {
        array[root1]--;            // Both trees same height; new one is taller
      }
      array[root2] = root1;       // root1 equal or taller; make root1 new root
    }
  }

  /**
   *  find() finds the (int) name of the set containing a given element.
   *  Performs path compression along the way.
   *
   *  @param x the element sought.
   *  @return the set containing x.
   **/
  public int find(int x) {
    if (array[x] < 0) {
      return x;                         // x is the root of the tree; return it
    } else {
      // Find out who the root is; compress path by making the root x's parent.
      array[x] = find(array[x]);
      return array[x];                                       // Return the root
    }
  }
}
