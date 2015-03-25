public class Solution {
    public void merge(int A[], int m, int B[], int n) {
       int targetPos = m + n - 1;
       m--;
       n--;
       while(m>=0 && n>=0) {
           if(A[m]>B[n]) A[targetPos--] = A[m--];
           else  A[targetPos--] = B[n--];
       }
       while(n>=0) A[targetPos--] = B[n--];
    }
}