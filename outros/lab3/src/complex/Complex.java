package complex;

public class Complex {
    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + Float.floatToIntBits(a);
        result = prime * result + Float.floatToIntBits(b);
        return result;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj)
            return true;
        if (obj == null)
            return false;
        if (getClass() != obj.getClass())
            return false;
        Complex other = (Complex) obj;
        if (Float.floatToIntBits(a) != Float.floatToIntBits(other.a))
            return false;
        if (Float.floatToIntBits(b) != Float.floatToIntBits(other.b))
            return false;
        return true;
    }

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
