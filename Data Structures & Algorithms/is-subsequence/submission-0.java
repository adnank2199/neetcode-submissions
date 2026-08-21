class Solution {
    public boolean isSubsequence(String s, String t) {
        char [] a = s.toCharArray();
        char [] b = t.toCharArray();
        int index=0;
        for(int i=0 ; i < a.length ; i++ ) {
            boolean found = false; 
            for (int j=index ; j < b.length ; j++) {
                if(a[i] == b[j]) 
                {
                    found = true;
                    index=j+1;
                    break;
                }
            }
            if(!found)
            return false;
        }
        return true;
    }
}