public class Solution {
    public ArrayList<String[]> solveNQueens(int n) {
        // Note: The Solution object is instantiated only once and is reused by each test case.
        // we will use backtrace
        // for N queen problem, we know that, each row/column will have one queen
        // for from Row 0 to Row n-1, we place the queen on the position which dosen't
        // conflict with all the previous queens. If we made to n, we save the result
        if (n<1)
        {
            return new ArrayList<String[]>();
        }
        // this variable stores the location of the n queen
        int []location=new int[n];
        return solveNQueens(location, 0);
    }
    
    /**
     * we store the location of the current queens in location
     * current indicates the index of queens we are currently looking at
     * If current==location.length, we got one solution
     */ 
    private ArrayList<String[]> solveNQueens(int []location, int current)
    {
        ArrayList<String[]> result=new ArrayList<String[]>();
        if (current>=location.length)
        {
            // create the result
            result.add(createResult(location));
        }
        else
        {
            // for each possible location, we check its compatibility of the previous queens
            for (int i=0; i<location.length; i++)
            {
                boolean flag=true;
                for (int j=0; j<current; j++)
                {
                    // column, 45 diagnoal, 135 diagnoal
                    if (i==location[j] || i-current==location[j]-j || i+current==location[j]+j)
                    {
                        flag=false;
                        break;
                    }
                }
                // we have a valid location, then check the next one
                if (flag)
                {
                    location[current]=i;
                    result.addAll(solveNQueens(location, current+1));
                }
            }
        }
        return result;
    }
    
    private String[] createResult(int[] location)
    {
        String []board=new String[location.length];
        for (int i=0; i<location.length; i++)
        {
            char[] result=new char[location.length];
            Arrays.fill(result, '.');
            result[location[i]]='Q';
            board[i]=new String(result);
        }
        return board;
    }
}
