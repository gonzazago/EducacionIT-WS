package com.eduit.ws.service;


import com.eduit.ws.model.Libro;
import com.eduit.ws.repository.LibroMemoryRepository;

import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import java.util.List;

@Path("/v1/libro")
public class LibroResource {

    private LibroMemoryRepository repository;

    public LibroResource() {
        repository = new LibroMemoryRepository();
    }

    @PUT
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    public Libro save(Libro libro) {
        Libro response = repository.insert(libro);
        return response;
    }

    @GET
    @Path("{idem}")
    @Produces(MediaType.APPLICATION_JSON)
    public Libro getById(@PathParam("idem") long id) {
        return repository.getById(id);
    }

    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public List<Libro> getAll() {
        return repository.getAll();
    }

    @POST
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    public Response update(Libro libro) {

        if(!repository.exists(libro.getId())) {
            return Response.status(Response.Status.BAD_REQUEST)
                    .type(MediaType.TEXT_PLAIN)
                    .entity("Libro Id " + libro.getId() + "no Existe")
                    .build();
        }

        libro = repository.update(libro);
        return Response.ok().entity(libro).build();

    }

    @DELETE
    @Path("{idem}")
    public Response delete(@PathParam("idem") long id) {
        repository.delete(id);
        return Response.ok()
                .entity("Borrado Exitosamente")
                .type(MediaType.TEXT_PLAIN)
                .build();

    }


}
