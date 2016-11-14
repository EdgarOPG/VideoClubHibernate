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
import mx.uach.videoclubhibernate.models.Actor;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

/**
 *
 * @author edgar
 */
public class PeliculaActorTest {
    
    public PeliculaActorTest() {
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
        Actor a = new Actor("Robert", "Downey Jr.");
        em.getTransaction().begin();
        em.persist(a);
        em.getTransaction().commit();
    
    //  Operacion SELECT 1 
        Query q = em.createQuery("SELECT a from Actor a WHERE id = 5");
        Actor a2 = (Actor) q.getSingleResult();
        System.out.println(a2.toString());
        
    //  Operacion SELECT *
            Query qAll = em.createQuery("SELECT a from Actor a");
        List<Actor> actores = qAll.getResultList();        
        for (Actor actor : actores) {
            System.out.println(actor.toString());
        }

    //  Operacion UPDATE
        em.getTransaction().begin();        
        a2.setApellido("Chaparro");        
        em.persist(a2);
        em.getTransaction().commit();        

    //  Operacion DELETE 
        em.getTransaction().begin();
        em.remove(a2);
        em.getTransaction().commit();
    }
}
