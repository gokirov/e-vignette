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
    @Produces(MediaType.TEXT_PLAIN)
    public String checkPlateNumber(String plateNumber) {
        return validityService.checkPlateNumber(plateNumber).toString();
    }

    @Path("/add")
    @POST
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    public String addVignette(Vignette vignette) {
        //Vignette vignette = new Vignette();
        validityService.addVignette(vignette);
        return "Successful";
    }
}
