package org.example;

public class Main {
    public static void main(String[] args) {
        Engenheiro e = new Engenheiro("João","99999999995",15000.00 );
        Vendedor v = new Vendedor("Welligton", "88888888889", 15, 0.5);
        Horista h = new Horista("Júlia", "88877766656", 150 ) ;

        System.out.println(e);
        System.out.println(v);
        System.out.println(h);
    }
}