package server.rest;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

@Path("msg")
public class MyMessage {

    @GET
    @Produces(MediaType.TEXT_HTML)
    public String getMessage() {

        return "<head>" + "<title>Titre de la page</title></head>" + "<body> Helloooo</body>";

        //return "My message\n";
    }
}

