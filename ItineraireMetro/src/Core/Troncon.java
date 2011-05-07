/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package Core;

/**
 *
 * @author Geoffrey
 */
public class Troncon {
    private int Num;
    private int Temps;
    private Station A;
    private Station B;
    private String Statut;

    public Troncon(int nu,int te,Station a, Station b, String s){
        Num = nu;
        Temps = te;
        A = a;
        B = b;
        Statut = s;
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
     * @return the Temps
     */
    public int getTemps() {
        return Temps;
    }

    /**
     * @param Temps the Temps to set
     */
    public void setTemps(int Temps) {
        this.Temps = Temps;
    }

    /**
     * @return the A
     */
    public Station getA() {
        return A;
    }

    /**
     * @param A the A to set
     */
    public void setA(Station A) {
        this.A = A;
    }

    /**
     * @return the B
     */
    public Station getB() {
        return B;
    }

    /**
     * @param B the B to set
     */
    public void setB(Station B) {
        this.B = B;
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

    
}
