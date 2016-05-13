/**
 * Created by carlhogo on 12/05/16.
 */

import org.eclipse.jetty.server.Server;
import org.eclipse.jetty.servlet.ServletContextHandler;
import org.eclipse.jetty.servlet.ServletHolder;

public class JettyExample {

    public static void main(String[] args) throws Exception {

        ServletContextHandler context = new ServletContextHandler(ServletContextHandler.SESSIONS);
        context.setContextPath("/");

        Server server = new Server(2222);
        server.setHandler(context);


        ServletHolder servlet = context.addServlet(org.glassfish.jersey.servlet.ServletContainer.class, "/*");

        servlet.setInitOrder(0);

        // Tells the Jersey Servlet which REST service/class to load.
        servlet.setInitParameter(
                "jersey.config.server.provider.classnames",
                Resource.class.getCanonicalName());

        try {
            server.start();
            server.join();
        } finally {
            server.destroy();
        }

    }
}
