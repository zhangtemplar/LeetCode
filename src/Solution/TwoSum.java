public class Solution {
    public int[] twoSum(int[] numbers, int target) {
        // Note: The Solution object is instantiated only once and is reused by each test case.
        // the complexity should be linear, if the array is sorted
        int[]result=new int[2];
        if (numbers==null || numbers.length<2)
        {
            return result;
        }
        // save the index
        // since there is only solution, we know that the duplicate/hit in hash won't our result
        HashMap<Integer, Integer> index=new HashMap<Integer, Integer>();
        int i=0;
        int j=numbers.length-1;
        for (i=0; i<numbers.length; i++)
        {
            index.put(numbers[i], i+1);
        }
        // sprt
        Arrays.sort(numbers);
        // find the result
        i=0;
        j=numbers.length-1;
        while(i<j)
        {
            int sum=numbers[i]+numbers[j];
            if (target==sum)
            {
                break;
            }
            else if(target<sum)
            {
                j--;
            }
            else
            {
                i++;
            }
        }
        // find the old index
        if (index.get(numbers[i])>index.get(numbers[j]))
        {
            result[1]=index.get(numbers[i]);
            result[0]=index.get(numbers[j]);
        }
        else
        {
            result[0]=index.get(numbers[i]);
            result[1]=index.get(numbers[j]);
        }
        return result;
    }
}
