public class Solution {
    public ArrayList<String> letterCombinations(String digits) {
        
        if(digits.length()==0)return new ArrayList<String>();
        ArrayList<String> charList = new ArrayList<String>(
            Arrays.asList("","", "abc", "def", "ghi","jkl","mno","pqrs","tuv","wxyz"));
        ArrayList<String> ret = new ArrayList<String>();
        StringBuilder path = new StringBuilder();
        letterComSub(digits,charList,path,ret);
        return ret;
        
    }
    public void letterComSub(String digits, ArrayList<String> charList, 
                            StringBuilder path, ArrayList<String> ret) {
        if(digits.length() ==0) {
            ret.add(path.toString());
            return;
        }
        int index = digits.charAt(0) - '0';
        String str = charList.get(index);
        
        for(char c : str.toCharArray()) {
            path.append(c);
            letterComSub(digits.substring(1),charList,path,ret);
            path.deleteCharAt(path.length() -1);
        }
    }
}