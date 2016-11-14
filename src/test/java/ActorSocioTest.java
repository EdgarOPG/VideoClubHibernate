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
import mx.uach.videoclubhibernate.models.ActorSocio;
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
public class ActorSocioTest {
    
    public ActorSocioTest() {
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
        Query q = em.createQuery("SELECT a from Actor a WHERE nombre = 'Roberts'");
        Actor a = (Actor) q.getSingleResult();
        Query q2 = em.createQuery("SELECT s from Socio s WHERE nombre = 'Edgar'");
        Socio s = (Socio) q2.getSingleResult();
        ActorSocio as = new ActorSocio(a, s);
        em.getTransaction().begin();
        em.persist(as);
        em.getTransaction().commit();
    
    //  Operacion SELECT 1 
        Query q3 = em.createQuery("SELECT a from ActorSocio a WHERE id = 1");
        ActorSocio as2 = (ActorSocio) q3.getSingleResult();
        System.out.println(as2.toString());
        
    //  Operacion SELECT *
            Query qAll = em.createQuery("SELECT a from ActorSocio a");
        List<ActorSocio> actoresSocios = qAll.getResultList();        
        for (ActorSocio actorSocio : actoresSocios) {
            System.out.println(actorSocio.toString());
        }
       
    //  Operacion DELETE 
        em.getTransaction().begin();
        em.remove(as2);
        em.getTransaction().commit();


    }
}
