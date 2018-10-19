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