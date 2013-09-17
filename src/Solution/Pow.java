package Solution;

public class Pow {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

	public double pow(double x, int n) {
        // Start typing your Java solution below
        // DO NOT write main() function
        // we use recursion to do that
        // x^n=(x^n/2)^2*x^(n-n/2*2)
        // we will need to take care of the very small number
        if (n==0)
        {
            return 1;
        }
        else if (n==-1)
        {
            return 1/x;
        }
        if (n==1)
        {
            return x;
        }
        else
        {
            double y=pow(x, n/2);
            return y*y*pow(x, n-n/2*2);
        }
    }
}
