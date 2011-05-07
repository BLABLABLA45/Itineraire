/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package Operation;

import Core.*;
import java.util.Iterator;
import java.util.LinkedList;

/**
 *
 * @author Geoffrey
 */
public class Traitement {
    private static Carte carte = new Carte();

    /*
     * RechercheCoord permet de retourner la station la plus proche
     * de l'endroit donner en param�tre (sous forme de coordonn�es)
     */
    public static Station rechercheCoord(int x, int y){
        for(Ligne l : carte.getEnsLignes()){
            for(Troncon t : l.getListTron()){
                System.out.println(x + " " + y + " test : " +t.getA().getCoorX() + " " + t.getA().getCoorY());
                if(t.getA().getCoorX() == x && t.getA().getCoorY() == y) return t.getA();
                System.out.println(x + " " + y + " test : " +t.getB().getCoorX() + " " + t.getB().getCoorY());
                if(t.getB().getCoorX() == x && t.getB().getCoorY() == y) return t.getB();
            }
        }
        return null;
    }

    /*
     * Recherche dans la carte la station correspondante au nom
     *
     */
    public static Station rechercheNom(String n){
        for(Ligne l : carte.getEnsLignes()){
            for(Troncon t : l.getListTron()){
                System.out.println(n + " test : " +t.getA().getNom());
                if(t.getA().getNom().equals(n)) return t.getA();
                System.out.println(n + " test : " +t.getB().getNom());
                if(t.getB().getNom().equals(n)) return t.getB();
            }
        }
        return null;
    }

    /*
     * Recherche dans la carte le troncon correspondant � ligne et contenant la station id
     *
     */
    public static Troncon rechercheTroncon(String ligne,int id){
        for(Ligne l : carte.getEnsLignes()){
            if(l.getNom().equals(ligne)){
                for(Troncon t : l.getListTron()){
                    if(t.getA().getNum() == id) return t;
                    if(t.getB().getNum() == id) return t;
                }
            }
        }
        return null;
    }
    
    /*
     *Recherche la station correspondante � l'id mis en param�tre et change son statut
     */
    public static void majStation(int id, String st){
        carte.getEnsStation().get(id).setStatut(st);
    }

    /*
     *Recherche le tron�on correspondant � l'id mis en param�tre et change son statut
     */
    public static void majTroncon(int id, String st){
        carte.getEnsTroncon().get(id).setStatut(st);
    }


    public static Boolean incidentLigne(Ligne l){
        //System.out.println("Traitement de la ligne : " + l.getNum());
        for(Troncon t : l.getListTron()){
            //System.out.println("Traitement du tron�on: " + t.getNum());
            if(!t.getStatut().equals("normal") 
                    || !t.getA().getStatut().equals("normal")
                    || !t.getB().getStatut().equals("normal"))return true;
        }
        return false;
    }

    /*
     * Recherche et retourne la ligne commune entre 2 stations
     *
     */
    public static Ligne ligneCommune(Station s1, Station s2){
        //System.out.println("entre " + s1.getNom() + " et " + s2.getNom());
        for(Ligne l : s1.getListLigne()){
            for(Ligne p : s2.getListLigne()){
                //System.out.println("S1 : " + l.getNum() + " ,S2 : " + p.getNum());
                if(l.getNum() == p.getNum() && !incidentLigne(l)){
                    //System.out.println("Correspondance trouv�e : " + l.getNom());
                    return l;
                }
            }
        }
        return null;
    }

    /*
     * Recherche parmit la premi�re ligne de la station s1, si il y a une station qui poss�de une ligne en commune avec s2
     *
     */
    public static Station changementLigne(Station s1, Station s2){
        for(Troncon t : s1.getListLigne().get(0).getListTron()){
            if(ligneCommune(t.getA(),s2) != null) return t.getA();
            if(ligneCommune(t.getB(),s2) != null) return t.getB();
        }
        return null;
    }

    /*
     *Recherche du sens du parcourt pour la station dep en fonction de la station arr
     *
     */

