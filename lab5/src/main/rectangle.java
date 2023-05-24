package main;

public class Rectangle extends Form{
    
    private int height;
    private int width;
    public Rectangle(int pos_x, int pos_y, int height, int width){
        super(pos_x, pos_y);
        this.height = height;
        this.width = width;
    }

    public int[] intersection(int y){
        
        if(y == this.pos_y || y == this.pos_y+this.height-1){
            // Aresta superior ou inferior
            int[] vector = new int[this.width];
            for(int i=this.pos_x;i<this.pos_x+this.width-1;i++){
                vector[i] = i;
            }
            return vector;
        } else if(y>this.pos_y && y<this.pos_y+this.height-1){
            // Meio do retângulo
            int[] vector = new int[2];
            vector[0] = this.pos_x;
            vector[1] = this.pos_x+this.width-1;
            return vector;
        } else {
            // Não pertence ao retângulo
            int[] vector = new int[0];
            return vector;
        }
    }
}
