public class Solution {
    public String countAndSay(int n) {
        
        if(n==0)return "";
        String retStr = "1";
        if(n==1)return retStr;
        int[] num = new int[10];
        for(int i = 0;i<n-1;i++)
        {
            retStr = countStr(retStr);
        }
        return retStr;
    }
    public String countStr(String str)
    {
        StringBuilder sb = new StringBuilder();
        int cnt =0 ;
        for(int i = 0;i<str.length();i++)
        {
             if(i==0 || str.charAt(i) == str.charAt(i-1)) 
             {
                 cnt++;
             }
             else
             {
                sb.append(cnt);
                sb.append(str.charAt(i-1));
                cnt =1;
             }
        }
        sb.append(cnt);
        sb.append(str.charAt(str.length()-1));
      
        return sb.toString();
    }
}