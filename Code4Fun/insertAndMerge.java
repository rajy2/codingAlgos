package prep;

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
	        int newStart = (newInterval.start < newInterval.end)? newInterval.start : newInterval.end;
	        int newEnd = (newInterval.end > newInterval.start)? newInterval.end : newInterval.start;
	        boolean startFound = false, startEqualEnd = false;
	        int start = 0, end =0;
	        if(newInterval.start == newInterval.end) startEqualEnd = true;
	        else if(newInterval.start > newInterval.end)
	        {
	            newInterval = new Interval(newInterval.end, newInterval.start);
	        }
	        if(intervals.get(intervals.size()-1).end < newStart)
	        {
	            intervals.add(newInterval);
	            return intervals;
	        }
	        if(intervals.get(intervals.size()-1).end == newStart)
	        {
	            intervals.set(intervals.size()-1, new Interval(intervals.get(intervals.size()-1).start,newEnd));
	            return intervals;
	        }
	        for(int i = 0; i<intervals.size(); i++)
	        {
	            if(intervals.get(i).start == newStart)
	            {
	                if(startEqualEnd) return intervals;
	                else if(intervals.get(i).end >= newEnd) return intervals;
	                else 
	                {
	                    start = i;
	                    startFound = true; 
	                }
	            }
	            else if(newStart > intervals.get(i).start && newStart <= intervals.get(i).end
	            		||newStart > intervals.get(i).start  && intervals.get(i).end < newStart )
	            {
	                if(startEqualEnd) return intervals;
	                else{
	                    start = i;
	                    startFound = true;
	                }
	            }
	            else if(intervals.get(i).start > newStart)
	            {
	                if(intervals.get(i).start > newEnd || intervals.get(i).end >= newEnd)
	                {
	                    intervals.set(0,new Interval(newStart, intervals.get(i).end));
	                    return intervals;
	                }
	                else if(i!=0)
	                {
	                    start = i-1;
	                    startFound = true;
	                }
	                else {
	                    start = i; 
	                    startFound = true;
	                }
	            }
	            if(startFound) break;
	        }
	           for(int j = start+1; j<intervals.size(); j++)
	           {
	        	   //System.out.println(intervals.get(j).end);
	        	   if(newEnd < intervals.get(j).start) 
	               {
	        		   end = j-1;
	        		   break;
	                }
	        	   else if(newEnd < intervals.get(j).end)
	               {
	        		   end = j;
	                   break;
	                }
	        	}
	        
	        boolean overlapping = false;
	        if(end == start)
	        {
	        	if(intervals.get(end).end < newStart)
	        	{
	        		intervals.add(start+1, newInterval);
	        		for(int i =0; i<intervals.size();i++)
	    	        {
	    	        	System.out.println("(" + intervals.get(i).start +"," + intervals.get(i).end + ")");
	    	        }
	        		return intervals;
	        	}
	        	else{
	            intervals.set(start, new Interval(Math.min(newStart, intervals.get(start).start),
	            Math.max(newEnd, intervals.get(end).end)));
	            return intervals;
	        	}
	        }
	        else if(end - start > 1)
	        {
	            for(int i = start+1; i<=end; i++)
	            {
	                if(Math.max(intervals.get(i-1).start, intervals.get(i).start) >
	                Math.min(intervals.get(i-1).end, intervals.get(i).end))
	                {
	                    overlapping = true;
	                    break;
	                }
	            }
	        }
	        else{
	            if(Math.max(intervals.get(start).start, intervals.get(end).start) >
	                Math.min(intervals.get(start).end, intervals.get(end).end))
	                {
	                    overlapping = true;
	                }
	        }
	        if(overlapping)
	        {
	            intervals.set(start, new Interval(Math.min(newStart, intervals.get(start).start),
	            Math.max(newEnd, intervals.get(end).end)));
	            int toRemove = end - (start + 1);
	            while(toRemove>=0)
	            {
	                intervals.remove(start+1);
	                toRemove--;
	            }
	        }
	        else{
	            if(newStart > intervals.get(start).end && newEnd < intervals.get(end).end)
	            {
	                intervals.add(start+1, newInterval);
	            }
	            else{
	                intervals.set(start, new Interval(Math.min(newStart, intervals.get(start).start),
	            Math.max(newEnd, intervals.get(end).end)));
	            intervals.remove(end);
	            }
	        }
	        for(int i =0; i<intervals.size();i++)
	        {
	        	System.out.println("(" + intervals.get(i).start +"," + intervals.get(i).end + ")");
	        }
	        return intervals;
	    }

}
