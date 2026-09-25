class Solution {

    public String encode(List<String> strs) {
        String encode="";
        for(String s : strs) {
            encode = encode + s.length() + "~" + s; 
        }
        return encode;
    }

    public List<String> decode(String str) {
        List<String> ans = new ArrayList<>();
        int i =0 ;
        while(i<str.length()) {
            int j = i ;
            while(str.charAt(j)!='~') {
                j++;
            }
            int length = Integer.parseInt(str.substring(i,j));
            int start = j +1;
            ans.add(str.substring(start,start+length));
            i=start+length;
        }
        return ans;
    }
}
