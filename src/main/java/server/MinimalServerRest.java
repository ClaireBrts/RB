package server;

import org.eclipse.jetty.server.Server;
import org.eclipse.jetty.servlet.ServletContextHandler;
import org.eclipse.jetty.servlet.ServletHolder;
import org.glassfish.jersey.servlet.ServletContainer;
import fr.esir.projet.*;

public class MinimalServerRest {

    public static KNX home;

    public static void main(String[] args) throws Exception {
        Server server = new Server(9999);

        ServletContextHandler ctx =
                new ServletContextHandler(ServletContextHandler.NO_SESSIONS);

        ctx.setContextPath("/");
        server.setHandler(ctx);

        ServletHolder serHol = ctx.addServlet(ServletContainer.class, "/rest/*");
        serHol.setInitOrder(1);
        serHol.setInitParameter("jersey.config.server.provider.packages",
                "server.rest");

        home = new KNX("192.168.0.29","192.168.1.201",3671);




        try {
            server.start();
            server.join();
        } catch (Exception ex) {
        } finally {

            server.destroy();
        }
    }
}
