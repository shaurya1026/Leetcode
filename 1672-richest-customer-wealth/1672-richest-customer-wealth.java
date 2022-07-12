class Solution {
   public int maximumWealth(int[][] accounts) {
        
        int maxSum = 0;
		
        for(int i = 0; i < accounts.length; i++) {
		
            int j = 0;
			
            int sum = 0;
			
            while(j < accounts[0].length) {
			
                sum += accounts[i][j];
				
                j++;
				
            }
			
            maxSum = Math.max(sum, maxSum);
			
        }
        return maxSum;
		
    }
        
    }
