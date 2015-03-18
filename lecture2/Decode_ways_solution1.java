/*
    recursive way
    will time out, need dp
*/
public class Solution {
    public int numDecodings(String s) {
        if(s.length()==1 &&s.equals("0"))return 0;
        if(s.length()==0)return 0;
        return numDecodingsSub(s);
    }
    public int numDecodingsSub(String s) {
        if(s.length()==0)return 1;
        if(s.length()==1)return 1;
        int firstDigit = s.charAt(0) -'0';
        int secondDegit =  s.charAt(1) -'0';
        if(secondDegit ==0) return numDecodingsSub(s.substring(2));
        if(firstDigit ==1 || (firstDigit ==2 && secondDegit<=6))
            return numDecodingsSub(s.substring(1)) + numDecodingsSub(s.substring(2));
            
        return numDecodingsSub(s.substring(1));
    }
}