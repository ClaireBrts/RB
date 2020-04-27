package server.rest;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

@Path("ralentir")
public class Ralentir {
    @GET
    @Produces(MediaType.TEXT_PLAIN)
    public void getRalentir() {
    }
}
