// { Driver Code Starts
// Initial Template for Java

import java.io.*;
import java.util.*;

class GFG{
    public static void main(String args[])throws IOException
    {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(in.readLine());
        while(t-- > 0){
            int N = Integer.parseInt(in.readLine());
            String a[] = in.readLine().trim().split("\\s+");
            int arr[] = new int[N];
            for(int i = 0;i < N;i++)
                arr[i] = Integer.parseInt(a[i]);
            
            Solution ob = new Solution();
            List<Integer> ans = new ArrayList<Integer>();
            ans = ob.nextPermutation(N, arr);
            StringBuilder out = new StringBuilder();
            for(int i = 0;i < N;i++)
                out.append(ans.get(i) + " ");
            System.out.println(out);
        }
    }
}// } Driver Code Ends


// User function Template for Java

class Solution{
    static void swap(int[] arr,int i,int j){
        int tmp = arr[i];
        arr[i] = arr[j];
        arr[j] = tmp;
    }
    static void reverse(int[] arr,int i,int j){
        while(i<j){
            swap(arr,i++,j--);
        }
    }
    static List<Integer> nextPermutation(int N, int arr[]){
        int idx = -1;
        List<Integer> ans = new ArrayList<>();
        for(int i = N-1;i>0;i--){
            if(arr[i]>arr[i-1]){
                idx = i;
                break;
            }
        }
        if(idx==-1){
            Arrays.sort(arr);
        }else{
            int idx2 = idx;
            for(int i = idx+1;i<N;i++){
                if(arr[i]>arr[idx-1]&&arr[i]<arr[idx]){
                    idx2 = i;
                }
            }
            swap(arr,idx-1,idx2);
            reverse(arr,idx,N-1);
        }
        for(int i = 0;i<N;i++){
            ans.add(arr[i]);
        }
        return ans;
    }
}