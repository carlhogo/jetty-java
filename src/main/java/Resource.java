
import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;

/**
 * Created by carlhogo on 12/05/16.
 */
@Path("home")
public class Resource{
    @GET
    @Path("hello")
    @Produces(MediaType.TEXT_PLAIN)
    public String helloWorld() {
        return "Hello, world!";
    }

    @GET
    @Path("saludo")
    @Produces(MediaType.APPLICATION_JSON)
    public Saludo saludar() {

        Saludo a = new Saludo();
        a.setSal("hello world");
        return a;
    }


    @GET
    @Path("param")
    @Produces(MediaType.TEXT_PLAIN)
    public String paramMethod(@QueryParam("name") String name) {
        return "Hello, " + name;
    }

    @GET
    @Path("path/{var}")
    @Produces(MediaType.TEXT_PLAIN)
    public String pathMethod(@PathParam("var") String name) {
        return "Hello, " + name;
    }

    @POST
    @Path("post")
    @Consumes(MediaType.APPLICATION_FORM_URLENCODED)
    @Produces(MediaType.TEXT_HTML)
    public String postMethod(@FormParam("name") String name) {
        return "<h2>Hello, " + name + "</h2>";
    }

    static class Saludo{
        String sal;

        public String getSal() {
            return sal;
        }
        public void setSal(String sal) {
            this.sal = sal;
        }
    }
}
