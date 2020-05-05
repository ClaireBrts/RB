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

            //return "My message\n";
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

        @POST
        @Consumes(MediaType.APPLICATION_JSON)
        @Produces(MediaType.APPLICATION_JSON)
        @Path("/postRalentir")
        public void postRalentir(ChenillardJson chenille) {
            System.out.println("Output json server .... \n");
            System.out.println(chenille);
            MinimalServerRest.home.chenRalentir(chenille.getVitesse());

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
        @Path("/postAccelerer")
        public void postAccelerer(ChenillardJson chenille) {
            System.out.println("Output json server .... \n");
            System.out.println(chenille);
            MinimalServerRest.home.chenAccelerer(chenille.getVitesse());
        }

    }