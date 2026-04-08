class Solution {
    public String longestCommonPrefix(String[] strs) {
        if(strs == null || strs.length == 0)
            return "";
        String s = strs[0];
        int n = strs.length;
        for(int i =1; i<n;i++){
            while(strs[i].indexOf(s)!=0)
                s=s.substring(0,s.length()-1);
            if(s.equals(""))
                return "";
        }
        return s;
    }
}