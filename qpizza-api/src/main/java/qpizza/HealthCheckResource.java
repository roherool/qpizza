package qpizza;

import java.sql.SQLException;
import java.util.Map;

import javax.sql.DataSource;

import jakarta.inject.Inject;
import jakarta.persistence.EntityManager;
import jakarta.ws.rs.GET;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.Produces;
import jakarta.ws.rs.core.MediaType;

@Path("/health")
public class HealthCheckResource {

    @Inject
    DataSource ds;

    @Inject
    EntityManager em;

    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public Map<String, String> get() throws SQLException {
        var DBHealthy = isDBHealthy();
        var emOpen = isEMOpen().toString();
        var result = Map.of(
            "DBHealthy", DBHealthy,
            "emOpen", emOpen);
        return result;
    }

    private Boolean isEMOpen() {
        return em.isOpen();
    }

    private String isDBHealthy() throws SQLException {
        var status = "ok";
        try (var conn = ds.getConnection()) {
            if (conn.isValid(15)) {
                status = "valid";
            } else {
                status = "invalid";
            }
        }
        return status;
    }
}