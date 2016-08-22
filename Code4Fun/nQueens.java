package prep;

import java.util.ArrayList;

public class nQueens {
	
	public static void main(String[] args)
	{
		nQueens o = new nQueens();
		o.solveNQueens(4);
	}
	
	public ArrayList<ArrayList<String>> solveNQueens(int a) {
	    ArrayList<ArrayList<String>> res = new ArrayList<ArrayList<String>>();
	    ArrayList<String> temp = new ArrayList<String>();
	    if(a==0) return res;
	    getSol(a,res,temp,0);
	    return res;
	}
	private void getSol(int a,ArrayList<ArrayList<String>> res,ArrayList<String> temp,int row)
	{
	    if(row==a)
	    {
	        ArrayList<String> t = new ArrayList<String>(temp);
	        if(!res.contains(t)) res.add(t);
	        return;
	    }
	    for(int j = 0; j<a;j++)
	    {
	        if(isPossible(row,j,temp))
	        {
	            int k = 0;
	            StringBuilder str = new StringBuilder();
	            while(k<a)
	            {
	                str.append(".");
	                k++;
	            }
	            str.setCharAt(j,'Q');
	            temp.add(str.toString());
	            getSol(a,res,temp,row+1);
	        }
	    }
	}
	
	private boolean isPossible(int row, int col, ArrayList<String> temp)
	{
	    for (int i=0; i<row; i++){
            int qCol=temp.get(i).indexOf("Q");
            if (qCol==col){
                return false;
            }
            
            int rowDistance=Math.abs(row-i);
            int colDistance=Math.abs(col-qCol);
            
            if (rowDistance==colDistance){
                return false;
            }
            
        }
        
        return true;
        
    }

}
