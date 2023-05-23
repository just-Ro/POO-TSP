package main;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;

public class Main {
    public static void main(String[] args) throws Exception {
        System.out.println("Hello, Cristina!");

        String option = args[0];

        int n, a,n1,alfa,beta,gama,eta,p,y,v,tau;

        if (option.equals("-r")) {
            // Handle the -r option
            if (args.length < 12) {
                System.out.println("Please provide command-line arguments.");
                System.exit(0);
            }
            System.out.println("modo -r");
            n = Integer.parseInt(args[1]);
            a = Integer.parseInt(args[2]); //Maximum edge weight
            n1 = Integer.parseInt(args[3]);
            alfa = Integer.parseInt(args[4]);
            beta = Integer.parseInt(args[5]);
            gama = Integer.parseInt(args[6]);
            eta = Integer.parseInt(args[7]);
            p = Integer.parseInt(args[8]);
            y = Integer.parseInt(args[9]);
            v = Integer.parseInt(args[10]);
            tau = Integer.parseInt(args[11]);


        } else if (option.equals("-f")) {
            // Handle the -f option
            if (args.length < 2) {
                System.out.println("Please provide command-line arguments.");
                System.exit(0);
            }
            System.out.println("modo -f");
            

        } else {
            System.out.println("[Error] Unknown option: " + option);
            System.exit(0);
        }

    }
}