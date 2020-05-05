package server.rest;

import fr.esir.projet.Chenillard;
import server.MinimalServerRest;

import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

@Path("accelerer")
public class Accelerer {
    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public String getAccelerer() {
        MinimalServerRest.home.chenAccelerer();
        return  "<head>" + "<title>Titre de la page</title></head>" + "<body>FCT accelerer</body>";
    }

    @POST
    @Path("/postAccelerer")
    public void postAccelerer(Chenillard chenillard) {
        System.out.println("Output json server .... \n");
        System.out.println(chenillard);
    }
}
