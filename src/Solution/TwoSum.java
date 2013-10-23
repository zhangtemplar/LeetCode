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
        // for value we use an arraylist to deal with duplicate element in the array
        HashMap<Integer, ArrayList<Integer>> index=new HashMap<Integer, ArrayList<Integer>>();
        int i=0;
        int j=numbers.length-1;
        for (i=0; i<numbers.length; i++)
        {
            if (index.containsKey(numbers[i]))
            {
                index.get(numbers[i]).add(i+1);
            }
            else
            {
                ArrayList<Integer> entry=new ArrayList<Integer>();
                entry.add(i+1);
                index.put(numbers[i], entry);
            }
        }
        // sort
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
        if (numbers[i]==numbers[j])
        {
            // there will be conflict
            result[0]=index.get(numbers[i]).get(0);
            result[1]=index.get(numbers[i]).get(1);
        }
        else
        {
            int x=index.get(numbers[i]).get(0);
            int y=index.get(numbers[j]).get(0);
            result[0]=x<y?x:y;
            result[1]=x>y?x:y;
        }
        return result;
    }
}
