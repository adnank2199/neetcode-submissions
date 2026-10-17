class SegmentTree {
    int L ;
    int R ;
    SegmentTree left ;
    SegmentTree right ;

    public SegmentTree() {
        this.L = -1 ;
        this.R = -1 ;
        this.left = null ; 
        this.right = null ;
    }

    public boolean checkBooking(int L , int R) {
        if(this.L == -1 && this.R == -1) {
            this.L = L ;
            this.R = R ;
            return true;
        }
        if(this.L >= R) {
            if(this.left == null)
            this.left = new SegmentTree();
            return this.left.checkBooking(L,R);
        }
        else if(this.R <= L) {
            if(this.right == null) 
            this.right = new SegmentTree();
            return this.right.checkBooking(L,R);
        }
        else {
            return false;
        }
    }
}

class MyCalendar {
    SegmentTree bookings ;
    public MyCalendar() {
        this.bookings = new SegmentTree();
    }
    
    public boolean book(int startTime, int endTime) {
        return this.bookings.checkBooking(startTime,endTime);
    }
}

/**
 * Your MyCalendar object will be instantiated and called as such:
 * MyCalendar obj = new MyCalendar();
 * boolean param_1 = obj.book(startTime,endTime);
 */