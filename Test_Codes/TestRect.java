class Rect{
    private int len,wid;
    
    Rect(int x){
        this.len = x;
    }
    public void setData(int len, int wid){
        this.len = len;
        this.wid = wid;
    }

    public int getArea(){
        return this.len*this.wid;
    }

    public int getLen(){
        return len;
    }

    public int getWid(){
        return wid;
    }
}

public class TestRect{
    public static void main(String[] args) {
        Rect r = new Rect(12);
        r.setData(12, 60);
        Rect s = new Rect(10);
        System.out.println(s.getLen());
        System.out.println(s.getWid());
        System.out.println(r.getArea());
    }
}