package datatype;

public class ColorBox {
    int index;
    String color;

    public ColorBox(){}

    public void set(int index, String color){
        this.index = index;
        this.color = color;
    }
    public int getIndex(){ return index; }

    public String getColor(){ return color; }
}
