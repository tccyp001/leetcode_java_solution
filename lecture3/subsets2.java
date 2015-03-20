public class Solution {
    public ArrayList<ArrayList<Integer>> subsetsWithDup(int[] num) {
        ArrayList<Integer> path = new ArrayList<Integer>();
        ArrayList<ArrayList<Integer>> ret = new ArrayList<ArrayList<Integer>>();
        Arrays.sort(num);
        subSetSub(num, 0, path, ret);
        
        return ret;
    }
    public void subSetSub(int [] num, int start, ArrayList<Integer> path, ArrayList<ArrayList<Integer>> ret)
    {
        ret.add(new ArrayList<Integer>(path));
        for(int i = start;i<num.length;i++)
        {
            if(i!=start &&num[i] == num[i-1])continue;
            path.add(num[i]);
            subSetSub(num, i+1, path, ret);
            path.remove(path.size()-1);
        }
    }
}