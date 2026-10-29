class Solution {
    public boolean isNStraightHand(int[] hand, int groupSize) {
        if(hand.length % groupSize != 0)
        return false;

        int min = Integer.MAX_VALUE;
        int max = Integer.MIN_VALUE;

        for(int i : hand) {
            min = Math.min(min , i);
            max = Math.max(max , i);
        }

        int[] freq = new int[max-min+1];

        for(int i : hand) {
            freq[i-min]++;
        }

        int groups = hand.length/groupSize;
        int curr = 0 ;
        while(groups!=0) {
            while(freq[curr]==0)
            curr++;
            int start = curr ; 
            for(int i = 0 ; i<groupSize;i++) {
                if(start == freq.length)
                return false;
                if(freq[start] == 0)
                return false;
                freq[start]--;
                start++;
            }
            groups--;
        }

        return true;
    }
}
