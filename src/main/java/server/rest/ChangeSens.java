package server.rest;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

@Path("changesens")
public class ChangeSens {
    @GET
    @Produces(MediaType.TEXT_PLAIN)
    public void getChangeSens() {
    }
}
