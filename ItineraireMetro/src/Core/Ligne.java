/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package Core;

import java.util.LinkedList;


public class Ligne {
    private int Num;
    private String Nom;
    private String A;
    private String B;
    private LinkedList<Troncon> ListTron;

    public Ligne(int nu, String no, String a, String b,LinkedList<Troncon> li){
        Num = nu;
        Nom = no;
        A = a;
        B = b;
        ListTron = li;
    }

    public void add(Troncon t){
        ListTron.add(t);
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
     * @return the A
     */
    public String getA() {
        return A;
    }

    /**
     * @param A the A to set
     */
    public void setA(String A) {
        this.A = A;
    }

    /**
     * @return the B
     */
    public String getB() {
        return B;
    }

    /**
     * @param B the B to set
     */
    public void setB(String B) {
        this.B = B;
    }

    /**
     * @return the ListTron
     */
    public LinkedList<Troncon> getListTron() {
        return ListTron;
    }

    /**
     * @param ListTron the ListTron to set
     */
    public void setListTron(LinkedList<Troncon> ListTron) {
        this.ListTron = ListTron;
    }

    

}
