package server.rest;

import server.MinimalServerRest;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

@Path("changesens")
public class ChangeSens {
    @GET
    @Produces(MediaType.TEXT_HTML)
    public String getChangeSens() {
        MinimalServerRest.home.chenChangementSens();
        return  "<head>" + "<title>Titre de la page</title></head>" + "<body>FCT Changer de sens</body>";

    }
}
