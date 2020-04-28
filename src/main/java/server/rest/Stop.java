package server.rest;

import server.MinimalServerRest;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

@Path("stop")
public class Stop {

    @GET
    @Produces(MediaType.TEXT_HTML)
    public String getMessage() {

        MinimalServerRest.home.stop();


        return  "<head>" + "<title>Titre de la page</title></head>" + "<body>FCT STOP</body>";

        //return "My message\n";
    }
}
