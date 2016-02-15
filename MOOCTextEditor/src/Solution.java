import java.io.*;
import java.util.*;
import java.text.*;
import java.math.*;
import java.util.regex.*;

import com.sun.org.apache.xalan.internal.xsltc.util.IntegerArray;
public class Solution {

public int[] layerSpliter(int[][] mat,int m,int n){

	ArrayList<Integer> temp = new ArrayList<Integer>();
    int i=0;
    for(int j=0;j<m;j++){
        temp.add(mat[j][i]);
    }

    i = 3;
    for(int j=1;j<m;j++){
        temp.add(mat[i][j]);
    }

    i = 3;
    for(int j=1;j<m;j++){
        temp.add(mat[i-j][i]);
    }

    i = 0;
    for(int j=1;j<m-1;j++){
        temp.add(mat[i][3-j]);
    }

    int[] listToArray = new int[temp.size()];
    int count = 0;
    for(Integer n1 : temp){
    	listToArray[count++] = n1.intValue();
    }

    return listToArray;
}

public int[] rotation(int[] arr){
	int[] ne  = new int[arr.length];
        for(int i=1;i<arr.length;i++){
            ne[i] = arr[i-1];

        }
        ne[0] = arr[arr.length-1];

    return ne;
}

public int[][] merge(int[] temp,int m,int n){
	Integer[] arr = new Integer[temp.length];
	for(int i=0;i<temp.length;i++){
		arr[i] = Integer.valueOf(temp[i]);
	}
	int[][] mat = new int[m][n];
	List<Integer> tp = Arrays.asList(arr);
        Stack<Integer> stack = new Stack<Integer>();
        stack.addAll(tp);

        int i = 0;
        for(int j=1;j<m-1;j++){
            mat[i][j] = stack.pop();
        }


        i = 3;
        for(int j=0;j<m;j++){
            mat[j][i] = stack.pop();
        }

        i = 3;
        for(int j=1;j<m;j++){
            mat[i][i-j] = stack.pop();
        }

        i = 0;
        for(int j=1;j<m;j++){
        	mat[3-j][i] = stack.pop();
        }

        for(int i1=0;i1<m;i1++){
            for (int j=0;j<n;j++) {
                 System.out.print(mat[i1][j]+" ");
            }
            System.out.println();
        }
       return mat;
}
        
        

    public static void main(String[] args) {
        /* Enter your code here. Read input from STDIN. Print output to STDOUT. Your class should be named Solution. */
    	Scanner s = new Scanner(System.in);
    	
		int m = s.nextInt();
		int n = s.nextInt();
		int[][] mat = new int[m][n];

		for(int i=0;i<m;i++){
			for (int j=0;j<n;j++) {
				mat[i][j] = s.nextInt();
			}
		}

		Solution sol = new Solution();
		int l = m;
		int o = n;
		//for(int i=0;i<m/2;i++){
			int[] listToarray = sol.layerSpliter(mat, l, o);
			System.out.println(Arrays.toString(listToarray));
			int[] split = sol.rotation(listToarray);
			mat = sol.merge(split, l, o);
			//l = l-2;
			//n = n-2;
					
		//}
			System.out.println(mat.length);
			 for(int i1=0;i1<m;i1++){
		            for (int j=0;j<n;j++) {
		                 System.out.print(mat[i1][j]+" ");
		            }
		            System.out.println();
		        } 
	
    }
}