package Solution;

public class PermutationSequence {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		PermutationSequence instance=new PermutationSequence();
		System.out.println(instance.getPermutation(1, 1));
//		for (int i=0; i<720; i++)
//		{
//			System.out.println(instance.getPermutation(6, i));
//		}
	}

	public String getPermutation(int n, int k) {
        // Start typing your Java solution below
        // DO NOT write main() function
        // we will use recursion
        if (n<1)
        {
            return new String();
        }
        int []pSize=new int[n+1];
        permutationNumber(pSize, n);
        pSize[0]=1;
        // k starts from 1
        k=k-1;
        if (k<0 || k>=pSize[n])
        {
            // too large or two small
            return new String();
        }
        int head;
        int index=n;
        char[] digit=new char[n];
        for (int i=0; i<n; i++)
        {
            digit[i]=(char)(i+'1');
        }
        char []result=new char[n];
        while(index>0)
        {
            head=k/pSize[index-1];
            int j=0;
            while(j<head || digit[j]<'1')
            {
            	if (digit[j]>'0')
            	{
            		j++;
            	}
            	else
            	{
            		j++;
            		head++;
            	}
            }
            k=k%pSize[index-1];
            result[n-index]=digit[j];
            digit[j]='0';
            index--;
        }
        return new String(result);
    }
    
    private void permutationNumber(int []arr, int n)
    {
        if (n==0)
        {
            return;
        }
        else if(n==1)
        {
            arr[n]=1;
            return;
        }
        else
        {
            permutationNumber(arr, n-1);
            arr[n]=n*arr[n-1];
            return;
        }
    }
}
