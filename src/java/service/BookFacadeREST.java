/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package service;

import entity.Book;
import java.util.Date;
import java.util.List;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import javax.persistence.TypedQuery;
import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

/**
 *
 * @author Lolo
 */
@Stateless
@Path("entity.book")
public class BookFacadeREST extends AbstractFacade<Book> {

    @PersistenceContext(unitName = "LibraryRESTGFPU")
    private EntityManager em;

    public BookFacadeREST() {
        super(Book.class);
    }

    @POST
    @Override
    @Consumes({MediaType.APPLICATION_JSON})
    public void create(Book entity) {
        super.create(entity);
    }

    @PUT
    @Path("{id}")
    @Consumes({MediaType.APPLICATION_JSON})
    public void edit(@PathParam("id") Integer id, Book entity) {
        super.edit(entity);
    }

    @DELETE
    @Path("{id}")
    public void remove(@PathParam("id") Integer id) {
        super.remove(super.find(id));
    }

    @GET
    @Path("{id}")
    @Produces({MediaType.APPLICATION_JSON})
    public Book find(@PathParam("id") Integer id) {
        return super.find(id);
    }
    
    @GET
    @Path("isbn/{isbn}")
    @Produces({MediaType.APPLICATION_JSON})
    public Book findByIsbn(@PathParam("isbn") String isbn){
        TypedQuery<Book> query = em.createNamedQuery("Book.findByIsbn", Book.class);
        return query.setParameter("isbn", isbn).getSingleResult();
    }
    
    @GET
    @Path("date")
    @Produces({MediaType.APPLICATION_JSON})
    public List<Book> findByDateNull(){
        TypedQuery<Book> query = em.createNamedQuery("Book.findByDateNotNull", Book.class);
        return query.getResultList();
    }
    

    @GET
    @Override
    @Produces({MediaType.APPLICATION_JSON})
    public List<Book> findAll() {
        return super.findAll();
    }

    @GET
    @Path("{from}/{to}")
    @Produces({MediaType.APPLICATION_JSON})
    public List<Book> findRange(@PathParam("from") Integer from, @PathParam("to") Integer to) {
        return super.findRange(new int[]{from, to});
    }

    @GET
    @Path("count")
    @Produces(MediaType.TEXT_PLAIN)
    public String countREST() {
        return String.valueOf(super.count());
    }

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }
    
}
