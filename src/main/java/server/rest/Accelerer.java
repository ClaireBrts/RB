package server.rest;

import server.MinimalServerRest;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

@Path("accelerer")
public class Accelerer {
    @GET
    @Produces(MediaType.TEXT_PLAIN)
    public void getAccelerer() {
        MinimalServerRest.home.chenAccelerer();
    }
}
