package server.rest;

import fr.esir.projet.*;
import server.MinimalServerRest;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

@Path("start")
public class Start {

    @GET
    @Produces(MediaType.TEXT_HTML)
    public String getMessage() {

        MinimalServerRest.home.start();

        return  "<head>" + "<title>Titre de la page</title></head>" + "<body>FCT START</body>";

        //return "My message\n";
    }
}

