package main;

public class Main {
    public static void main(String[] args){
        Image image = new Image(20, 20);
        Form q1 = new Rectangle(1, 1, 5, 5);
        image.addForm(q1);
        System.out.print(image);
    }
}
