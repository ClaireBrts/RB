package server.rest;


import server.MinimalServerRest;

import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

@Path("/accelerer")
public class AccelererXfois {

    @POST
    @Produces(MediaType.TEXT_PLAIN)
    @Consumes(MediaType.TEXT_PLAIN)
    @Path("/{number}")
    public Response getnumber(@PathParam("number") int vitesse){

        MinimalServerRest.home.chenAccelerer(vitesse);

        return Response.status(200)
                .entity("La vitesse est de : "+ vitesse).build();
    }
}
