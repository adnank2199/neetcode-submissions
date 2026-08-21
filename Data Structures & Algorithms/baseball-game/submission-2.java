class Solution {
    public int calPoints(String[] operations) {
        ArrayList<Integer> ans = new ArrayList<Integer> () ;
        for (String op : operations) {
            if(op.equals("+"))
            {
                int a = ans.get(ans.size()-1);
                int b = ans.get(ans.size()-2);
                ans.add(a+b);
            }
            else if(op.equals( "D"))
            ans.add(ans.get(ans.size()-1)*2);
            else if(op.equals("C")) 
            ans.remove(ans.size()-1);
            else {
                int a = Integer.parseInt(op);
                ans.add(a);
            }
        }
        int sum =0 ;
        while(ans.size()!=0) {
            sum+=ans.get(ans.size()-1);
            ans.remove(ans.size()-1);
        }
        return sum;
    }
}