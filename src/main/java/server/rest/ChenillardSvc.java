    package server.rest;

    import server.MinimalServerRest;
    import server.dto.ChenillardJson;

    import javax.ws.rs.*;
    import javax.ws.rs.core.MediaType;


    @Path("chenillard")
    public class ChenillardSvc {

        @GET
        @Path("/getStart")
        @Produces(MediaType.TEXT_HTML)
        public String getMessage() {

            MinimalServerRest.home.start();
            return  "<head>" + "<title>Titre de la page</title></head>" + "<body>FCT START</body>";
        }

        @GET
        @Path("/getStop")
        @Produces(MediaType.TEXT_HTML)
        public String getStop() {
            MinimalServerRest.home.stop();
            return  "<head>" + "<title>Titre de la page</title></head>" + "<body>FCT STOP</body>";
        }

        @GET
        @Path("/getChangeSens")
        @Produces(MediaType.TEXT_HTML)
        public String getChangeSens() {
            MinimalServerRest.home.chenChangementSens();
            return  "<head>" + "<title>Titre de la page</title></head>" + "<body>FCT Changer de sens</body>";

        }

        @GET
        @Path("/getRalentir")
        @Produces(MediaType.TEXT_HTML)
        public String getRalentir() {
            MinimalServerRest.home.chenRalentir();
            return  "<head>" + "<title>Titre de la page</title></head>" + "<body>FCT ralentir</body>";

        }

        @GET
        @Path("/getAccelerer")
        @Produces(MediaType.TEXT_HTML)
        public String getAccelerer() {
            MinimalServerRest.home.chenAccelerer();
            return  "<head>" + "<title>Titre de la page</title></head>" + "<body>FCT accelerer</body>";
        }

        @POST
        @Consumes(MediaType.APPLICATION_JSON)
        @Produces(MediaType.APPLICATION_JSON)
        @Path("/postSetVitesse")
        public void postSetVitesse(ChenillardJson chenille) {
            System.out.println("Output json server .... \n");
            System.out.println(chenille.getVitesse());
            MinimalServerRest.home.chenSetVitesse(chenille.getVitesse());
        }

        @GET
        @Path("/getChenillard")
        @Produces(MediaType.TEXT_HTML)
        public String getChenillard() {
            return MinimalServerRest.home.toString();
        }

    }
