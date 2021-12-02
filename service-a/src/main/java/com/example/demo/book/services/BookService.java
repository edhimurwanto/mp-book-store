package com.example.demo.book.services;

import com.example.demo.book.models.Book;
import jakarta.ejb.Startup;
import jakarta.ejb.Stateless;

import javax.enterprise.context.Dependent;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.transaction.Transactional;
import java.util.ArrayList;
import java.util.List;

@Stateless
@Dependent
@Startup
public class BookService {

    @PersistenceContext(unitName = "restapi_PU")
    EntityManager em;

    public List getAll() {

        List<Book> books = em.createNamedQuery("Book.findAll", Book.class).getResultList();
        return books != null ? books : new ArrayList<>();
    }

    public Book findById(int id) {
        return em.find(Book.class, id);
    }

    @Transactional
    public void update(Book book) {
        em.merge(book);
    }

    @Transactional
    public void create(Book book) {
        em.persist(book);
    }

    @Transactional
    public void delete(int id) {
        Book book = findById(id);
        em.remove(book);
    }
}
