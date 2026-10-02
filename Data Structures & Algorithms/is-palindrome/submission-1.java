class Solution {
    public boolean isPalindrome(String s) {
        int L = 0 ; 
        int R = s.length()-1;
        while(L<R) {
            char left = s.charAt(L);
            char right = s.charAt(R);
            if(!isAlphaNum(left)) {
                L++;
                continue;
            }
            if(!isAlphaNum(right)) {
                R--;
                continue;
            }
            if((Character.toLowerCase(left) == Character.toLowerCase(right))) {
                R--;
                L++;
            }
            else 
            return false;
        }
        return true;
}
        public boolean isAlphaNum(char c) {
        return (c>='A' && c<='Z') ||
        (c>='a' && c<='z') ||
        (c>='0' && c<='9');
    }
}