package prep;

import java.util.ArrayList;
import java.util.Arrays;

public class Solution {
	
	public static void main(String[] args)
	{
		int a = 18 % 10;
		System.out.println(a + "    ");
		Solution obj = new Solution();
		ArrayList<Integer> arr= new ArrayList<>();
		arr.addAll(Arrays.asList(1,2,3,4,5,6));
		obj.rotateArray(arr, 19);
	}
	public void rotateArray(ArrayList<Integer> A, int B) {
		ArrayList<Integer> ret = new ArrayList<Integer>();
		int len = A.size();
		int toRotate = (B>len)? B%len : B;
		for (int i = 0; i < A.size()-toRotate; i++) {
			System.out.println(i + B);
			ret.add(A.get(i + B));
		}
		for(int i = 0; i<toRotate;i++)
		{
			ret.add(A.get(i));
		}
		for(Integer ar: ret)
		{
			System.out.println(ar);
		}
	}
}