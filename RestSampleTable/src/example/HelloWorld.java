package example;
import com.sun.net.httpserver.HttpServer;
import com.sun.jersey.api.container.httpserver.HttpServerFactory;
import java.io.IOException;
import java.util.*;

import javax.ws.rs.GET;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.Path;

/**
 * Created by Hwang on 10/12/15.
 */
// The Java class will be hosted at the URI path "/helloworld"
@Path("/getAllUsersAndRoles")
public class HelloWorld {
    // The Java method will process HTTP GET requests
    @GET
    // The Java method will produce content identified by the MIME Media type "text/plain"
    @Produces("text/plain")
    public String getAllUsersAndRoles() {
        JDBCSelectAllUsersRoles instance = new JDBCSelectAllUsersRoles();
       // Return some cliched textual content
        return instance.runSample();
    }

    @GET
    @Path("/{param}")
        // The Java method will produce content identified by the MIME Media type "text/plain"
    @Produces("text/plain")
    public String getSpecificUserRoles(@PathParam("param") String user) {
        JDBCSelectAllUsersRoles instance = new JDBCSelectAllUsersRoles();
        // Return some cliched textual content
        return instance.runSampleForSpecificUser(user);
    }

    public static void main(String[] args) throws IOException {
        HttpServer server = HttpServerFactory.create("http://localhost:9998/");
        server.start();

        System.out.println("Server running");
        System.out.println("Visit: http://localhost:9998/getAllUsersAndRoles");
        System.out.println("Hit return to stop...");
        System.in.read();
        System.out.println("Stopping server");
        server.stop(0);
        System.out.println("Server stopped");
    }
}
