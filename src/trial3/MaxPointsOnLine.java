package trial3;

import java.util.HashMap;

public class MaxPointsOnLine {
    /**
     * a naive solution is that, we try all possible lines (O(n2))
     * and check how many points are in these lines (O(n))
     * the total complexity is thus O(n3)
     * 
     * the other method is hough transform: we consider the problem in
     * the line parameter space instead of eculidean space
     * the complexity depends on the resolution of the parameter space
     */ 
    public int maxPoints(Point[] points) {
        // we use the dumy method first
        if (points==null || points.length<1)
        {
            return 0;
        }
        else if (points.length<3)
        {
            return points.length;
        }
        else
        {
            // to reduce the cost, we create a HashMap to store the lists of colinear points
            HashMap<long[], Integer> buffer=new HashMap<long[], Integer>();
            int maxNum=2;
            final int resolution=10000;
            for (int i=0; i<points.length; i++)
            {
                for (int j=i+1; j<points.length; j++)
                {
                    int curNum=0;
                    // in case of a[i]==a[j]
                    if (points[i].x==points[j].x && points[i].y==points[j].y)
                    {
                        long[] key={points[i].x, points[i].y};
                        if (buffer.containsKey(key))
                        {
                            curNum=buffer.get(key);
                        }
                        else
                        {
                            for (int k=0; k<points.length; k++)
                            {
                                if (points[i].x==points[k].x && points[i].y==points[k].y)
                                {
                                    curNum++;
                                }
                            }
                            buffer.put(key, curNum);
                        }
                    }
                    else
                    {
                        // we convert to long in case of overflow of int
                        long aby=((long) points[i].y)-points[j].y;
                        long abx=((long) points[i].x)-points[j].x;
                        // check the buffer first
                        long slope, intercept;
                        if (abx==0)
                        {
                            slope=Long.MAX_VALUE;
                            intercept=Long.MAX_VALUE;
                        }
                        else
                        {
                            slope=aby*resolution/abx;
                            intercept=(((long)points[i].x)*points[j].y-((long)points[j].x)*points[i].y)*resolution/abx;
                        }
                        long []key={slope, intercept};
                        if (buffer.containsKey(key))
                        {
                            curNum=buffer.get(key);
                        }
                        else
                        {
                            // not saw before
                            for (int k=0; k<points.length; k++)
                            {
                                if (aby*((long)points[i].x-points[k].x)==abx*((long)points[i].y-points[k].y))
                                {
                                    curNum++;
                                }
                            }
                            // put it into buffer
                            buffer.put(key, curNum);
                        }
                    }
                    if (curNum>maxNum)
                    {
                        maxNum=curNum;
                    }
                }
            }
            return maxNum;
        }
    }
}
