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
        Complex n3 = new Complex(this.a, this.b);
        n3.a += n2.a;
        n3.b += n2.b;
        return n3;
    }

    public Complex subtract(Complex n2){
        Complex n3 = new Complex(this.a, this.b);
        n3.a -= n2.a;
        n3.b -= n2.b;
        return n3;
    }

    public Complex multiply(Complex n2){
        Complex n3 = new Complex(this.a, this.b);
        n3.a *= n2.a;
        n3.b *= n2.b;
        return n3;
    }

    
}
