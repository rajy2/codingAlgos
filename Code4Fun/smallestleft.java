/*
Given an array, find the nearest smaller element G[i] for every element A[i] in the array such that the element has an index smaller than i.

More formally,

G[i] for an element A[i] = an element A[j] such that 
    j is maximum possible AND 
    j < i AND
    A[j] < A[i]
Elements for which no smaller element exist, consider next smaller element as -1.
*/

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Deque;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

public class smallestleft {
	
	public static void main(String[] args)
	{
		
		smallestleft o = new smallestleft();
		ArrayList<Integer> a = new ArrayList<>();
		a.addAll(Arrays.asList(34, 35, 27, 42, 5, 28, 39, 20, 28));
		o.prevSmaller(a);
	}
	
	public ArrayList<Integer> prevSmaller(ArrayList<Integer> arr) {
        Stack<Integer> s= new Stack<Integer>();
        ArrayList<Integer> res = new ArrayList<Integer>();
        for(int i = 0; i<arr.size(); i++)
        {
            while(!s.isEmpty() && s.peek()>=arr.get(i)) s.pop();
            if(!s.isEmpty()) res.add(s.peek());
            else res.add(-1);
            s.push(arr.get(i));
        }
        return res;
    }

}
