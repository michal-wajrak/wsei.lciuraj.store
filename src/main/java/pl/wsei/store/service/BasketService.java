package pl.wsei.store.service;

import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;
import pl.wsei.store.model.Basket;

import java.util.List;

public class BasketService {

    private static EntityManagerFactory emf = Persistence.createEntityManagerFactory("pu");

    public void buyItem(String item, Integer quantity) {
        EntityManager em = emf.createEntityManager();

        try {
            em.getTransaction().begin();

            Basket existingBasket = em.createQuery(
                "SELECT b FROM Basket b WHERE b.item = :item", Basket.class)
                .setParameter("item", item)
                .getResultStream()
                .findFirst()
                .orElse(null);

            if (existingBasket != null) {
                existingBasket.setQuantity(existingBasket.getQuantity() + quantity);
                em.merge(existingBasket);
            } else {
                Basket basket = new Basket();
                basket.setItem(item);
                basket.setQuantity(quantity);
                em.persist(basket);
            }

            em.getTransaction().commit();
        } catch (Exception e) {
            em.getTransaction().rollback();
            throw e;
        } finally {
            em.close();
        }
    }

    public List<Basket> getAllItems() {
        EntityManager em = emf.createEntityManager();
        List<Basket> items;
        try {
            items = em.createQuery("SELECT b FROM Basket b ", Basket.class).getResultList();
        } finally {
            em.close();
        }
        return items;
    }

    public void clearBasket () {
        EntityManager em = emf.createEntityManager();
        try {
            em.getTransaction().begin();

            em.createQuery("DELETE FROM Basket").executeUpdate();

            em.getTransaction().commit();
        } catch (Exception e) {
            em.getTransaction().rollback();
            throw e;
        } finally {
            em.clear();
            em.close();
        }
    }
}
