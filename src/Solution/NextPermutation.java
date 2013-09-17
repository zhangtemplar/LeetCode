package Solution;

public class NextPermutation {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		NextPermutation instance=new NextPermutation();
		int []num={1,1};
		instance.nextPermutation(num);
		System.out.println(num);
	}

	public void nextPermutation(int[] num) {
		// Start typing your Java solution below
        // DO NOT write main() function
        if (num==null || num.length<2)
        {
            return;
        }
        // Step 1 from right to left, find the first digit which is smaller than its left
        int separator=0;
        for (int i=num.length-1; i>0; i--)
        {
            if (num[i]>num[i-1])
            {
                separator=i;
                break;
            }
        }
        int swap;
        // this number could be already the largest, we return it as the smallest
        if (separator<1)
        {
            for (int i=0; i<num.length-1-i; i++)
            {
                swap=num[i];
                num[i]=num[num.length-1-i];
                num[num.length-1-i]=swap;
            }
            return;
        }
        // Step 2 & Step 3
        // after sorting, the smallest digit required in Step 2, will be on arr[i-1]
        // since the number of digit is limited a bubble sorting is not that bad
        for (int i=separator; i<num.length; i++)
        {
            for (int j=i+1; j<num.length; j++)
            {
                if (num[i]>num[j])
                {
                    swap=num[i];
                    num[i]=num[j];
                    num[j]=swap;
                }
            }
        }
        // final step
        // find the smallest element that is larger num[sepeator-1]
        int min_index=num.length-1;
        for (int i=separator; i<num.length-1; i++)
        {
            if (num[i]>num[separator-1])
            {
                min_index=i;
                break;
            }
        }
        swap=num[separator-1];
        num[separator-1]=num[min_index];
        num[min_index]=swap;
    }
}
