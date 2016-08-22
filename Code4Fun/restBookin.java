package prep;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;

public class restBookin {
	
	public static void main(String args[])
	{
		restBookin obj = new restBookin();
		ArrayList<Integer> arrive = new ArrayList<Integer>();
		arrive.addAll(Arrays.asList(35, 8, 23, 22, 35, 6, 48, 45, 33, 43, 37, 12, 42, 3, 31, 38, 5, 33, 15 ));
		ArrayList<Integer> depart = new ArrayList<Integer>();
		depart.addAll(Arrays.asList(43, 32, 34, 46, 74, 50, 95, 62, 59, 79, 83, 19, 88, 34, 75, 42, 42, 50, 58));
		System.out.println(obj.hotel(arrive, depart, 11));
	}
	
	public boolean hotel(ArrayList<Integer> arrive, ArrayList<Integer> depart, int K) {
        Collections.sort(arrive);
        Collections.sort(depart);
        //K=K-1;
        int j = 0;
        for(int i = 1; i<arrive.size();i++)
        {
            if(arrive.get(i) < depart.get(j))
            {
            	K--;
                if(K<=0) return false;
            }
            else j++;
        }
        return true;
    }

}
