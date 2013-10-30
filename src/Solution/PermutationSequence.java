public class Solution {
    public String getPermutation(int n, int k) {
        // IMPORTANT: Please reset any member data you declared, as
        // the same Solution instance will be reused for each test case.
        // we don't even need to list all the number
        if (k<1)
        {
            k=1;
        }
        int []table=new int[n];
        int []number=new int[n];
        table[0]=1;
        number[0]=1;
        for (int i=1; i<n; i++)
        {
            table[i]=table[i-1]*(i);
            number[i]=i+1;
        }
        if (k>table[table.length-1]*n)
        {
            k=table[table.length-1]*n;
        }
        StringBuffer result=new StringBuffer();
        k--;
        for (int i=0; i<n; i++)
        {
            int digit=k/table[n-i-1];
            int j;
            int l=0;
            for (j=0; j<number.length; j++)
            {
                if (number[j]>0)
                {
                    l++;
                    if (l>digit)
                    {
                        break;
                    }
                }
            }
            result.append(number[j]);
            number[j]=0;
            k=k%table[n-i-1];
        }
        return result.toString();
    }
}
