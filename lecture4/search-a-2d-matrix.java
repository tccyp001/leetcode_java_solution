/*solution1 */
public class Solution {
    public boolean searchMatrix(int[][] matrix, int target) {
        
        if(matrix.length ==0)return false;
        
        int row = searchRow(matrix,target);
        if(row ==-2) return true;
        if(row == 0)return false;
        int start = 0;
        int end = matrix[0].length;
        int mid = 0;
        while(start<end)
        {
            mid = start + (end - start)/2;
            if(matrix[row-1][mid]==target) return true;
            
            if(matrix[row-1][mid]>target) end = mid;
            else start = mid +1;
        }
        return false;
    }
    public int searchRow(int[][] matrix, int target)
    {
        int start = 0;
        int end = matrix.length;
        int mid = 0;
        while(start<end)
        {
            mid = start + (end - start)/2;
            if(matrix[mid][0]==target) return -2;
            if(matrix[mid][0]>target)
                end = mid ;
            else
                start = mid+1;
        }
        return start;
    }
}

public class Solution {
    public boolean searchMatrix(int[][] matrix, int target) {
        if(matrix.length ==0|| matrix[0].length==0)return false;
        int rowCnt = matrix.length;
        int colCnt = matrix[0].length;
        
        int end = rowCnt * colCnt;
        int start = 0;
        int mid = 0;
        while(start<end)
        {
            mid = (start + end)/2;
            if(matrix[mid/colCnt][mid%colCnt]==target)return true;
            if(matrix[mid/colCnt][mid%colCnt]<target)
                start = mid+1;
            else end = mid;
        }
        return false;
    }
}

