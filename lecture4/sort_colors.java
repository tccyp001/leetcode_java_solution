public class Solution {
    public void sortColors(int[] A) {
        int start = 0;
        int end = A.length -1;
        
        for(int i =0;i<=end;i++) {
            if(A[i]==0)swap(A,i,start++);
            else if(A[i] ==1)continue;
            else swap(A,i--,end--);
        }
    }
    public void swap(int[] A, int i, int j)
    {
        int tmp = A[i];
        A[i] = A[j];
        A[j] = tmp;
    }
}