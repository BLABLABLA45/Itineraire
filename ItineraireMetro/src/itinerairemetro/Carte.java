/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package itinerairemetro;
import Core.*;
import java.util.ArrayList;
import java.util.LinkedList;


/**
 *
 * @author Geoffrey
 */
public class Carte {
    private ArrayList<Ligne> EnsLignes;

    public Carte(){
        EnsLignes = new ArrayList<Ligne>();
        initialisation();
    }

    private void initialisation(){
        Station un = new Station(1,"un",12,0);
        Station deux = new Station(2,"deux",18,2);
        Station trois = new Station(3,"trois",12,3);
        Station quatre = new Station(4,"quatre",0,8);
        Station cinq = new Station(5,"cinq",6,8);
        Station six = new Station(6,"six",12,8);
        Station sept = new Station(7,"sept",18,8);
        Station huit = new Station(8,"huit",0,12);
        Station neuf = new Station(9,"neuf",12,12);

        Troncon untrois = new Troncon(1,7,un,trois,"normal");
        Troncon troisix = new Troncon(2,2,trois,six,"normal");
        Troncon sixneuf = new Troncon(3,1,six,neuf,"normal");
        Troncon quatrecinq = new Troncon(4,2,quatre,cinq,"normal");
        Troncon cinqsix = new Troncon(5,3,cinq,six,"normal");
        Troncon sixsept = new Troncon(6,5,six,sept,"normal");
        Troncon cinqneuf = new Troncon(7,2,cinq,neuf,"normal");
        Troncon neufsept = new Troncon(8,4,neuf,sept,"normal");
        Troncon septdeux = new Troncon(9,3,sept,deux,"normal");
        Troncon huitcinq = new Troncon(10,1,huit,cinq,"normal");
        Troncon cinqtrois = new Troncon(11,4,cinq,trois,"normal");
        Troncon troisdeux = new Troncon(12,6,trois,deux,"normal");

        LinkedList<Troncon> l1 = new LinkedList<Troncon>();
        l1.add(quatrecinq);
        l1.add(cinqsix);
        l1.add(sixsept);
        LinkedList<Troncon> l2 = new LinkedList<Troncon>();
        l2.add(huitcinq);
        l2.add(cinqtrois);
        l2.add(troisdeux);
        LinkedList<Troncon> l3 = new LinkedList<Troncon>();
        l3.add(untrois);
        l3.add(troisix);
        l3.add(sixneuf);
        LinkedList<Troncon> l4 = new LinkedList<Troncon>();
        l4.add(cinqneuf);
        l4.add(neufsept);
        l4.add(septdeux);

        Ligne lun = new Ligne(1,"ligne 1","quatre","sept",l1);
        Ligne ldeux = new Ligne(2,"ligne 2","huit","deux",l2);
        Ligne ltrois = new Ligne(3,"ligne 3","un","neuf",l3);
        Ligne lquatre = new Ligne(4,"ligne 4","cinq","deux",l3);


        EnsLignes.add(lun);
        EnsLignes.add(ldeux);
        EnsLignes.add(ltrois);
        EnsLignes.add(lquatre);
    }

    /**
     * @return the EnsLignes
     */
    public ArrayList<Ligne> getEnsLignes() {
        return EnsLignes;
    }

    /**
     * @param EnsLignes the EnsLignes to set
     */
    public void setEnsLignes(ArrayList<Ligne> EnsLignes) {
        this.EnsLignes = EnsLignes;
    }
  

}
