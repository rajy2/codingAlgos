/*
You have to paint N boards of length {A0, A1, A2, A3 … AN-1}. There are K painters available and you are also given how much time a painter takes to paint 1 unit of board. You have to get this job done as soon as possible under the constraints that any painter will only paint contiguous sections of board.

2 painters cannot share a board to paint. That is to say, a board
cannot be painted partially by one painter, and partially by another.
A painter will only paint contiguous boards. Which means a
configuration where painter 1 paints board 1 and 3 but not 2 is
invalid.
Return the ans % 10000003

Input :
K : Number of painters
T : Time taken by painter to paint 1 unit of board
L : A List which will represent length of each board

Output:
     return minimum time to paint all boards % 10000003
*/

import java.util.ArrayList;
import java.util.Arrays;

public class paint {
	
public int paint(int a, int b, ArrayList<Integer> c) {
	   if(c.size()==0)
	        return 0;
	  long l=0,r=0,mid=0,ans=Long.MAX_VALUE;
	  for(int i = 0; i<c.size();i++)
	  {
		  r+=c.get(i);
	  }
	  long mod=10000003;
	  while(l<=r){
	      mid=(l+r)>>1;
	      if(ispossible(a,c,mid)){
	          ans=Math.min(ans,mid);
	          r=mid-1;
	      }else l=mid+1;
	  }
	  //System.out.println(ans);
	  return (int) (ans*b % mod);
	}
	private boolean ispossible(int A,ArrayList<Integer> C, long time) {
	    
	    int n = C.size();
	    int index = 0;
	    long total;
	    
	    for (int i = 0; i < A && index < n; i++) {
	        
	        total = 0;
	        
	        while (total < time && index < n) {
	            total += C.get(index);
	            if (total > time)
	                break;
	            index++;
	        }
	    }
	    
	    if (index != n)
	        return false;
	    
	    return true;
	}	
	public static void main(String args[])
	{
		int k= 5;
		int t=10;
		ArrayList<Integer> arr = new ArrayList<Integer>();
		arr.addAll(Arrays.asList(658, 786, 531, 47, 169, 397, 914 ));
		paint obj = new paint();
		int a=obj.paint(k,t,arr);
		System.out.println(a);
	}

}
