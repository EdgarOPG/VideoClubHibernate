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
public class SocioTest {
    
    public SocioTest() {
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
        Socio s = new Socio("Daniela", "La industrial", "6141375982");
        em.getTransaction().begin();
        em.persist(s);
        em.getTransaction().commit();
    
    //  Operacion SELECT 1 
        Query q = em.createQuery("SELECT s from Socio s WHERE id = 2");
        Socio s2 = (Socio) q.getSingleResult();
        System.out.println(s2.toString());
        
    //  Operacion SELECT *
        Query qAll = em.createQuery("SELECT s from Socio s");
        List<Socio> socios = qAll.getResultList();        
        for (Socio socio : socios) {
            System.out.println(socio.toString());
        }

    //  Operacion UPDATE
        em.getTransaction().begin();        
        s2.setNombre("Rodrigo");        
        em.persist(s2);
        em.getTransaction().commit();        

    //  Operacion DELETE 
        em.getTransaction().begin();
        em.remove(s2);
        em.getTransaction().commit();

}
}
