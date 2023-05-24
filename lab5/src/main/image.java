package main;
import java.util.ArrayList;

public class Image {
    public int height;
    public int width;

    ArrayList<Form> formas ;
    
    public Image(int h, int w){
        this.height=h;
        this.width=w;
        this.formas = new ArrayList<Form>();
    }
    //public Form formas;
    public void addForm(Form forma){
        formas.add(forma);
    }
    public void line(int y){
        //Criar vetor da linha e inicializar tudo a 0
        char[] linha = new char[this.width];
        for (int i = 0; i < linha.length; i++) {
            linha[i] = ' ';
        }
        int j;
        //int[] intercepcao = new int[this.width];
        
        for (Form form : this.formas) {
            int[] intercepcao = form.intersection(y);
            for (int i = 0; i < intercepcao.length; i++) {
                j = intercepcao[i];
                linha[j]='x';
            }
        }
    }
    public void toString(){

    }
}
