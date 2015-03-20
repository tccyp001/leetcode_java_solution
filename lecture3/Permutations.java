public class Solution {
    public ArrayList<ArrayList<Integer>> permute(int[] num) {
        ArrayList<ArrayList<Integer>> ret = new  ArrayList<ArrayList<Integer>>();
        ArrayList<Integer> path = new ArrayList<Integer>();
        permuteDFS(num, 0, ret, path);
        return ret;
    }
    public void permuteDFS(int[] num, int start, ArrayList<ArrayList<Integer>> ret,
                            ArrayList<Integer> path) {
        if(start == num.length) {
            ret.add(new ArrayList<Integer>(path));
        }
        for(int i = start; i<num.length;i++) {
            swap(num, start, i);
            path.add(num[start]);
            permuteDFS(num, start+1,ret,path);
            path.remove(path.size()-1);
            swap(num, i, start);
        }
    }
    public void swap(int[] num, int i, int j) {
        int tmp = num[i];
        num[i] = num[j];
        num[j] = tmp;
    }
}