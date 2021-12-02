package com.example.demo.book.resources;

import com.example.demo.book.models.Book;
import com.example.demo.book.services.BookService;

import javax.enterprise.context.ApplicationScoped;
import javax.inject.Inject;
import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

@ApplicationScoped
@Path("books")
public class BookResource {

    @Inject
    BookService bookService;

    @GET
    public Response getAll() {
        return Response.ok(bookService.getAll()).build();
    }

    @GET
    @Path("{id}")
    public Response getBook(@PathParam("id") int id) {
        Book book = bookService.findById(id);

        return Response.ok(book).build();
    }

    @POST
    @Produces(MediaType.APPLICATION_JSON)
    @Consumes(MediaType.APPLICATION_JSON)
    public Response create(Book book){
        bookService.create(book);
        return Response.status(Response.Status.CREATED).entity(book).build();
    }

    @PUT
    @Produces(MediaType.APPLICATION_JSON)
    @Consumes(MediaType.APPLICATION_JSON)
    public Response update(Book book){
        bookService.update(book);
        return Response.status(Response.Status.OK).entity(book).build();
    }

    @DELETE
    @Path("{id}")
    public Response delete(@PathParam("id") int id){
        bookService.delete(id);
        return Response.status(Response.Status.NO_CONTENT).build();
    }
}

