class Solution {
    public boolean isPalindrome(String s) {
        char [] c = s.toCharArray();
        int i=0;
        int j=c.length - 1;
        while(j>i) {
            while(j > i && !alphaNum(c[i]))
            i++;
            while(j > i && !alphaNum(c[j]))
            j--;
            if(Character.toLowerCase(c[i])!=Character.toLowerCase(c[j]))
            return false;
            i++;
            j--;
        }
        return true;
    }

    public boolean alphaNum(char c) {
        return (c>='A' && c<='Z' || 
        c>='a' && c<='z' ||
        c>='0' && c<='9');
    }
}