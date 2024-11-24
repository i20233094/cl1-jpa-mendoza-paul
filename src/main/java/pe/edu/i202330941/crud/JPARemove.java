package pe.edu.i202330941.crud;

import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;
import pe.edu.i202330941.Main;
import pe.edu.i202330941.entity.Country;

public class JPARemove {
    public static void main(String[] args) {

        EntityManagerFactory emf = Persistence.createEntityManagerFactory("world");
        EntityManager em = emf.createEntityManager();

        Country country = em.find(Country.class, "RGH");

        em.getTransaction().begin();
        em.remove(country);
        em.getTransaction().commit();

    }
}
