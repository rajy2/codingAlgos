/*
Print concentric rectangular pattern in a 2d matrix. 
*/

import java.util.ArrayList;

public class rec {
	public static void main(String args[])
	{
		rec obj = new rec();
		obj.prettyPrint(3);
	}
	
		public ArrayList<ArrayList<Integer>> prettyPrint(int a) {
		    int[][] prettyPrint = new int[(2*a-1)][(2*a-1)];
		    int topRow =0, leftCol=0, bottomRow=prettyPrint.length - 1, rightCol=prettyPrint[0].length-1;
		    //System.out.println("hello");
		    setRowAndColToi(prettyPrint,topRow, bottomRow, leftCol, rightCol,a);
		    /*for(int i = a; i>0; i--)
		    {
		        setRowAndColToi(prettyPrint,topRow, bottomRow, leftCol, rightCol,i);
		        topRow++;
		        bottomRow--;
		        leftCol++;
		        rightCol--;
		    }*/
		    
		    ArrayList<ArrayList<Integer>> toRet = new ArrayList<ArrayList<Integer>>();
		    ArrayList<Integer> temp;
		    for(int i = 0; i<prettyPrint.length;i++)
		    {
		        temp = new ArrayList<Integer>();
		        for(int j = 0; j<prettyPrint[0].length;j++)
		        {
		            temp.add(prettyPrint[i][j]);
		        }
		        toRet.add(temp);
		    }
		    return toRet;
		}
		
		private void setRowAndColToi(int[][] mat, int tRow, int bRow, int lCol, int rCol,int val)
		{
		    for(int i = 0; i< mat.length; i++)
		    {
		        for(int j=0;j<mat[0].length; j++)
		        {
		            System.out.print(mat[i][j] + " ");
		        }
		        System.out.println();
		    }
		    System.out.println("Next result");
		    //int size = mat.length-1;
		    if(val <= 0) return;
		    for(int i = lCol; i<=rCol;i++)
		    {
		        mat[tRow][i] = val;
		        mat[bRow][i] = val;
		    }
		    for(int i = tRow; i<=bRow; i++)
		    {
		        mat[i][lCol] = val;
		        mat[i][rCol] = val;
		    }

	        
		    
		    setRowAndColToi(mat,tRow++, bRow--, lCol++, rCol--,val--);
		}
	}


