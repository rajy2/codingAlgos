package prep;

import java.util.ArrayList;
import java.util.Arrays;

public class minJump {
	
	public static void main(String[] args)
	{
		minJump o = new minJump();
		ArrayList<Integer> a = new ArrayList<>();
		a.addAll(Arrays.asList(33, 21, 50, 0, 0, 46, 34, 3, 0, 12, 33, 0, 31, 37, 15, 17, 34, 18, 0, 4, 12, 41, 18, 35, 37, 34, 0, 47, 0, 39, 32, 49, 5, 41, 46, 26, 0, 2, 49, 35, 4, 19, 2, 27, 23, 49, 19, 38, 0, 33, 47, 1, 21, 36, 18, 33, 0, 1, 0, 39, 0, 22, 0, 9, 36, 45, 31, 4, 14, 48, 2, 33, 0, 39, 0, 37, 48, 44, 0, 11, 24, 16, 10, 23, 22, 41, 32, 14, 22, 16, 23, 38, 42, 16, 15, 0, 39, 23, 0, 42, 15, 25, 0, 41, 2, 48, 28 ));
		o.jump(a);
	}
	
	public int jump(ArrayList<Integer> a) {
	    if(a==null || a.size()==0 || a.size()==1) return 0;
	    int n = a.size();
	    boolean feasible = true;
        int lend = 1, jump_cnt = 0,i = 0;
        while (feasible)
        {
            int lr = 0;
            for ( ; i < lend; ++i)
            {
                if (i + a.get(i) > lr) lr = i + a.get(i) + 1;
            }
            if (lr >= n) break;
            feasible = (lend < lr);
            lend = lr;
            jump_cnt++;
        }
        return feasible ? jump_cnt : -1;
	}

}
