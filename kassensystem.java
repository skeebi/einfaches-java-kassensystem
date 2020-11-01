/*  Dieses Projekt für "Basiskompetenzen Propädeutikum Programmierung (621.915, 18S)"
    von Sebastian Griesser stellt ein einfaches Kassensystem dar. Die Artikelpreise
    können vom Kassierer eingegeben werden. Nach der Eingabe des Rabatts werden die
    Steuern ausgerechnet und ausgegeben.
    Fertiggestellt am: 11.03.2018
*/
import java.util.Scanner;
import java.lang.Math;


public class kassensystem {


    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);

        // Variablen definieren
        double total = 0.0, gutschein = 0.0; // summen
        double preis, rabatt, bargeld; // input variablen
        double nettopreis, steuersatz, steuerbetrag, endbetrag, geldrück, geldrest; // rechen variablen
        int artikelzähler = 0, gutscheinzähler = 0; // zähler
        int eincent, fünfcent, zehncent, zwanzigcent, eineuro, fünfer, zehner, zwanziger;

        // Variablen die gleich bleiben
        double STEUERMENGE = .20;
        double EINCENT = .01;
        double FÜNFCENT = .05;
        double ZEHNCENT = .1;
        double ZWANZIGCENT = .20;
        double EINEURO = 1;
        double FÜNFER = 5;
        double ZEHNER = 10;
        double ZWANZIGER = 20;

        // nach input fragen
        System.out.print("Preis der Artikel eingeben oder 0 um fortzufahren: ");
        preis = input.nextDouble();


        while (preis != 0) //wenn nicht null eingegeben
        {
            total = total + preis; // itempreis wird summiert
            artikelzähler = artikelzähler + 1;

            // Nach weiteren input fragen
            System.out.print("Nächsten Preis eingeben oder 0 um fortzufaren: ");
            preis = input.nextDouble();
        }



        if (artikelzähler != 0) // wenn es gutscheine gibt        {
            System.out.print("Gutschein- oder Rabattmenge eingeben oder 0 um fortzufahren: ");
            rabatt = input.nextDouble();


            while (rabatt != 0)
            {
                gutschein = gutschein + rabatt;
                gutscheinzähler = gutscheinzähler + 1;

                System.out.print("Gutschein- oder Rabattmenge eingeben oder 0 um fortzufahren: ");
                rabatt = input.nextDouble();
            }

            // alle Berechnungen ausgeben

            System.out.printf("Gesamtkosten: %.2f%n", total);
            System.out.printf("\n" + "Gutschein Gesamt: %.2f%n", gutschein);

            nettopreis = total - gutschein;
            System.out.printf("\n" + "Nettopreis: %.2f%n", nettopreis);

            steuersatz = STEUERMENGE * 100;
            System.out.printf("\n" + "Steuersatz: %.2f%n" , steuersatz);

            steuerbetrag = STEUERMENGE * nettopreis;
            System.out.printf("\n" + "Steuermenge: %.2f%n", steuerbetrag);

            endbetrag = steuerbetrag + nettopreis;
            System.out.printf("\n" + "GESAMT: %.2f%n", endbetrag);

            // Eingabe wieviel der Kassier Geld erhalten hat
            System.out.print("\n" + "Erhaltene Geldmenge eingeben: ");
            bargeld = input.nextDouble();

            // Ausgabe der auszugebenden Geldmenge
            geldrück = bargeld - endbetrag;
            System.out.printf("\n" + "Geldrückgabe von: %.2f%n", geldrück);

            // Berechnungen welche Scheine/Münzen zurück gegeben werden

            zwanziger = (int) Math.floor(geldrück/ZWANZIGER);
            zehner = (int) Math.floor((geldrück - zwanziger * ZWANZIGER)/ZEHNER);
            fünfer = (int) Math.floor((geldrück-zwanziger * ZWANZIGER - zehner * ZEHNER)/FÜNFER);
            eineuro = (int) Math.floor((geldrück - zwanziger * ZWANZIGER - zehner * ZEHNER - fünfer * FÜNFER));

            geldrest = geldrück - zwanziger * ZWANZIGER - zehner * ZEHNER - fünfer * FÜNFER - eineuro * EINEURO;

            geldrest = Math.round(geldrest * 100.0) /100.0;

            zwanzigcent =  (int) Math.floor(geldrest/.25);

            geldrest = geldrück - zwanziger * ZWANZIGER - zehner * ZEHNER - fünfer * FÜNFER - eineuro * EINEURO - zwanzigcent * ZWANZIGCENT;


            geldrest = Math.round(geldrest * 100.0) /100.0;

            zehncent =  (int) Math.floor(geldrest/ZEHNCENT);

            geldrest = geldrück - zwanziger * ZWANZIGER - zehner * ZEHNER - fünfer * FÜNFER - eineuro * EINEURO - zwanzigcent * ZWANZIGCENT - zehncent * ZEHNCENT;


            geldrest = Math.round(geldrest * 100.0) /100.0;

            fünfcent =  (int) Math.floor(geldrest/FÜNFCENT);
            geldrest = geldrück - zwanziger * ZWANZIGER - zehner * ZEHNER - fünfer * FÜNFER - eineuro * EINEURO - zwanzigcent * ZWANZIGCENT - zehncent * ZEHNCENT - fünfcent * FÜNFCENT;


            geldrest = Math.round(geldrest * 100.0) /100.0;

            eincent =  (int) Math.floor(geldrest/EINCENT);

            // Geldrückgabe ausgaben
            if (zwanziger > 0)
            {
                System.out.print("€20.00: " + zwanziger + "\n");
            }

            if (zehner > 0)
            {
                System.out.print("€10.00: " + zehner + "\n");
            }

            if (fünfer > 0)
            {
                System.out.print("€5.00: " + fünfer + "\n");
            }

            if (eineuro > 0)
            {
                System.out.print("€1.00: " + eineuro + "\n");
            }

            if (zwanzigcent > 0)
            {
                System.out.print("€0.20: " + zwanzigcent + "\n");
            }

            if (zehncent > 0)
            {
                System.out.print("€0.10: " + zehncent + "\n");
            }

            if (fünfcent > 0)
            {
                System.out.print("€0.05: " + fünfcent + "\n");
            }

            if (eincent > 0)
            {
                System.out.print("€0.01: " + eincent + "\n");
            }

            System.out.println("____________________________");
        }
    }