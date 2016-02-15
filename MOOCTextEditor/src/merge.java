import java.io.*;
import java.util.*;
import java.text.*;
import java.math.*;
import java.util.regex.*;

public class merge {

    public static void main(String[] args) {
        /* Enter your code here. Read input from STDIN. Print output to STDOUT. Your class should be named Solution. */
    	Scanner s = new Scanner(System.in);
        Integer[] arr = {28, 22, 16, 10, 4, 3, 2, 1, 7, 13, 19, 25, 26, 27};
        int m = s.nextInt();
        int n = s.nextInt();
        int[][] mat = new int[m][n];

        for(int i=0;i<m;i++){
            for (int j=0;j<n;j++) {
                mat[i][j] = s.nextInt();
            }
        }
        List<Integer> temp = Arrays.asList(arr);
        Stack<Integer> stack = new Stack<Integer>();
        stack.addAll(temp);

        int i = 1;
        for(int j=2;j<(m-2)-1;j++){
        	System.out.println(mat[i][j]);
            mat[i][j] = stack.pop();
        }


        i = 2;
        for(int j=1;j<m-2;j++){
        	System.out.println(mat[i][j]);
            mat[j][i] = stack.pop();
        }

        i = 2;
        for(int j=1;j<m-2;j++){
        	System.out.println(mat[i][j]);
            mat[i][i-j] = stack.pop();
        }

        i = 1;
        for(int j=1;j<m-2;j++){
        	System.out.println(mat[i][j]);
        	mat[2-j][i] = stack.pop();
        }

        for(int i1=0;i1<m;i1++){
            for (int j=0;j<n;j++) {
                 System.out.print(mat[i1][j]+" ");
            }
            System.out.println();
        }
        
    }   
}