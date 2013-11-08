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
    public ArrayList<Interval> insert(ArrayList<Interval> intervals, Interval newInterval) {
        // IMPORTANT: Please reset any member data you declared, as
        // the same Solution instance will be reused for each test case.
        ArrayList<Interval> result=new ArrayList<Interval>();
        if (intervals==null || intervals.size()<1)
        {
            result.add(newInterval);
            return result;
        }
        // first sort the array
        Collections.sort(intervals, new IntervalComparator());
        Interval current=new Interval(newInterval.start, newInterval.end);
        for (int i=0; i<intervals.size(); i++)
        {
            // yes, we have overlap, then merge it
            if (isOverlap(current, intervals.get(i)))
            {
                current=merge(current, intervals.get(i));
            }
            // ok, we keep who ever is later
            else if (current.start>intervals.get(i).start)
            {
                result.add(intervals.get(i));
            }
            else
            {
                result.add(current);
                current=intervals.get(i);
            }
        }
        result.add(current);
        return result;
    }
    
    private boolean isOverlap(Interval x, Interval y)
    {
        if (x.start>y.start)
        {
            return y.end>=x.start;
        }
        else
        {
            return x.end>=y.start;
        }
    }
    
    private Interval merge(Interval x, Interval y)
    {
        return new Interval(Math.min(x.start, y.start), Math.max(x.end, y.end));
    }
}

class IntervalComparator implements Comparator<Interval>
{
    public int compare(Interval x, Interval y)
    {
        if (x.start!=y.start)
        {
            return x.start-y.start;
        }
        return x.end-y.end;
    }
}
