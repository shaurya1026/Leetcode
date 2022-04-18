class Solution {
    
    
     public boolean searchMatrix(int[][] matrix, int target) {
        int l = 0;
        int r = (matrix.length * matrix[0].length) -1;

        while (r>=l) {
            int mid = l + (r - l) / 2;
			
			// Translate midpoint into [row,col]
			// matrix[0].length is the number of columns
            int row = mid / matrix[0].length; 
            int col = mid - (row*matrix[0].length);
            if (matrix[row][col] == target) {
                return true;
            } else if (matrix[row][col] > target) {
                r = mid-1;
            } else if (matrix[row][col] < target) {
                l = mid+1;
            }
        }
        return false;
    }
}