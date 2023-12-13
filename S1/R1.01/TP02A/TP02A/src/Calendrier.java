import java.util.Scanner;

public class Calendrier {
    public static void main(String[] args) {
        Scanner lecteur = new Scanner(System.in);

        System.out.print("Entrez une année (un entier positif) : ");
        int uneAnnee = lecteur.nextInt();
        
        if(uneAnnee%100 == 0){System.out.println("* Cette année marque la fin du " + uneAnnee/100 + "e siècle");}
        else{System.out.println("* Cette année n'est pas une fin de siècle");}
        if(((uneAnnee%4 == 0)&!(uneAnnee%100 == 0))|(uneAnnee%400 == 0)){System.out.println("* Elle est bissextile et comporte 366 jours");}
        else{System.out.println("* Elle est commune et comporte 365 jours");}

        lecteur.close();
    }
}
