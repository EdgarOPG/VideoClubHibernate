/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.Query;
import mx.uach.videoclubhibernate.models.Actor;
import mx.uach.videoclubhibernate.models.Director;
import mx.uach.videoclubhibernate.models.Pelicula;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

/**
 *
 * @author edgar
 */
public class PeliculaTest {
    
    public PeliculaTest() {
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
     EntityManagerFactory emf = Persistence.createEntityManagerFactory("videoPU");
        
        EntityManager em = emf.createEntityManager();
        
        Query q = em.createQuery("SELECT d from Director d WHERE nombre = 'Peinado'");
        Director d = (Director) q.getSingleResult();
        System.out.println(d);
        
        Pelicula p = new Pelicula("El aro", "terror", 120, d);
        em.getTransaction().begin();
        em.persist(p);
        em.getTransaction().commit();
    }
}
