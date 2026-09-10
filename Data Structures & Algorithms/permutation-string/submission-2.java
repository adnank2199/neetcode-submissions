class Solution {
    public boolean checkInclusion(String s1, String s2) {
        HashMap<Character , Integer> S1 = new HashMap<>();
        HashMap<Character , Integer> S2 = new HashMap<>();

        char[] c1 = s1.toCharArray();
        char[] c2 = s2.toCharArray();

        for(char c : c1) {
            S1.put(c , S1.getOrDefault(c,0)+1);
        }

        int R=0 , L=0; 
        if(c2.length < c1.length) 
        return false;

        while(R!=c2.length) {
            if(R-L+1 <= c1.length)
            {
                S2.put(c2[R] , S2.getOrDefault(c2[R],0)+1 );
                R++;
            }
            else {
                if(S1.equals(S2)){
                    return true;
                }
                else {
                    if(S2.get(c2[L])>1) {
                        S2.put(c2[L] , S2.get(c2[L])-1);
                    }
                    else {
                        S2.remove(c2[L]);
                    }
                    L++;
                    S2.put(c2[R] , S2.getOrDefault(c2[R],0)+1 );
                    R++;
                }
            }
        }
        return S1.equals(S2);
    }
}
