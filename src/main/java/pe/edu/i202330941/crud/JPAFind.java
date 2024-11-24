package pe.edu.i202330941.crud;

import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;
import pe.edu.i202330941.entity.City;
import pe.edu.i202330941.entity.Country;


import java.util.List;
import java.util.stream.Collectors;

public class JPAFind {

    public static void main(String[] args) {

        // referenciar al EMF y EM
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("world");
        EntityManager em = emf.createEntityManager();

        // buscar el país con código
        Country country = em.find(Country.class, "PER");

        // Filtrar las ciudades con población mayor a 700,000
        List<City> cities = country.getCity().stream()
                .filter((city) -> {
                    return city.getPopulation() > 700000;
                })
                .collect(Collectors.toList());

        cities.forEach((city) -> {
            System.out.println(city.getName());
        });

    }

}
