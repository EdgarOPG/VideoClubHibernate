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
import mx.uach.videoclubhibernate.models.Cinta;
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
public class CintaTest {
    
    public CintaTest() {
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
        Query q = em.createQuery("SELECT p from Pelicula p WHERE id = 3");
        Pelicula pelicula = (Pelicula) q.getSingleResult();
        Cinta c = new Cinta(1, pelicula);
        em.getTransaction().begin();
        em.persist(c);
        em.getTransaction().commit();
    
    //  Operacion SELECT 1 
        Query q2 = em.createQuery("SELECT c from Cinta c WHERE id = 1");
        Cinta c2 = (Cinta) q.getSingleResult();
        System.out.println(c2.toString());
        
    //  Operacion SELECT *
        Query qAll = em.createQuery("SELECT c from Cinta c");
        List<Cinta> cintas = qAll.getResultList();        
        for (Cinta cinta : cintas) {
            System.out.println(cinta.toString());
        }

    //  Operacion UPDATE
        em.getTransaction().begin();        
        c2.setNumeroCopia(5);        
        em.persist(c2);
        em.getTransaction().commit();        

    //  Operacion DELETE 
        em.getTransaction().begin();
        em.remove(c2);
        em.getTransaction().commit();
    }
}
