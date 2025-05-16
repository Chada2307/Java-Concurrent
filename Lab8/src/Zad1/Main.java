package Zad1;

import java.util.concurrent.Exchanger;

public class Main {
public static void main(String[] args) {
    Exchanger<String> exchanger = new Exchanger<>();


    Klient klient = new Klient(exchanger);
    Sprzedawca sprzedawca = new Sprzedawca(exchanger);

    klient.start();
    sprzedawca.start();

}}
