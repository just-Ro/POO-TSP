package main;

public class Triangle extends Form{
    protected int base, height;
    protected float m;
    public Triangle(int pos_x, int pos_y, int base, int height){
        super(pos_x, pos_y);
        this.base = base;
        this.height = height;
        this.m = 2*height/base;
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
            
            // Base é ímpar
            for(int i=0;i<this.base-this.base%2;i++){
                vector[i] = this.pos_x - (this.base-1)/2 + i;
            }
            
            return vector;
        } else if(y > this.pos_y && y < this.pos_y+this.height-1){
            // Meio do triângulo
            int[] vector = new int[2];

            return vector;
        } else {
            return new int[0];
        }
    }
}

