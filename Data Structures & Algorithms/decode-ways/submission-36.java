class Solution {
    public int numDecodings(String s) {
        if(s.charAt(0) == '0')
        return 0;
        int a=1;
        int b=1;

        for(int i = 1 ; i < s.length() ; i++) {
            int curr = 0 ;
            if(s.charAt(i) != '0')
            curr+=b;

            int num = Integer.parseInt(s.substring(i-1,i+1));
            if(num>=10 && num <=26)
            curr+=a;

            a=b;
            b=curr;
        }
        return b ; 
    }
}