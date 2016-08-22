package prep;

import java.util.ArrayList;
import java.util.Arrays;

public class MinPath {
	
	public static void main(String[] args)
	{
		ArrayList<ArrayList<Integer>> triangle = new ArrayList<>();
		ArrayList<Integer> temp = new ArrayList<Integer>();
		temp.add(2);
		triangle.add(new ArrayList<Integer>(temp));
		temp.clear();
		temp.addAll(Arrays.asList(3,4));
		triangle.add(new ArrayList<Integer>(temp));
		temp.clear();
		temp.addAll(Arrays.asList(6,5,7));
		triangle.add(new ArrayList<Integer>(temp));
		temp.clear();
		temp.addAll(Arrays.asList(4,1,8,3));
		triangle.add(new ArrayList<Integer>(temp));
		MinPath o = new MinPath();
		o.minimumTotal(triangle);
	}
	
	public int minimumTotal(ArrayList<ArrayList<Integer>> triangle) {
		int[] total = new int[triangle.size()];
		int l = triangle.size() - 1;
	 
		for (int i = 0; i < triangle.get(l).size(); i++) {
			total[i] = triangle.get(l).get(i);
		}
	 
		// iterate from last second row
		for (int i = triangle.size() - 2; i >= 0; i--) {
			for (int j = 0; j < triangle.get(i + 1).size() - 1; j++) {
				total[j] = triangle.get(i).get(j) + Math.min(total[j], total[j + 1]);
			}
		}
	 
		return total[0];
	}

}
