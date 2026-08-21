class Solution {
    public boolean isValid(String s) {
        ArrayList<Character> ans = new ArrayList<Character>();
        for(char c : s.toCharArray()) {
            if(c == '[' || c==  '{' || c== '(') 
            ans.add(c);
            else {
                if(ans.isEmpty())
                return false;
                char top = ans.get(ans.size()-1);
                if ((top == '{' && c =='}') ||
                    (top == '[' && c ==']') ||
                    (top == '(' && c ==')'))
                    ans.remove(ans.size()-1);
                else 
                return false;
            } 
        }
        return ans.isEmpty();
    }
}
