class Solution {
    public int countStudents(int[] students, int[] s) {
        Queue<Integer> q = new LinkedList<>();
        for(int i : students) 
        q.add(i);
        int top=0;
        int size = q.size();
        while(top<s.length && size!=0) {
            if(s[top]==q.peek())
            {
                top++;
                q.poll();
                size=q.size();
            }
            else {
                int curr = q.poll();
                q.add(curr);
                size--;
            }
        }
        return q.size();
    }
}