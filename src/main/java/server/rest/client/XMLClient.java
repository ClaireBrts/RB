//package server.rest.client;
//
//
//
//import server.dto.Student;
//
//import javax.ws.rs.client.Client;
//import javax.ws.rs.client.ClientBuilder;
//import javax.ws.rs.client.Invocation;
//import javax.ws.rs.client.WebTarget;
//import javax.ws.rs.core.MediaType;
//import javax.ws.rs.core.Response;
//
//public class XMLClient {
//    public static void main(String[] args) {
//        Client client = ClientBuilder.newClient();
//        WebTarget webTarget = client.target("http://localhost:9999/xmlServices/student/James");
//        Invocation.Builder invocationBuilder =  webTarget.request(MediaType.APPLICATION_XML);
//        Response response = invocationBuilder.get(Response.class);
//        if (response.getStatus() != 200) {
//            throw new RuntimeException("Failed : HTTP error code : "
//                    + response.getStatus());
//        }
//        //String output = response.getEntity(String.class);
//        Student output = response.readEntity(Student.class);	//Get the object from the response
//        System.out.println("Output xml client .... \n");
//        System.out.println(output);
//    }
//}