package com.example.demo.store;

import jakarta.ejb.Stateless;

import javax.inject.Inject;
import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

@Stateless
@Path("stores")
public class StoreResource {

    @Inject
    private StoreDao storeDao;

    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public Response all(){
        return Response.ok(storeDao.getAll()).build();
    }

    @GET
    @Produces(MediaType.APPLICATION_JSON)
    @Path("{id}")
    public Response findById(@PathParam("id") Long id){
        return Response.ok(storeDao.findById(id)).build();
    }

    @POST
    @Produces(MediaType.APPLICATION_JSON)
    @Consumes(MediaType.APPLICATION_JSON)
    public Response create(Store store){
        storeDao.save(store);
        return Response.status(Response.Status.CREATED).entity(store).build();
    }

    @PUT
    @Produces(MediaType.APPLICATION_JSON)
    @Consumes(MediaType.APPLICATION_JSON)
    public Response update(Store store){
        storeDao.update(store);
        return Response.ok().entity(store).build();
    }

    @DELETE
    @Path("{id}")
    public Response delete(@PathParam("id") Long id){
        storeDao.delete(id);
        return Response.noContent().build();
    }

}
