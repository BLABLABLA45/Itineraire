/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package Operation;

import Core.*;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author Geoffrey
 */
public class TraitementTest {
    Carte carte = new Carte();


    public TraitementTest() {
    }

    
    @BeforeClass
    public static void setUpClass() throws Exception {
    }

    @AfterClass
    public static void tearDownClass() throws Exception {
    }

    @After
    public void tearDown() {
    }

    Station expResult;

    @Before
    public void setUp() {
        expResult = carte.getEnsLignes().get(0).getListTron().get(2).getA();
    }
    @Test
    public void testRechercheCoord() {
        System.out.println("rechercheCoord");
        int x = 12;
        int y = 8;
        Station result = Traitement.rechercheCoord(x, y);
        assertTrue(expResult.getCoorX() == result.getCoorX() &&
                expResult.getCoorY() == result.getCoorY());
    }

    @Test
    public void testRechercheNom() {
        System.out.println("rechercheNom");
        String n = "six";
        Station result = Traitement.rechercheNom(n);
        assertTrue(expResult.getNom().equals(result.getNom()));
    }

    @Test
    public void testMajStation() {
        System.out.println("majStation");
        int id = 5;
        String st = "incident";
        Traitement.majStation(id,st);
        assertTrue(carte.getEnsStation().get(id).getStatut().equals(st));
    }

    @Test
    public void testMajTroncon() {
        System.out.println("majTroncon");
        int id = 5;
        String st = "incident";
        Traitement.majTroncon(id,st);
        assertTrue(carte.getEnsTroncon().get(id).getStatut().equals(st));
    }

 
  

    @Test
    public void testRechercheItineraire(){
        System.out.println("rechercheItineraire");
        int dep = 7;
        int arr = 3;

        Itineraire result = Traitement.rechercheItineraire(carte.getEnsStation().get(dep), carte.getEnsStation().get(arr));
        //System.out.println("Entre la station "+ (dep+1) + " et la station " + (arr+1)+" =>" + result.getItineraire().getLast().getNum());
        //result.parcourtFinal();
        assertTrue(result.getItineraire().getLast().getNum() == arr);

    }

}