

/**
 * Created by carlhogo on 12/05/16.
 */

import org.eclipse.jetty.server.Server;
import org.eclipse.jetty.servlet.ServletContextHandler;
import org.eclipse.jetty.servlet.ServletHolder;

public class JettyExample {

    public static void main(String[] args) throws Exception {

        Server server = new Server(Integer.valueOf(System.getenv("PORT")));
        //Server server = new Server(8080);
        ServletContextHandler context = new ServletContextHandler(ServletContextHandler.SESSIONS);
        context.setContextPath("/");
        server.setHandler(context);
        ServletHolder servlet = context.addServlet(org.glassfish.jersey.servlet.ServletContainer.class, "/*");
        servlet.setInitOrder(0);
        servlet.setInitParameter("jersey.config.server.provider.classnames", Resource.class.getCanonicalName());
        servlet.setInitParameter("jersey.config.server.provider.classnames", Calculator.class.getCanonicalName());
        server.start();
        server.join();

    }
}
