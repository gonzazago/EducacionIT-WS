package com.eduit.ws.service;


import com.eduit.ws.cache.UserCache;
import com.eduit.ws.model.LoginResponse;
import com.eduit.ws.model.Usuario;

import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

@Path("v1/login")
public class Login {


    @POST
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    public Response login (Usuario usuario){
        if ("coco".equalsIgnoreCase(usuario.getNombre()) &&
            "123".equalsIgnoreCase(usuario.getContrasenia())){
            UserCache cache = new UserCache();
            String hash = cache.add(usuario);
            LoginResponse logginOk = new LoginResponse(hash);
            return Response.ok().entity(logginOk).build();
        }

        return Response.status(Response.Status.UNAUTHORIZED).build();
    }


}
