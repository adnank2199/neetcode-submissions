class Solution {
    public int evalRPN(String[] tokens) {
        Stack<Integer> st = new Stack<>();
        for(String s: tokens ) {
            if(s.equals("+")) {
                int a = st.pop();
                int b = st.pop();
                st.push(a+b);
                continue;
            }
            else if(s.equals("-")) {
                int a = st.pop();
                int b = st.pop();
                st.push(b-a);        
                continue;        
            }
            else if(s.equals("*")) {
                int a = st.pop();
                int b = st.pop();
                st.push(b*a);          
                continue; 
            }
            else if(s.equals("/")) {
                int a = st.pop();
                int b = st.pop();
                st.push(b/a);      
                continue;     
            }
            else {
                int a = Integer.parseInt(s);
                st.push(a);
                continue;
            }
        }
        return st.pop();
    }
}
