package prep;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class findOneAmongRepeated {
	
	public static void main(String[] args)
	{
		List<Integer> li=new ArrayList<Integer>();
		li.addAll(Arrays.asList(3,3,1,3));
		findOneAmongRepeated o = new findOneAmongRepeated();
		o.singleNumber(li);
	}
	
	public int singleNumber(final List<Integer> a) {
	    int once=0, twice = 0, commonBits;
	    for(int i = 0; i<a.size();i++)
	    {
	        twice = twice|(once&a.get(i));
	        once = once^a.get(i);
	        commonBits = ~(once&twice);
	        once &=commonBits;
	        twice &= commonBits;
	    }
	    return once;
	}

}