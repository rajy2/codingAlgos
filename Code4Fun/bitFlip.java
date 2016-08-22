package prep;

public class bitFlip {
	public static void main(String[] args)
	{
		String a = "00011000";
		//int i = Integer.parseInt(a,2);
		int maxDiff = 0;
		int flipStartIndex = 0;
		int flipEndIndex = 0;
		int onesToFlip = 0;
		int totalNumberOfOnes = 0;

		int currentDiff = 0;
		int currentStart = 0;
		int currentOnesToFlip = 0;

		for (int i = 0; i < a.length(); i++) {
		    if (a.charAt(i) == '0') {
				currentDiff -= 1;
		    } else {
				currentDiff += 1;
				currentOnesToFlip++;
				totalNumberOfOnes++;
		    }
		    if (currentDiff < maxDiff) {
				maxDiff = currentDiff;
				flipStartIndex = currentStart;
				flipEndIndex = i;
				onesToFlip = currentOnesToFlip;
		    } else if (currentDiff > 0) {
				currentDiff = 0;
				currentStart = i + 1;
				currentOnesToFlip = 0;
		    }
		}
		System.out.println(flipEndIndex - flipStartIndex + 1 - onesToFlip +   totalNumberOfOnes - onesToFlip);

		//System.out.println(i);
		//System.out.println(Integer.toBinaryString(i));
	}

}
