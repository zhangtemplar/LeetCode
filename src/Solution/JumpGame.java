package Solution;

public class JumpGame {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

	public boolean canJump(int[] A) 
	{
        // Start typing your Java solution below
        // DO NOT write main() function
        // we will use depth first search for this problem
        int maxCover = 0;  
        for(int start =0; start<= maxCover && start<A.length; start++)  
        {  
            if(A[start]+start > maxCover)  
                maxCover = A[start]+start;  
                if(maxCover >= A.length-1) return true;  
        }  
        return false;  
    }
}
