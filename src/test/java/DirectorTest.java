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
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

/**
 *
 * @author edgar
 */
public class DirectorTest {
    
    public DirectorTest() {
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
        Director d = new Director("Tarantino");
        em.getTransaction().begin();
        em.persist(d);
        em.getTransaction().commit();
    
    //  Operacion SELECT 1 
        Query q = em.createQuery("SELECT d from Director d WHERE id = 3");
        Director d2 = (Director) q.getSingleResult();
        System.out.println(d2.toString());
        
    //  Operacion SELECT *
    Query qAll = em.createQuery("SELECT d from Director d");
        List<Director> directores = qAll.getResultList();        
        for (Director director : directores) {
            System.out.println(director.toString());
        }

    //  Operacion UPDATE
        em.getTransaction().begin();        
        d2.setNombre("Scorsese");        
        em.persist(d2);
        em.getTransaction().commit();        

    //  Operacion DELETE 
        em.getTransaction().begin();
        em.remove(d2);
        em.getTransaction().commit();
    }
}
