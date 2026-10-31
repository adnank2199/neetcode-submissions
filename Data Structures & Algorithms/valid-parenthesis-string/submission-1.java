class Solution {
    public boolean checkValidString(String s) {
        Stack<Integer> s1 = new Stack<>();
        Stack<Integer> s2 = new Stack<>();

        for(int i =0;i<s.length();i++) {
            char curr = s.charAt(i);
            if(curr == '(') 
            s1.push(i);
            else if(curr=='*') 
            s2.push(i);
            else {
                if(s1.isEmpty()){
                    if(s2.isEmpty()) 
                    return false;
                    else 
                    s2.pop();
                }
                else 
                s1.pop();
            }
        }

        while(!s1.isEmpty() && !s2.isEmpty()) 
    {
        if(s1.peek() < s2.peek()) 
        {
            s1.pop();
            s2.pop();
        }
        else 
        return false;
    }

    return s1.isEmpty();
    }

    
}
