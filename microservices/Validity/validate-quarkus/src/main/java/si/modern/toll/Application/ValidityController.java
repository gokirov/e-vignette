package si.modern.toll.Application;

import io.quarkus.logging.Log;
import si.modern.toll.Domain.Entity.Vignette;
import si.modern.toll.Domain.Service.ValidityService;

import javax.inject.Inject;
import javax.ws.rs.*;
import javax.ws.rs.core.*;
import java.util.Date;

@Path("/validate")
public class ValidityController {
    @Inject
    ValidityService validityService;

    @POST
    public Response checkPlateNumber(String plateNumber) {
        try {
            System.out.println("SAOKD " + plateNumber);
            Log.info("ValidityController, addVignette, Started with string: " + plateNumber);
            return Response.ok().entity(validityService.checkPlateNumber(plateNumber)).build();
        } catch (Exception e) {
            Log.info("ValidityController, checkPlateNumber, Error: " + e);
            return Response.status(500).build();
        }
    }

    @Path("/add")
    @POST
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    public Response addVignette(Vignette vignette) {
        try {
            Log.info("ValidityController, addVignette, Started with object: " + vignette);
            return Response.ok().entity(validityService.addVignette(vignette)).build();
        } catch (Exception e) {
            Log.info("ValidityController, addVignette, Error: " + e);
            return Response.status(500).build();
        }
    }
}
