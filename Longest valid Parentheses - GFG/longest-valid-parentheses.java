// { Driver Code Starts
//Initial Template for Java

import java.io.*;
import java.util.*;

class GFG{
    public static void main(String args[])throws IOException
    {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(in.readLine());
        while(t-- > 0){
            String S = in.readLine();
            
            Solution ob = new Solution();
            System.out.println(ob.maxLength(S));
        }
    }
}// } Driver Code Ends


//User function Template for Java

class Solution{
    static int maxLength(String s){
       int l = 0;
       int r = 0;
       int ans =0;
       for(int i=0;i<s.length();i++){
           if(s.charAt(i) == '(')
               l++;
           else
               r++;
           if(l == r)
               ans = Math.max(ans , l*2);
           else if(r > l){
               l =0;
               r =0;
           }
           
       }
       l=0;
       r=0;
       for(int i = s.length() -1;i >= 0;i--){
           if(s.charAt(i) == '(')
               l++;
           else
               r++;
           if( l == r)
               ans = Math.max(ans,l * 2);
           else if(l > r){
               l=0;
               r=0;
           }

       }
       return ans;
   }

}