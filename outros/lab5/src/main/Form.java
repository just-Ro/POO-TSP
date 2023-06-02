package main;

public abstract class Form {
    protected int pos_x, pos_y;
    public Form(int x, int y){
        this.pos_x=x;
        this.pos_y=y;
    }

    public abstract int[] intersection(int y);
}
