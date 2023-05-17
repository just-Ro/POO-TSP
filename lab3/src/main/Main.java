package main;

import complex.Complex;

public class Main {
    public static void main(String[] args) {
        Complex n1 = new Complex(1, 1);
        Complex n2 = new Complex(1, 1);

        Complex sum = n1.add(n2);
        Complex sub = n1.sub(n2);
        Complex mul = n1.mult(n2);

        System.out.println(sum);
        System.out.println(sub);
        System.out.println(mul);

        System.out.println(n1.equals(n2));
    }
}