    public static int sensParcourt(Station dep,Station arr){
        int p = 0;
        Boolean A = false;
        Boolean B = false;
        Ligne l = ligneCommune(dep,arr);
        Station chang = null;
        if(l == null){
            l=dep.getListLigne().get(0);
            chang = changementLigne(dep,arr);
        }
        Boolean depA = false;
        Boolean arrA = false;
        for(Troncon t : l.getListTron()){
            if(t.getA() == dep){
                A= true;
                if(!arrA && t.getB() != arr)depA = true;
            }
            if(t.getB() == dep){
                B= true;
                if(!arrA && t.getA() != arr)depA = true;
            }
            if(t.getA() == arr ||t.getB() == arr ||t.getA() == chang ||t.getB() == chang){ /*Permet de savoir si la station de d�part se trouve avant ou apr�s la station d'arriv�e */
                if(!depA)arrA = true;
            }
        }
        if(A&&!B){
            p = 1;
        }
        if(A&&B){
             if(depA)p = 1;
             else p = 2;
        }
        if(!A&&B){
            p = 2;
        }
        return p;
    }

    public static Itineraire rechercheItineraire(Station dep, Station arr){
        Itineraire I = new Itineraire();

        Ligne lcom = ligneCommune(dep,arr);
        Station chang = null;
        if(lcom == null){
            lcom=dep.getListLigne().get(0);
            chang = changementLigne(dep,arr);
        }
        int sens = sensParcourt(dep,arr);
        int sensar = 0;
        if(chang != null)sensar = sensParcourt(chang,arr);
        else sensar = sens;
        //System.out.println("SENS DU PARCOURT AU DEPART: " + sens);
        //System.out.println("SENS DU PARCOURT A L'ARRIVEE: " + sensar);

        I.add(dep);
        I.addChangement(dep.getNom(), lcom.getNom());
        Iterator<Troncon> It = null;
        if(sens == 1) It = lcom.getListTron().iterator();
        else It = lcom.getListTron().descendingIterator();
        Boolean ok = false;
        Boolean fin = false;
        Boolean change = false;
        Troncon suiv = null;

        while(It.hasNext()){
            suiv = It.next();
            if(!ok && dep == suiv.getA() && sens == 1) ok = true;
            if(!ok && dep == suiv.getB() && sens == 2) ok = true;
            if(chang  == null){
                if(ok){
                    //System.out.println("Sans Chang => A : " + suiv.getA().getNom() + " ,B :" + suiv.getB().getNom());
                    if(sens == 1){
                        I.add(suiv.getB());
                        I.addChangement(suiv.getB().getNom(), lcom.getNom());
                        if(suiv.getB() == arr)break;
                    }
                    else{
                        I.add(suiv.getA());
                        I.addChangement(suiv.getA().getNom(), lcom.getNom());
                        if(suiv.getA() == arr)break;
                    }

                }
            }
            if(chang != null && (suiv.getA() == chang || suiv.getB() == chang)){
                if(ok){
                    //System.out.println("Avec Chang : "+ chang.getNom() +" => A : " + suiv.getA().getNom() + " ,B :" + suiv.getB().getNom());
                    if(sens == 1){
                        I.add(suiv.getB());
                        I.addChangement(suiv.getB().getNom(), lcom.getNom());
                        if(!change && chang == suiv.getB()){
                            //System.out.println("ON CHANGE DE LIGNE");
                            lcom = ligneCommune(chang,arr);
                            It= lcom.getListTron().iterator();
                            change = true;
                            chang = null;
                            sens = sensar;
                            //ok = false;
                        }
                    }else{
                        I.add(suiv.getA());
                        I.addChangement(suiv.getA().getNom(), lcom.getNom());
                        if(!change && chang == suiv.getA()){
                            //System.out.println("ON CHANGE DE LIGNE");
                            lcom = ligneCommune(chang,arr);
                            It= lcom.getListTron().descendingIterator();
                            change = true;
                            chang = null;
                            sens = sensar;
                            //ok = false;
                        }
                    }

                }

            }
            if(!ok && dep == suiv.getB()) ok = true;
            if(!ok && dep == suiv.getA()) ok = true;
        }


        //System.out.println("DERNIERE STATION VISITE : " + suiv.getB().getNom());


        return I;
    }

}
