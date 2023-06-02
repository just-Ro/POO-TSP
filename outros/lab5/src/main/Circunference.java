package main;

public class Circunference extends Form{
    
    private int raio;

    public Circunference(int pos_x, int pos_y, int raio){
        super(pos_x,pos_y);
        this.raio = raio;
    }

    public int[] intersection(int y){
        // pertence a circunferencia
        if(y<=this.pos_y+this.raio && y>=this.pos_y-this.raio){
            // reta f(x) = y e tangente a circunferencia
            if(y==this.pos_y+this.raio || y==this.pos_y-this.raio){
                int[] vector = new int[1];
                vector[0] = this.pos_x;
                return vector;
            } else {
                int[] vector = new int[2];
                vector[0] = (int) Math.round(Math.sqrt(raio^2-(y-pos_y)^2));
                vector[1] = -vector[0];
                return vector;
            }
        } else {
            int[] vector = new int[0];
            return vector;
        }
    }
}
