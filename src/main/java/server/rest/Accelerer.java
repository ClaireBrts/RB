package server.rest;

import fr.esir.projet.Chenillard;
import server.MinimalServerRest;
import server.dto.Employee;

import javax.print.attribute.standard.Media;
import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;

@Path("accelerer")
public class Accelerer {
    @GET
    @Produces(MediaType.TEXT_HTML)
    public String getAccelerer() {
        MinimalServerRest.home.chenAccelerer();
        return  "<head>" + "<title>Titre de la page</title></head>" + "<body>FCT accelerer</body>";
    }

    @Path("/json")
    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public Employee jsonstp() {
       // MinimalServerRest.home.chenAccelerer();

       Employee e =  new Employee();
       e.setAge(4);
       e.setName("Pol");
        return e  ;
    }

    @POST
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    @Path("/postAccelerer")
    public void postAccelerer(Employee employe) {
        System.out.println("Output json server .... \n");
        System.out.println(employe);
    }
}
