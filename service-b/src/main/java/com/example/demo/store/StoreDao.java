package com.example.demo.store;

import jakarta.ejb.Stateless;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.transaction.Transactional;
import java.util.List;

@Stateless
public class StoreDao {

    @PersistenceContext(name = "store-pu")
    private EntityManager entityManager;

    public List<Store> getAll(){
        return entityManager.createNamedQuery("Store.findAll", Store.class).getResultList();
    }

    public Store findById(long id){
        return entityManager.createNamedQuery("Store.findById", Store.class).setParameter("id", id).getSingleResult();
    }

    @Transactional
    public void save(Store store){
        entityManager.persist(store);
    }

    @Transactional
    public void update(Store store){
        entityManager.merge(store);
    }

    @Transactional
    public void delete(Long id){
        Store store = findById(id);
        entityManager.remove(store);
    }
}
