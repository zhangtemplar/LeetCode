package Solution;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;

public class MergeIntervals {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		MergeIntervals instance=new MergeIntervals();
		ArrayList<Interval> data=new ArrayList<Interval>();
		data.add(new Interval(1, 4));
		data.add(new Interval(1, 4));
		System.out.println(instance.merge(data));
	}

	public ArrayList<Interval> merge(ArrayList<Interval> intervals) {
        // Start typing your Java solution below
        // DO NOT write main() function
        if (intervals==null || intervals.size()<2)
        {
            return intervals;
        }
        Collections.sort(intervals, new Comp());
        ArrayList<Interval> result=new ArrayList<Interval>();
        Interval current=intervals.get(0);
        for (int i=1; i<intervals.size(); i++)
        {
            if (isOverlap(current, intervals.get(i)))
            {
                // it is overlap, we update it
                current.end=current.end>intervals.get(i).end?current.end:intervals.get(i).end;
            }
            else
            {
                // add the previous overlap it
                result.add(current);
                current=intervals.get(i);
            }
        }
        // add the final one in
        result.add(current);
        return result;
    }
    
    // we assume x.start<=y.start
    private boolean isOverlap(Interval x, Interval y)
    {
        if (y.start<=x.end)
        {
            return true;
        }
        return false;
    }
    
    private static class Comp implements Comparator<Interval>
    {
        public int compare(Interval x, Interval y)
        {
            return x.start-y.start;
        }
        
        public boolean equals(Object obj)
        {
            return true;
        }
    }
}

//Definition for an interval.
class Interval {
    int start;
    int end;
    Interval() { start = 0; end = 0; }
    Interval(int s, int e) { start = s; end = e; }
    public String toString()
    {
    	return new String("["+start+","+end+"]");
    }
}