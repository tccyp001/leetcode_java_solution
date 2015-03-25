public class Solution {
    public int findMin(int[] num) {
        if(num.length<0)return -1;
        int curMin = num[0];
        int start = 0;
        int end = num.length;
        
        while(start<end) {
            int mid = (start + end )/2;
            if(curMin>num[mid]) {
                curMin = num[mid];
            }
            if(num[start]==num[mid]) start++;
            else if(num[start]<num[mid] &&  num[mid]>num[end-1]) start = mid +1;
            else end = mid;
        }
        return curMin ;
    }
}