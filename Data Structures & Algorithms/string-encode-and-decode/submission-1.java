class Solution {

    public String encode(List<String> strs) {
        String e="";
        for(String s : strs) {
            e+=s.length() +"#" +s;
        }
        return e;
    }

    public List<String> decode(String str) {
        List<String> ans = new ArrayList<>();
        int i =0;
        while(i < str.length()) {
            int j=i;
            while(str.charAt(j)!='#')
            j++;
            int length = Integer.parseInt(str.substring(i,j));
            i=j+1;
            j=i+length;
            ans.add(str.substring(i,j));
            i=j;
        } 
        return ans;
    }
}
