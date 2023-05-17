package complex;

public class Complex {
    @Override
    public String toString() {
        return a + "+" + b + "i";
    }

    final private float a;
    final private float b;

    public Complex(){
        this.a = 0;
        this.b = 0;
    }

    public Complex(float real, float imag){
        this.a = real;
        this.b = imag;
    }

    public Complex add(Complex n2){
        float real = this.a + n2.a;
        float imag = this.b + n2.b;
        Complex n3 = new Complex(real, imag);
        return n3;
    }

    public Complex sub(Complex n2){
        float real = this.a - n2.a;
        float imag = this.b - n2.b;
        Complex n3 = new Complex(real, imag);
        return n3;
    }

    public Complex mult(Complex n2){
        float real = this.a * n2.a - this.b * n2.b;
        float imag = this.b * n2.a + this.a * n2.b;
        Complex n3 = new Complex(real, imag);
        return n3;
    }

    
}
