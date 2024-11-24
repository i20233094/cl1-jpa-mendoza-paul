package pe.edu.i202330941.crud;

import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;
import pe.edu.i202330941.entity.City;
import pe.edu.i202330941.entity.Country;
import pe.edu.i202330941.entity.CountryLanguage;

import java.util.Arrays;

public class JPAPersist {
    public static void main(String[] args) {

        EntityManagerFactory emf = Persistence.createEntityManagerFactory("world");
        EntityManager em = emf.createEntityManager();

        Country country = new Country(
                "RGH", "PERUCITO", "South America", "America", 100000.00, 1850,
                52152350, 85.00, 900.00, 452863.0, "Perucito",
                "Republica Federal", "Vizcarra", 5, "GD", null, null);

        // crear las ciudades
        City c1 = new City("Limon", "La rica Vicky", 600000, country);
        City c2 = new City("Villa Los Angeles", "Angeles", 300000, country);
        City c3 = new City("Las Candelas", "Candela", 350000, country);

        // agregar ciudades al país
        country.setCity(Arrays.asList(c1, c2, c3));

        // crear los lenguajes
        CountryLanguage l1 = new CountryLanguage("Español", "F", 20.00, country);
        CountryLanguage l2 = new CountryLanguage("Ingles", "T", 80.00, country);

        // agregar lenguajes al país
        country.setCountryLanguages(Arrays.asList(l1, l2));
        em.getTransaction().begin();
        em.persist(country);
        em.getTransaction().commit();
        System.out.println("Datos ingresados correctamente");
    }
}

