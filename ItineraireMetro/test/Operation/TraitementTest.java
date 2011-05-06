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
        Carte carte = new Carte();
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

}