/*
You are given an integer N. You have to find smallest multiple of N which consists of digits 0 and 1 only. Since this multiple could be large, return it in form of a string.

Note:
- Returned string should not contain leading zeroes.

For example,

For N = 55, 110 is smallest multiple consisting of digits 0 and 1.
For N = 2, 10 is the answer.
*/

import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedList;
import java.util.Queue;

public class smallestMultiple01 {
	
	public String multiple(int A) {
        // flag -> tracks visited
        ArrayList<Integer> flag = new ArrayList<Integer>(Collections.nCopies(A,0));
        // When state x is reached : 
        // parent -> stores from which node we arrived at node x, say node y
        // val -> What(0 or 1) was appended at string at node y to reach node x
        ArrayList<Integer> parent = new ArrayList<Integer>(Collections.nCopies(A,0));
        ArrayList<Integer> val = new ArrayList<Integer>(Collections.nCopies(A,0));
        int p,q,temp=0;
        StringBuilder ret = new StringBuilder();
        Queue<Integer>  Q = new LinkedList<Integer>();
        temp = 1%A;
        flag.set(temp,1);
        val.set(temp,1);
        Q.add(temp);
        
        while(true)
        {
            p = Q.remove();
            if(p==0)
            {
                ret.append(val.get(p));
                p = parent.get(p);
                while(p!=0)
                {
                    ret.append(val.get(p));
                    p=parent.get(p);
                }
                ret.reverse();
                return ret.toString();
            }
            q=(p*10)%A;
            if(flag.get(q)==0)
            {
                Q.add(q);
                flag.set(q,1);
                parent.set(q,p);
                val.set(q,0);
            }
            q++;
            if(q>=A) q-=A;
            if(flag.get(q)==0)
            {
                Q.add(q);
                parent.set(q,p);
                flag.set(q,1);
                val.set(q,1);
            }
        }
    }
	     
	public static void main(String[] args) {
	    smallestMultiple01 o = new smallestMultiple01();
	    System.out.println(o.getnum(55));
	}

}
