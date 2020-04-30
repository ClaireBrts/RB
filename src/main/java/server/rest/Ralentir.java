package server.rest;

import server.MinimalServerRest;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

@Path("ralentir")
public class Ralentir {
    @GET
    @Produces(MediaType.TEXT_HTML)
    public String getRalentir() {
        MinimalServerRest.home.chenRalentir();
        return  "<head>" + "<title>Titre de la page</title></head>" + "<body>FCT ralentir</body>";

    }
}
