class Solution {
    public boolean isValid(String s) {
        Stack<Character> se = new Stack<>();

        for(int i =0 ;i<s.length(); i++) {
            char c = s.charAt(i);
            if(c=='{' || c=='[' || c=='(')
            se.push(c);
            else {
                if(se.size()==0)
                return false;
                char curr = se.pop();
                if(c=='}' && curr!='{')
                return false;
                if(c==']' && curr!='[')
                return false;
                if(c==')' &&  curr!='(')
                return false;
            }
        }
        return se.isEmpty();
    }
}
