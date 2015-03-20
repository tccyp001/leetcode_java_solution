public class Solution {
    public void nextPermutation(int[] num) {
       if(num.length ==0)return;
	        if(num.length ==1)return;
	        int index1 = num.length -2;
	        int index2 = 0;
	        while(index1>=0 && num[index1]>=num[index1+1])index1--;
	        if(index1>=0) {
	            index2 = index1 +1;
	            while( index2<num.length && num[index1]<num[index2])index2++;
	            swap(num, index1, index2-1);
	        }
	        index1++;
	        index2 = num.length -1;
	        while(index1<index2)swap(num,index1++,index2--);

    }
    public void swap(int[]num, int i, int j) {
        int tmp = num[i];
        num[i] = num[j];
        num[j] = tmp;
    }
}