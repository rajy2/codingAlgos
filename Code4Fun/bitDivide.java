package prep;

public class bitDivide {
	
	public static void main(String[] args)
	{
		bitDivide o =new bitDivide();
		System.out.println(o.divide(10, 2));
	}

	public int divide(int dividend, int divisor) {
        long p = Math.abs((long)dividend);
        long q = Math.abs((long)divisor);
        
        int ret = 0;
        while (p >= q) {
            int counter = 0;
            while (p >= (q << counter)) {
                counter++;
            }
            ret += 1 << (counter - 1);
            p -= q << (counter - 1);
        }
        if (dividend == Integer.MIN_VALUE && divisor == -1)
            return Integer.MAX_VALUE;
            
        if ((dividend > 0 && divisor > 0) || (dividend < 0 && divisor < 0))
            return ret;
        else
            return -ret;
    }
}
