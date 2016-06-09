

/**
 * Created by carlhogo on 12/05/16.
 */


import org.eclipse.jetty.server.Handler;
import org.eclipse.jetty.server.Server;
import org.eclipse.jetty.server.handler.DefaultHandler;
import org.eclipse.jetty.server.handler.HandlerCollection;
import org.eclipse.jetty.servlet.ServletContextHandler;
import org.eclipse.jetty.servlet.ServletHolder;

public class JettyExample {

    public static void main(String[] args) throws Exception {

        //Server server = new Server(Integer.valueOf(System.getenv("PORT")));
        Server server = new Server(8080);
        ServletContextHandler context = new ServletContextHandler(ServletContextHandler.SESSIONS);
        context.setContextPath("/");
        server.setHandler(context);

        ServletHolder resource = context.addServlet(org.glassfish.jersey.servlet.ServletContainer.class, "/prueba/*");
        resource.setInitOrder(0);
        resource.setInitParameter("jersey.config.server.provider.classnames", Resource.class.getCanonicalName());

        ServletHolder calculator = context.addServlet(org.glassfish.jersey.servlet.ServletContainer.class, "/prueba2/*");
        calculator.setInitOrder(0);
        calculator.setInitParameter("jersey.config.server.provider.classnames", Calculator.class.getCanonicalName());

        HandlerCollection handlers = new HandlerCollection();
        handlers.setHandlers(new Handler[] { context, new DefaultHandler() });
        server.setHandler(handlers);

        server.start();
        server.join();

    }
}
