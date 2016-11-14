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
import mx.uach.videoclubhibernate.models.Actor;
import mx.uach.videoclubhibernate.models.Lista;
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
public class ListaTest {
    
    public ListaTest() {
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
        String stringFecha = "2014-09-19";
        Date fecha = Date.valueOf(stringFecha);
        Query q = em.createQuery("SELECT p from Pelicula p WHERE id = 3");
        Pelicula pelicula = (Pelicula) q.getSingleResult();
        Query q2 = em.createQuery("SELECT s from Socio s WHERE id = 1");
        Socio socio = (Socio) q2.getSingleResult();
        Lista l = new Lista(fecha, "Prestada", pelicula, socio);
        em.getTransaction().begin();
        em.persist(l);
        em.getTransaction().commit();
        
    //  Operacion SELECT 1 
        Query q3 = em.createQuery("SELECT l from Lista l WHERE id = 5");
        Lista l2 = (Lista) q3.getSingleResult();
        System.out.println(l2.toString());
        
    //  Operacion SELECT *
            Query qAll = em.createQuery("SELECT a from Actor a");
        List<Actor> actores = qAll.getResultList();        
        for (Actor actor : actores) {
            System.out.println(actor.toString());
        }

    //  Operacion UPDATE
        em.getTransaction().begin();        
        l2.setEstatus("Devuelta");        
        em.persist(l2);
        em.getTransaction().commit();        

    //  Operacion DELETE 
        em.getTransaction().begin();
        em.remove(l2);
        em.getTransaction().commit();

    }
}
