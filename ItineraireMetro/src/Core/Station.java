/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package Core;

import java.util.ArrayList;

public class Station {
    private int Num;
    private String Nom;
    private String Statut;
    private ArrayList<Ligne> ListLigne;
    private int CoorX;
    private int CoorY;
    private ArrayList<Voisin> voisins;
    private int sommet = 9999;
    private Station precedente;
    private boolean marque = false;

    public Station(){
        
    }

    public Station(int nu, String no, int cX, int cY){
        Num = nu;
        Nom = no;
        CoorX = cX;
        CoorY = cY;
        Statut = "normal";
        ListLigne = new ArrayList<Ligne>();
    }

    public void add(Ligne l){
        ListLigne.add(l);
    }

    /**
     * @return the Num
     */
    public int getNum() {
        return Num;
    }

    /**
     * @param Num the Num to set
     */
    public void setNum(int Num) {
        this.Num = Num;
    }

    /**
     * @return the Nom
     */
    public String getNom() {
        return Nom;
    }

    /**
     * @param Nom the Nom to set
     */
    public void setNom(String Nom) {
        this.Nom = Nom;
    }

    /**
     * @return the ListLigne
     */
    public ArrayList<Ligne> getListLigne() {
        return ListLigne;
    }

    /**
     * @param ListLigne the ListLigne to set
     */
    public void setListLigne(ArrayList<Ligne> ListLigne) {
        this.ListLigne = ListLigne;
    }

    /**
     * @return the CoorX
     */
    public int getCoorX() {
        return CoorX;
    }

    /**
     * @param CoorX the CoorX to set
     */
    public void setCoorX(int CoorX) {
        this.CoorX = CoorX;
    }

    /**
     * @return the CoorY
     */
    public int getCoorY() {
        return CoorY;
    }

    /**
     * @param CoorY the CoorY to set
     */
    public void setCoorY(int CoorY) {
        this.CoorY = CoorY;
    }

    /**
     * @return the Statut
     */
    public String getStatut() {
        return Statut;
    }

    /**
     * @param Statut the Statut to set
     */
    public void setStatut(String Statut) {
        this.Statut = Statut;
    }
public ArrayList<Voisin> getVoisins(){
        return voisins;
    }

    public void addVoisin(ArrayList<Voisin> v){
        voisins = v;
    }

    public void setSommet(int i){
        sommet = i;
    }

    public void setPrecedent(Station s){
        precedente = s;
    }

    public void setMarque(){
        marque = true;
    }

    public boolean estMarque(){
        return marque;
    }

    public int getSommet(){
        return sommet;
    }

    public Station getPrecedent(){
        return precedente;
    }
    
}
