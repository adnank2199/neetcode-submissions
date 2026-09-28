class Solution {
    public int evalRPN(String[] token) {
        Stack<String> s = new Stack<>();
        for(int i =0 ;i < token.length; i++) {
            if(token[i].equals("+")) {
                int a =Integer.parseInt(s.pop());
                int b = Integer.parseInt(s.pop());
                s.push(String.valueOf(a+b));
                continue;
            }
            if(token[i].equals("-")) {
                int a =Integer.parseInt(s.pop());
                int b = Integer.parseInt(s.pop());
                s.push(String.valueOf(b-a));
                continue;
            }
            if(token[i].equals("*")) {
                int a =Integer.parseInt(s.pop());
                int b = Integer.parseInt(s.pop());
                s.push(String.valueOf(a*b));
                continue;
            }
            if(token[i].equals("/")) {
                int a =Integer.parseInt(s.pop());
                int b = Integer.parseInt(s.pop());
                s.push(String.valueOf((b/a)));
                continue;
            }
            s.push(token[i]);
        }
        return Integer.parseInt(s.peek());
    }
}