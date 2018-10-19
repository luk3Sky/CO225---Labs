class Rect{
    private int len,wid;
    
    public void setData(int len, int wid){
        this.len = len;
        this.wid = wid;
    }

    public int getArea(){
        return this.len*this.wid;
    }
}

public class TestRect{
    public static void main(String[] args) {
        Rect r = new Rect();
        r.setData(12, 60);
        System.out.print(r.getArea());
    }
}