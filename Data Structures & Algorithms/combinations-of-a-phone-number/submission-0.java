class Solution {
    public List<String> letterCombinations(String digits) {
        if(digits.length()==0)
        return new ArrayList<>();
        HashMap<Integer , String> h = new HashMap<>();
        h.put(2,"abc");
        h.put(3,"def");
        h.put(4,"ghi");
        h.put(5,"jkl");
        h.put(6,"mno");
        h.put(7,"pqrs");
        h.put(8,"tuv");
        h.put(9,"wxyz");
        List<String> ans = new ArrayList<>();
        String[] strings = new String[digits.length()];
        for(int i = 0 ; i < digits.length() ;i++) {
            strings[i] = h.get(Character.getNumericValue(digits.charAt(i)));
        }
        StringBuilder curr = new StringBuilder();
        helper(0 , strings , ans , curr);
        return ans;
    }

    public void helper(int i , String[] strings , List<String> ans , StringBuilder curr) {
        if(i == strings.length) {
            ans.add(curr.toString());
            return;
        }

        for(int j = 0 ; j<strings[i].length() ; j++){
            curr.append(String.valueOf(strings[i].charAt(j)));
            helper(i+1,strings,ans,curr);
            curr.deleteCharAt(curr.length()-1);
        }
    }
}
