/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Tests;

import Logic.GestorSala;
import java.io.IOException;
import java.sql.SQLException;
import org.junit.Assert;
import static org.junit.Assert.assertArrayEquals;
import org.junit.Test;

/**
 *
 * @author mean
 */
public class TestSala {
    private GestorSala gs = new GestorSala();
    @Test
    public void testSalas() throws IOException, SQLException{
        String[] testSala = {"1","Sala Cuarta"};
        String[] sala = gs.getSalas().get(0);
        assertArrayEquals(testSala,sala);
    }
}
