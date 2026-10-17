class Solution {

    class UnionFind {
        Map<Integer,Integer> par ; 
        Map<Integer,Integer> rank ;

        public UnionFind(int size) {
            par = new HashMap<>();
            rank = new HashMap<>();

            for(int i =0 ;i<size;i++) {
                par.put(i,i);
                rank.put(i,0);
            }
        }

        public int find(int x) {
            if(x!=par.get(x)) 
            return find(par.get(x));
            return x;
        }

        public void union(int x ,int y) {
            int p1 = find(x);
            int p2 = find(y);

            if(p1==p2) 
            return;

            if(rank.get(p1) > rank.get(p2)) {
                par.put(p2,p1);
            }
            else if(rank.get(p1) < rank.get(p2)) {
                par.put(p1,p2);
            }
            else {
                par.put(p2,p1);
                rank.put(p1,rank.get(p1)+1);
            }
        }
    }

    public List<List<String>> accountsMerge(List<List<String>> accounts) {
        
        Map<String,Integer> h = new HashMap<>();

        UnionFind uf = new UnionFind(accounts.size());

        for(int i=0;i<accounts.size();i++) {
            for(int j=1;j<accounts.get(i).size();j++) {
                if(h.containsKey(accounts.get(i).get(j))) 
                uf.union(h.get(accounts.get(i).get(j)) , i);
                else
                h.put(accounts.get(i).get(j) , i);
            }
        }

        Map<Integer,Set<String>> a = new HashMap<>();

        for(int i=0;i<accounts.size();i++) {
            int p = uf.find(i);
            if(!a.containsKey(p)) {
                a.put(p , new HashSet<>());
            }
            for(int j = 1; j<accounts.get(i).size() ; j++) {
                a.get(p).add(accounts.get(i).get(j));
            }
        }
        
        List<List<String>> ans = new ArrayList<>() ;

        for(Map.Entry<Integer,Set<String>> e : a.entrySet()) {
            List<String> curr = new ArrayList<>(e.getValue());
            curr.add(0,accounts.get(e.getKey()).get(0));
            ans.add(curr);
        }

        return ans;
    }
}