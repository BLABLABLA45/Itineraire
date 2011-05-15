/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package itinerairemetro;

import Core.Carte;
import Core.Itineraire;
import Core.Station;
import Operation.Traitement;
import java.util.Scanner;

public class Main {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        int choix = - 1;
        int dep = 0;
        int arr = 0;
        int spe = 0;
        String nom_station_dep = "";
        String nom_station_arr = "";
        String nom_station_spe = "";
        Carte c = new Carte();
        Station s_dep;
        Station s_arr;
        Station s_spe;
        Itineraire it = new Itineraire();
        System.out.println("-----------");
        System.out.println(" TRANSLOR");
        System.out.println("------------------------------");
        System.out.println(" >>> Improve your moves ! >>>");
        System.out.println("------------------------------");

        while (choix != 0) {
            System.out.println(" Que voulez vous faire : ");
            System.out.println(" (2) Definir itineraire en passant par une station précise");
            System.out.println(" (1) Definir itineraire avec calcul optimisé en temps");
            System.out.println(" (0) Quitter");
            System.out.print("Votre choix : ");
            Scanner scanint = new Scanner(System.in);
            choix = scanint.nextInt();

            switch (choix) {
                case 0:
                    choix = 0;
                    break;
                case 2:
                    System.out.println("-----------------------");
                    System.out.println(" Affichage des stations");
                    System.out.println("-----------------------");

                    for (int i = 0; i < c.getEnsStation().size(); i++) {
                        System.out.println("Station " + (i + 1) + " : Nom : " + c.getEnsStation().get(i).getNom());
                    }
                    System.out.println("-------------------------------------------------------");
                    System.out.print("Sélectionner le nom de la station où vous vous trouvez : ");
                    Scanner scan2 = new Scanner(System.in);
                    nom_station_dep = scan2.next();
                    System.out.println("-------------------------------------------------------");
                    s_dep = Traitement.rechercheNom(nom_station_dep);

                    System.out.print("Sélectionner le nom de la station où vous souhaitez vous rendre : ");
                    nom_station_arr = scan2.next();
                    System.out.println("-------------------------------------------------------");
                    s_arr = Traitement.rechercheNom(nom_station_arr);

                    System.out.print("Sélectionner le nom de la station par laquelle vous voulez passer : ");
                    nom_station_spe= scan2.next();
                    System.out.println("-------------------------------------------------------");
                    s_spe = Traitement.rechercheNom(nom_station_spe);

                    if (!nom_station_dep.equals(nom_station_arr)) {
                        it = Traitement.rechercheItineraireSpecifique(s_dep, s_arr, s_spe);
                        System.out.println("--------------------");
                        System.out.println("Votre itineraire : ");
                        System.out.println("--------------------");
                        it.parcourtFinal();
                    }
                    break;
                case 1:
                    System.out.println("-----------------------");
                    System.out.println(" Affichage des stations");
                    System.out.println("-----------------------");

                    for (int i = 0; i < c.getEnsStation().size(); i++) {
                        System.out.println("Station " + (i + 1) + " : Nom : " + c.getEnsStation().get(i).getNom());
                    }
                    System.out.println("-------------------------------------------------------");
                    System.out.print("Sélectionner le nom de la station où vous vous trouvez : ");
                    Scanner scan3 = new Scanner(System.in);
                    nom_station_dep = scan3.next();
                    System.out.println("-------------------------------------------------------");
                    s_dep = Traitement.rechercheNom(nom_station_dep);

                    System.out.print("Sélectionner le nom de la station où vous souhaitez vous rendre : ");
                    nom_station_arr = scan3.next();
                    System.out.println("-------------------------------------------------------");
                    s_arr = Traitement.rechercheNom(nom_station_arr);

                    if (!nom_station_dep.equals(nom_station_arr)) {
                        it = Traitement.rechercheItinerairePlusRapide(s_dep, s_arr);
                        System.out.println("--------------------");
                        System.out.println("Votre itineraire : ");
                        System.out.println("--------------------");
                        it.parcourtFinal();
                    }
                    break;
                default:
                    System.out.println("Erreur !!!");
            }
        }
    }
}
