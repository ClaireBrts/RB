//package server.rest.client;
//
//
//
//import com.sun.jersey.api.client.ClientResponse;
//import com.sun.jersey.api.client.WebResource;
//import server.dto.Employee;
//
//import com.sun.jersey.api.client.Client;
//
//
//public class JsonClient {
//
//    public static void main(String[] args) {
//        Client client = Client.create();
//        //Get
//        WebResource webResource = client.resource("http://localhost:9999/employee/getEmployee");
//        ClientResponse response = webResource.accept("application/json").get(ClientResponse.class);
//        if (response.getStatus() != 200) {
//            throw new RuntimeException("Failed : HTTP error code : "
//                    + response.getStatus());
//        }
////		String output = response.getEntity(String.class);
//        Employee output = response.getEntity(Employee.class);//Get the object from the response
//        System.out.println("Output json client .... \n");
//        System.out.println(output);
//        //Post
//        webResource = client.resource("http://localhost:9999/employee/postEmployee");
//        webResource.accept("application/json").post(ClientResponse.class, output);
//    }
//}