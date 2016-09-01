/*
Implement the next permutation, which rearranges numbers into the numerically next greater permutation of numbers.

If such arrangement is not possible, it must be rearranged as the lowest possible order ie, sorted in an ascending order.

The replacement must be in-place, do not allocate extra memory.
*/

import java.util.ArrayList;
import java.util.Arrays;

public class nextpermutation {
	
	public static void main(String args[])
	{
		nextpermutation obj = new nextpermutation();
		ArrayList<Integer> a= new ArrayList<>();
		a.addAll(Arrays.asList( 769, 533 ));
		obj.nextPermutation(a);
	}
	
	public void nextPermutation(ArrayList<Integer> a) {
		if(a.size() == 0 || a.size() ==1) return;
	    int p=0,q=0;
	    for(int i = a.size()-2; i>=0; i--)
	    {
	    	if(a.get(i) < a.get(i+1))
	    	{
	    		p=i;
	    		break;
	    	}
	    }
	    for(int j = a.size()-1; j>p; j--)
	    {
	    	if(a.get(j) > a.get(p))
	    	{
	    		q=j;
	    		break;
	    	}
	    }
	    if(p == 0 && q==0) 
	    {
	    	reverse(a, 0, a.size()-1);
	    }
	    else{
	    	int tmp = a.get(p);
	    	a.set(p,a.get(q));
	    	a.set(q, tmp);
	    	if(p+1<a.size()-1){
	    		reverse(a, p+1, a.size()-1);
	    		}
	    	}
	    }
	private void reverse(ArrayList<Integer> a, int start, int end)
	{
	    while(start<=end)
	    {
	        int tmp = a.get(start);
	        a.set(start, a.get(end));
	        a.set(end, tmp);
	        start++;
	        end--;
	    }
	    for(int i = 0; i<a.size(); i++)
	    {
	    	System.out.println(a.get(i));
	    }
	}

}
