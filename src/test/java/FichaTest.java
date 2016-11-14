/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

import java.sql.Date;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.Query;
import mx.uach.videoclubhibernate.models.Ficha;
import mx.uach.videoclubhibernate.models.Pelicula;
import mx.uach.videoclubhibernate.models.Socio;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

/**
 *
 * @author edgar
 */
public class FichaTest {
    
    public FichaTest() {
    }
    
    @BeforeClass
    public static void setUpClass() {
    }
    
    @AfterClass
    public static void tearDownClass() {
    }
    
    @Before
    public void setUp() {
    }
    
    @After
    public void tearDown() {
    }

    // TODO add test methods here.
    // The methods must be annotated with annotation @Test. For example:
    //
    @Test
    public void hello() {
    
    //  Creacion del EntityManager
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("videoPU");    
        EntityManager em = emf.createEntityManager();
        
    //  Operacion INSERT    
        Query q = em.createQuery("SELECT s from Socio s WHERE nombre = 'Rodrigo'");
        Socio s = (Socio) q.getSingleResult();
        String stringFecha = "2014-09-19";
        Date fecha = Date.valueOf(stringFecha);
        Ficha f = new Ficha(s, fecha);
        em.getTransaction().begin();
        em.persist(f);
        em.getTransaction().commit();
        
    //  Operacion SELECT 1 
        Query q2 = em.createQuery("SELECT f from Ficha f WHERE id = 2");
        Ficha f2 = (Ficha) q2.getSingleResult();
        System.out.println(f2.toString());
        
    //  Operacion SELECT *
        Query qAll = em.createQuery("SELECT f from Ficha f");
        List<Ficha> fichas = qAll.getResultList();        
        for (Ficha ficha : fichas) {
            System.out.println(ficha.toString());
        }       

    //  Operacion DELETE 
        em.getTransaction().begin();
        em.remove(f2);
        em.getTransaction().commit();        
        
    }
}
