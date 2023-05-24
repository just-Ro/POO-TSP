package main;

public class Triangle extends Form{
    protected int base, height;
    public Triangle(int pos_x, int pos_y, int base, int height){
        super(pos_x, pos_y);
        this.base = base;
        this.height = height;
    }

    public int[] intersection(int y){
        if(y == this.pos_y){
            // Vértice de cima
            int[] vector = new int[1];
            vector[0] = this.pos_x;
            return vector;
        } else if(y == this.pos_y+this.height-1){
            // Base do triângulo
            int[] vector = new int[this.base];
            for(int i=this.pos_x-Math.round(this.base/2);i<this.base;i++){
                vector[i] = 
            }
        }
    }
}