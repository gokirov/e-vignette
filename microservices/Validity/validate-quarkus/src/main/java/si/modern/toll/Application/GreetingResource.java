package si.modern.toll.Application;

import javax.ws.rs.*;
import javax.ws.rs.core.*;

@Path("/hello")
public class GreetingResource {

    @GET
    @Produces(MediaType.TEXT_PLAIN)
    public String hello() {
        return "Hello RESTEasy";
    }
}