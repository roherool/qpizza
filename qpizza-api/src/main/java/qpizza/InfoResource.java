package qpizza;

import jakarta.ws.rs.GET;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.Produces;
import jakarta.ws.rs.core.MediaType;

@Path("/info")
public class InfoResource {

    @GET
    @Produces(MediaType.TEXT_PLAIN)
    public String info() {
        return "Olá Home";
    }
}