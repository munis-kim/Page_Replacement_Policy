package datatype;

public class Result_data {
    ColorBox box;
    char head;
    char[] str;

    public Result_data(ColorBox box, char head, char[] str){
        this.box = box;
        this.head = head;
        this.str = new char[str.length];
        System.arraycopy(str, 0, this.str, 0, str.length);
    }
}
