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
    Station expResult;
    Carte carte = new Carte();

    public TraitementTest() {
    }

    @BeforeClass
    public static void setUpClass() throws Exception {
    }

    @AfterClass
    public static void tearDownClass() throws Exception {
    }

    @Before
    public void setUp() {
        expResult = carte.getEnsStation().get(5);
        //expResult = carte.getEnsLignes().get(0).getListTron().get(2).getA();
    }

    @After
    public void tearDown() {
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
        Traitement.majStation(id, st);
        assertTrue(carte.getEnsStation().get(id).getStatut().equals(st));
    }

    @Test
    public void testMajTroncon() {
        System.out.println("majTroncon");
        int id = 5;
        String st = "incident";
        Traitement.majTroncon(id, st);
        assertTrue(carte.getEnsTroncon().get(5).getStatut().equals(st));
    }

}