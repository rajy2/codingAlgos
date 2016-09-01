/*
A hotel manager has to process N advance bookings of rooms for the next season. His hotel has K rooms. Bookings contain an arrival date and a departure date. He wants to find out whether there are enough rooms in the hotel to satisfy the demand. Write a program that solves this problem in time O(N log N) .

Input:


First list for arrival time of booking.
Second list for departure time of booking.
Third is K which denotes count of rooms.

Output:

A boolean which tells whether its possible to make a booking. 
Return 0/1 for C programs.
O -> No there are not enough rooms for N booking.
1 -> Yes there are enough rooms for N booking.
*/

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
