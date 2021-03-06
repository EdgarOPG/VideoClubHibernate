/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.Query;
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
     
    //  Creacion del EntityManager
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("videoPU");    
        EntityManager em = emf.createEntityManager();
        
    //  Operacion INSERT    
        Query q = em.createQuery("SELECT d from Director d WHERE nombre = 'Peinado'");
        Director d = (Director) q.getSingleResult();
        Pelicula p = new Pelicula("El aro", "terror", 120, d);
        em.getTransaction().begin();
        em.persist(p);
        em.getTransaction().commit();
        
    //  Operacion SELECT 1 
        Query q2 = em.createQuery("SELECT p from Pelicula p WHERE id = 3");
        Pelicula p2 = (Pelicula) q2.getSingleResult();
        System.out.println(p2.toString());
        
    //  Operacion SELECT *
        Query qAll = em.createQuery("SELECT p from Pelicula p");
        List<Pelicula> peliculas = qAll.getResultList();        
        for (Pelicula pelicula : peliculas) {
            System.out.println(pelicula.toString());
        }

    //  Operacion UPDATE
        em.getTransaction().begin();        
        p2.setTitulo("El conjuro");        
        em.persist(p2);
        em.getTransaction().commit();        

    //  Operacion DELETE 
        em.getTransaction().begin();
        em.remove(p2);
        em.getTransaction().commit();
    }
}
