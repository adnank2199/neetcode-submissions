class Solution {
    public boolean isNStraightHand(int[] hand, int groupSize) {
        if(hand.length % groupSize != 0)
        return false;
        Map<Integer,Integer> h = new HashMap<>();

        Arrays.sort(hand);

        for(int i : hand) {
            h.put(i,h.getOrDefault(i,0)+1);

        }

        int index = 0 ;

        int groups = hand.length / groupSize;
        while(groups!=0) {

            while(h.get(hand[index]) == 0)
            index++;

            int start = hand[index] ; 

            for(int i =0 ;i<groupSize;i++) {
                if(h.getOrDefault(start,0) == 0)
                return false ;
                start++ ;
                h.put(start-1,h.get(start-1)-1);
            }

            index++;
            groups--;
        }
        return true;
    }
}
