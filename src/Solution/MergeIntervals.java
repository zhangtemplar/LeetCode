/**
 * Definition for an interval.
 * public class Interval {
 *     int start;
 *     int end;
 *     Interval() { start = 0; end = 0; }
 *     Interval(int s, int e) { start = s; end = e; }
 * }
 */
public class Solution {
    public ArrayList<Interval> merge(ArrayList<Interval> intervals) {
        // IMPORTANT: Please reset any member data you declared, as
        // the same Solution instance will be reused for each test case.
        ArrayList<Interval> result=new ArrayList<Interval>();
        if (intervals==null || intervals.size()<1)
        {
            return result;
        }
        // we first sort the intervals
        Collections.sort(intervals, new IntervalComp());
        // we combine the list one by one
        Interval x=new Interval(intervals.get(0).start, intervals.get(0).end);
        for (Interval y: intervals)
        {
            // find an overlap, merge it
            if (isOverlap(x, y))
            {
                x.start=Math.min(x.start, y.start);
                x.end=Math.max(x.end, y.end);
            }
            // otherwise create a new entry
            else
            {
                result.add(x);
                x=new Interval(y.start, y.end);
            }
        }
        result.add(x);
        return result;
    }
    
    private boolean isOverlap(Interval x, Interval y)
    {
        if (x.start<y.start)
        {
             return x.end>=y.start;
        }
        else
        {
            return  y.end>=x.start;
        }
    }
}

class IntervalComp implements Comparator<Interval>
{
    public int compare(Interval x, Interval y)
    {
        if (x.start!=y.start)
        {
            return x.start-y.start;
        }
        else
        {
            return x.end-y.end;
        }
    }
}
