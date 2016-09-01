/*

Knight movement on a chess board

Given any source point and destination point on a chess board, we need to find whether Knight can move to the destination or not.

Input:

N, M, x1, y1, x2, y2
where N and M are size of chess board
x1, y1  coordinates of source point
x2, y2  coordinates of destination point
Output:

return Minimum moves or -1
Example

Input : 8 8 1 1 8 8
Output :  6

*/

import java.util.ArrayList;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.Queue;

public class KnightOnChessBoard {
	

	public static void main(String[] args)
	{
		KnightOnChessBoard o = new KnightOnChessBoard();
		
		System.out.println(o.knight(8, 8, 1, 1, 8, 8));
		
	}
	class Point{
		private int x;
		private int y;
		Point(int px, int py)
		{
			x=px;
			y=py;
		}
    }
	public boolean valid(int x, int y, int N, int M)
	{
		if(x<=0 || y<=0 || x>N || y>M) return false;
		return true;
	}
	public int knight(int N, int M, int x1, int y1, int x2, int y2) {
		if(!(valid(x1,y1,N,M)) && !(valid(x2,y2,N,M))) return -1;
		if((x1==x2) && (y1==y2)) return 0;
		Queue<Point> Q = new LinkedList<>();
		Q.add(new Point(x1,y1));
		int dp[][] = new int[N+1][M+1];
		//setting initial start position to 1 indicating that it has been visited 
		//and aslo indicates the number of jumps required for the next possible steps.
		dp[x1][y1]=1;
		int[] dx = {-2,-1,1,2,-2,-1,1,2};
		int[] dy = {-1,-2,-2,-1,1,2,2,1};
		while(!Q.isEmpty())
		{
			Point temp = Q.remove();
			for(int i=0; i<dx.length;i++)
			{
			    int px = temp.x + dx[i];
			    int py = temp.y + dy[i];
			    if(valid(px,py,N,M) && dp[px][py]==0)
			    {
			        if(px==x2 && py==y2) return dp[temp.x][temp.y];
			        Q.add(new Point(px,py));
			        dp[px][py]= dp[temp.x][temp.y]+1;
			    }
			}
		}
		return -1;
	}
}
