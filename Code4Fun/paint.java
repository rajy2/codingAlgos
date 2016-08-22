package prep;

import java.util.ArrayList;
import java.util.Arrays;

public class paint {
	
private boolean ispossible(int A, int B, ArrayList<Integer> C, long time) {
	    
	    int n = C.size();
	    int index = 0;
	    long total;
	    
	    for (int i = 0; i < A && index < n; i++) {
	        
	        total = 0;
	        
	        while (total < time*B && index < n) {
	            total += (1L * C.get(index) * B);
	            if (total > time*B)
	                break;
	            index++;
	        }
	    }
	    
	    if (index != n)
	        return false;
	    
	    return true;
	}
	/*boolean ispossible(ArrayList<Integer> C, long maxUnitsToPaint, int painter){
	    long temp=0;
	    int n=C.size();
	    int i=0,index=0;
	    boolean flag = false;
	    for(i=0; i<n;)
	    {
	    	while(temp < maxUnitsToPaint && i<n)
	    	{
	    		temp = temp+C.get(i);
	    		if(temp < maxUnitsToPaint) i++;
	    		else if(temp == maxUnitsToPaint)
	    		{
	    			flag=true;
	    			break;
	    		}
	    		else break;
	    	}
	    	if(index <painter && !flag)
	    		{
	    		index++;
	    		temp = 0;
	    		}
	    	else break;
	    }
	    if(!flag) return false;
	    return true;
	}*/
	public int Paint(int A, int B, ArrayList<Integer> C) {
	   if(C.size()==0)
	        return 0;
	  long l=0,r=0,mid=0,ans=Long.MAX_VALUE;
	  for(int i = 0; i<C.size();i++)
	  {
		  r+=C.get(i);
	  }
	  long mod=10000003;
	  while(l<=r){
	      mid=(l+r)>>1;
	      if(ispossible(A,B,C,mid)){
	          ans=Math.min(ans,mid);
	          r=mid-1;
	      }else l=mid+1;
	  }
	  System.out.println(ans);
	  return (int) (ans*B % mod);
	}
	
	public static void main(String args[])
	{
		int k= 5;
		int t=10;
		ArrayList<Integer> arr = new ArrayList<Integer>();
		arr.addAll(Arrays.asList(658, 786, 531, 47, 169, 397, 914 ));
		paint obj = new paint();
		int a=obj.Paint(k,t,arr);
		System.out.println(a);
	}

}
