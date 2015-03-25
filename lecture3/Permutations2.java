public class Solution {
	public ArrayList<ArrayList<Integer>> permuteUnique(int[] num) {
        ArrayList<ArrayList<Integer>> ret = new ArrayList<ArrayList<Integer>>();
        if(num.length == 0)return ret;
        boolean[] used = new boolean[num.length];
        Arrays.sort(num);
        ArrayList<Integer> path = new ArrayList<Integer>();
        permuteDFS(num, path, ret, 0,used);
        return ret;
    }
    public void permuteDFS(int [] num, ArrayList<Integer> path, ArrayList<ArrayList<Integer>> ret, 
            int start, boolean[] used) {
        if(start == num.length)ret.add(new ArrayList<Integer>(path));
        int last = -1;
        for(int i = 0;i<num.length;i++) {
            if((last!=-1 && num[i] == num[last]) || used[i])continue;
            used[i] = true;
            path.add(num[i]);
            permuteDFS(num, path, ret, start+1,used);
            path.remove(path.size()-1);
            used[i] = false;
            last = i;
        }
    }
}