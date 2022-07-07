// { Driver Code Starts
//Initial Template for Java

/*package whatever //do not write package name here */

import java.io.*;
import java.util.*;
class GFG {
	public static void main (String[] args) {
		Scanner sc=new Scanner(System.in);
		
		int t=sc.nextInt();
		
		while(t-->0)
		{
		    int n=sc.nextInt();
		    int a[]=new int[n];
		    
		    for(int i=0;i<n;i++)
		    {
		        a[i]=sc.nextInt();
		    }
		    int m=sc.nextInt();
		    Solution ob = new Solution();
		    System.out.println(ob.findPages(a,n,m));
		}
	}
}// } Driver Code Ends


//User function Template for Java

class Solution 
{
   //Function to find minimum number of pages.
   
   public static int maxOf(int[]A){
       int n = A.length;
       return A[n-1];
   }
   public static int sumOf(int[] A){
       int high=0;
       for(int i =0; i<A.length ;i++){
           high += A[i];
       }
       return high;
   }
   public static int findPages(int[]A,int N,int M)
   {
       //Your code here
       int min = maxOf(A);
       int max = sumOf(A);
       
       int res =0;
       while(min <= max){
           int mid = (max+min)/2;
           
           if(isfeasible(A,M,mid)){
               res = mid;
               max = mid-1;
           }
           else{
               min = mid+1;
           }
       }
       return res;
       
   }
   
   static boolean isfeasible(int[]A, int M, int res){
       int student =1,sum =0;
       for(int i =0; i<A.length;i++){
           if(sum + A[i]>res){
               student ++;
               sum = A[i];
           }
           else{
               sum +=A[i];
           }
       }
       return student <= M;
   }
}