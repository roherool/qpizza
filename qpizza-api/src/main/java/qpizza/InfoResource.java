package qpizza;

import java.util.Map;

import jakarta.ws.rs.GET;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.Produces;
import jakarta.ws.rs.core.MediaType;

@Path("/info")
public class InfoResource {

    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public Map<String,String> getInfo() {
        var info = Map.of(k1:"info", v1:"Olá Pizza");
        return info;
    }
}
