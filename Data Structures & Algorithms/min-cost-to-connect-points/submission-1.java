class Solution {
    public int minCostConnectPoints(int[][] points) {
        UnionFind uf = new UnionFind(points.length);

        PriorityQueue<int[]> heap = new PriorityQueue<>((a,b) -> a[0]-b[0]);

        for(int i =0;i<points.length;i++) {
            for(int j =0;j<points.length;j++) {
                heap.offer(new int[] {Math.abs(points[i][0]-points[j][0]) + Math.abs(points[i][1] - points[j][1]) , i , j});
            }
        }

        int tc = 0 ;

        while(!heap.isEmpty()) {
            int[] curr = heap.poll();
            if(uf.union(curr[1],curr[2])) 
            tc+=curr[0];
        }

        return uf.components() == 1 ? tc : -1;

    }
}

class UnionFind {
    Map<Integer,Integer> parent ; 
    Map<Integer,Integer> rank ;
    int no ; 

    public UnionFind(int n) {
        parent = new HashMap<>();
        rank = new HashMap<>();

        for(int i=0;i<n;i++) {
            parent.put(i,i);
            rank.put(i,0);
        }
        no = n;
    }

    public int find(int x) {
        if(x!=parent.get(x)) {
            parent.put(x,find(parent.get(x)));
        }
        return parent.get(x);
    }

    public boolean union(int x , int y) {
        int p1 = find(x);
        int p2 = find(y);

        if(p1==p2)
        return false ;

        if(rank.get(p1) > rank.get(p2)) {
            parent.put(p2,p1);
        }
        else if(rank.get(p1) < rank.get(p2)) {
            parent.put(p1,p2);
        }
        else {
            parent.put(p2,p1);
            rank.put(p1,rank.get(p1)+1);
        }
        no--;
        
        return true;

        
    }

    public int components() {
        return no;
    }
}

