package server.rest;

import server.MinimalServerRest;

import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

@Path("/ralentir")
public class RalentirXfois {

    //saisir dans l'URL /ralentir/300 pour que le chenillard ralentisse de 300

    @POST
    @Produces(MediaType.TEXT_PLAIN)
    @Consumes(MediaType.TEXT_PLAIN)
    @Path("/{number}")
    public Response getnumber(@PathParam("number") int vitesse){

        MinimalServerRest.home.chenRalentir(vitesse);

        return Response.status(200)
                .entity("La vitesse est de : "+ vitesse).build();
    }
}
