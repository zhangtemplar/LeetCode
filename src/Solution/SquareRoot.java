package Solution;

public class SquareRoot {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		SquareRoot instance=new SquareRoot();
		System.out.println(instance.sqrt(2147395599));
	}

	/**
	 * the most important part is avoid overflow
	 * y*y and also lb+ub are potential for the overflow
	 * @param x
	 * @return
	 */
	public int sqrt(int x) {
        // Start typing your Java solution below
        // DO NOT write main() function
        // we will binary search
        if (x<=0)
        {
            return 0;
        }
        int y=x/2;
        int ub=x;
        int lb=0;
        while(ub>=lb)
        {
            if (1.0*y*y>=x-0.5 && 1.0*y*y<=x+0.5)
            {
                return y;
            }
            else if (1.0*y*y<=x-0.5)
            {
                lb=y+1;
                y=(int)((0.0+lb+ub)/2);
            }
            else
            {
                ub=y-1;
                y=(int)((0.0+lb+ub)/2);
            }
        }
        return y;
    }
}
