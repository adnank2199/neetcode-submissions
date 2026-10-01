class Solution {
    Set<String> s;
    public int[][] floodFill(int[][] image, int sr, int sc, int color) {
        s=new HashSet<>();
        return helper(image , sr , sc , image[sr][sc] , color);
    }

    public int[][] helper(int[][] image , int i , int j , int source , int color) {
        int ROWS = image.length;
        int COLS = image[0].length;

        if(Math.min(i,j) < 0 || i==ROWS || j==COLS || s.contains(Arrays.toString(new int[]{i,j})) || image[i][j] != source) {
            return image;
        }
        if(image[i][j] == source) 
        image[i][j] = color;

        s.add(Arrays.toString(new int[]{i,j}));

        helper(image , i+1 , j , source , color);
        helper(image , i-1 , j , source , color);
        helper(image , i , j+1 , source , color);
        helper(image , i , j-1 , source , color);


        return image ;
    }
}