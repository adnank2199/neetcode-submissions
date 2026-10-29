class Solution {
    public boolean mergeTriplets(int[][] triplets, int[] target) {
        int[] filled = new int[3];
        Arrays.fill(filled,-1);
        int count = 0 ;
        for(int[] i : triplets) {
            if(i[0] > target[0] || i[1] > target[1] || i[2] > target[2])
            continue;
            if(i[0] == target[0] && filled[0]==-1)
            {count++; filled[0]=0;}
            if(i[1]==target[1] && filled[1]==-1)
            {count++; filled[1]=0;}
            if(i[2] == target[2] && filled[2]==-1) 
            {count++; filled[2]=0;}
        }

        return count == 3 ;
    }
}
