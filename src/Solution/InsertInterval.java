package Solution;

import java.util.ArrayList;

public class InsertInterval {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

	public ArrayList<Interval> insert(ArrayList<Interval> intervals, Interval newInterval) {
        // Start typing your Java solution below
        // DO NOT write main() function
        ArrayList<Interval> result=new ArrayList<Interval>();
        if (intervals==null || intervals.size()<1)
        {
            result.add(newInterval);
            return result;
        }
        if (newInterval==null)
        {
            return intervals;
        }
        boolean flag=false;
        for (int i=0; i<intervals.size(); i++)
        {
            if (isOverlap(newInterval, intervals.get(i)))
            {
                // merge this two
                newInterval.start=newInterval.start>intervals.get(i).start?intervals.get(i).start:newInterval.start;
                newInterval.end=newInterval.end>intervals.get(i).end?newInterval.end:intervals.get(i).end;
            }
            else
            {
                if (intervals.get(i).start<newInterval.start)
                {
                    // things before the insert position
                    result.add(intervals.get(i));
                }
                else// if (intervals.get(i).start>newInterval.end)
                {
                    // things after the insert position
                    if (flag==false)
                    {
                        result.add(newInterval);
                        flag=true;
                    }
                    result.add(intervals.get(i));
                }
            }
        }
        if (flag==false)
        {
            result.add(newInterval);
            flag=true;
        }
        return result;
    }
    
    // we assume
    private boolean isOverlap(Interval x, Interval y)
    {
        if (x.start<=y.start)
        {
            if (y.start<=x.end)
            {
                return true;
            }
            return false;
        }
        else
        {
            if (x.start<=y.end)
            {
                return true;
            }
            return false;
        }
    }
}
