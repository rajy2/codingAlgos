/*
Given a set of non-overlapping intervals, insert a new interval into the intervals (merge if necessary).

You may assume that the intervals were initially sorted according to their start times.

Example 1:

Given intervals [1,3],[6,9] insert and merge [2,5] would result in [1,5],[6,9].

Example 2:

Given [1,2],[3,5],[6,7],[8,10],[12,16], insert and merge [4,9] would result in [1,2],[3,10],[12,16].

This is because the new interval [4,9] overlaps with [3,5],[6,7],[8,10].

Make sure the returned intervals are also sorted.
*/
Given a set of non-overlapping intervals, insert a new interval into the intervals (merge if necessary).

You may assume that the intervals were initially sorted according to their start times.

Example 1:

Given intervals [1,3],[6,9] insert and merge [2,5] would result in [1,5],[6,9].

Example 2:

Given [1,2],[3,5],[6,7],[8,10],[12,16], insert and merge [4,9] would result in [1,2],[3,10],[12,16].

This is because the new interval [4,9] overlaps with [3,5],[6,7],[8,10].

Make sure the returned intervals are also sorted.
*/


import java.util.ArrayList;
import java.util.Arrays;

class Interval {
	      int start;
	      int end;
	      Interval() { start = 0; end = 0; }
	      Interval(int s, int e) { start = s; end = e; }
	  }

public class insertAndMerge {
	public static void main(String[] args)
	{
		insertAndMerge obj = new insertAndMerge();
		ArrayList<Interval> intervals = new ArrayList<>();
		/*
		intervals.addAll(Arrays.asList(new Interval(6037774, 6198243),new Interval(6726550, 7004541),
				new Interval(8842554, 10866536),new Interval(11027721, 11341296),
				new Interval(11027721, 11341296), new Interval(11972532, 14746848),
				new Interval(16374805, 16706396), new Interval(17557262, 20518214),
				new Interval(22139780, 22379559), new Interval(27212352, 28404611), 
				new Interval(28921768, 29621583), new Interval(29823256, 32060921),
				new Interval(33950165, 36418956),new Interval(37225039, 37785557),
				new Interval(40087908, 41184444),new Interval(41922814, 45297414), 
				new Interval(48142402, 48244133), new Interval(48622983, 50443163), 
				new Interval(50898369, 55612831), new Interval(57030757, 58120901), 
				new Interval(59772759, 59943999), new Interval(61141939, 64859907), 
				new Interval(65277782, 65296274), new Interval(67497842, 68386607), 
				new Interval(70414085, 73339545), new Interval(73896106, 75605861), 
				new Interval(79672668, 84539434), new Interval(84821550, 86558001), 
				new Interval(91116470, 92198054), new Interval(96147808, 98979097)));
		Interval newInterval = new Interval(36210193, 61984219);*/
		intervals.addAll(Arrays.asList(new Interval(1,2), new Interval(8,10)));
		Interval newInterval = new Interval(3,6);
		obj.insert(intervals, newInterval);
	}
	
	 public ArrayList<Interval> insert(ArrayList<Interval> intervals, Interval newInterval) {
	        int start, end;
        int startIndex, endIndex;
        int i;
        
        start = newInterval.start;
        end = newInterval.end;
        i = 0;
        
        startIndex = endIndex = -1;
        
        for (Interval in : intervals) {
            
            if (start >= in.start && start <= in.end)
                startIndex = i;
            
            if (end >= in.start && end <= in.end)
                endIndex = i;
            
            i++;
        }
        
        if (startIndex == -1 && endIndex == -1) {
            
            startIndex = 0;
            
            for (i = 0; i < intervals.size(); i++) {
                if (start > intervals.get(i).end) {
                    startIndex = i + 1;
                }
            }
            
            endIndex = intervals.size() - 1;
            
            for (i = intervals.size() - 1; i >= 0 ; i--) {
                if (end < intervals.get(i).start) {
                    endIndex = i - 1;
                }
            }
            
            for (i = startIndex; i <= endIndex; i++) {
                intervals.remove(startIndex);
            }
            
            intervals.add(startIndex, newInterval);
            
            return intervals;
        }
        
        if (startIndex == -1) {
            for (i = intervals.size() - 1; i >= 0 ; i--) {
                if (start <= intervals.get(i).start)
                    startIndex = i;
            }
        }
        
        if (endIndex == -1) {
            for (i = 0; i < intervals.size(); i++) {
                if (end >= intervals.get(i).end)
                    endIndex = i;
            }
        }
        
        start = Math.min(intervals.get(startIndex).start, start);
        end = Math.max(intervals.get(endIndex).end, end);
        
        intervals.get(startIndex).start = start;
        intervals.get(startIndex).end = end;
        
        for (i = startIndex + 1; i <= endIndex; i++) {
            intervals.remove(startIndex + 1);
        }
    
        return intervals;

}
