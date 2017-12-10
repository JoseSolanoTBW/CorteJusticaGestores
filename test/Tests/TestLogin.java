/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Tests;

import Logic.GestorLogin;
import java.io.IOException;
import java.sql.SQLException;
import org.junit.Assert;
import static org.junit.Assert.assertEquals;
import org.junit.Test;

/**
 *
 * @author mean
 */
public class TestLogin {
    private GestorLogin gl = new GestorLogin();
    @Test
    public void testLogin() throws IOException, SQLException,Exception{
        assertEquals(true,gl.InicioSesion("JoseSolano", "123"));
    }
}
