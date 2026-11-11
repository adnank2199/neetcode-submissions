class UnionFind {
    Map<Integer,Integer> par ; 
    Map<Integer,Integer> rank ;
    int no ;
    public UnionFind(int n) {
        par = new HashMap<>();
        rank = new HashMap<>();

        for(int i=0;i<n;i++) {
            par.put(i,i);
            rank.put(i,0);
        }

        no = n;
    }

    public int find(int x) {
        if(x!=par.get(x)) 
        par.put(x,find(par.get(x)));
        return par.get(x);
    }

    public boolean isSameComponent(int x, int y) {
        int p1 = find(x);
        int p2 = find(y);
        if(p1==p2)
        return true;
        else 
        return false;
    }

    public boolean union(int x, int y) {
        if(isSameComponent(x,y)) 
        return false ;
        
        if(rank.get(find(x)) > rank.get(find(y))) 
        par.put(find(y),find(x));
        else if(rank.get(find(x)) < rank.get(find(y)))
        par.put(find(x),find(y));
        else {
            par.put(find(x),find(y));
            rank.put(find(y),rank.get(find(y))+1);
        }
        no--;
        return true;
    }

    public int getNumComponents() {
        return no;
    }
}


class Solution {
    public int minimumSpanningTree(List<List<Integer>> edges, int n) {
        PriorityQueue<int[]> heap = new PriorityQueue<>((a,b) -> a[0] - b[0]);
        for(List<Integer> i : edges) {
            heap.offer(new int[] {i.get(2) , i.get(0) , i.get(1)});
        }

        UnionFind uf = new UnionFind(n);
        int cost = 0 ;

        while(!heap.isEmpty()) {
            int[] curr = heap.poll();
            if(uf.union(curr[1],curr[2])) 
            cost+=curr[0];
        }
        return uf.getNumComponents() == 1 ? cost : -1;
    }
}























































