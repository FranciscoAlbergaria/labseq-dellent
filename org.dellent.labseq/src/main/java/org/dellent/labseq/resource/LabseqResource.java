package org.dellent.labseq.resource;

import jakarta.inject.Inject;
import jakarta.ws.rs.GET;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.PathParam;
import jakarta.ws.rs.Produces;
import jakarta.ws.rs.core.MediaType;
import jakarta.ws.rs.core.Response;
import org.dellent.labseq.service.LabseqService;

@Path("/labseq")
public class LabseqResource {

    @Inject
    LabseqService labseqService;

    @GET
    @Path("/{n}")
    @Produces(MediaType.APPLICATION_JSON)
    public Response getLabseq(@PathParam("n") int n) {
        try {
            java.math.BigInteger value = labseqService.labseq(n);
            return Response.ok(new LabseqResult(n, value)).build();
        } catch (IllegalArgumentException e) {
            return Response.status(Response.Status.BAD_REQUEST)
                    .entity(e.getMessage()).build();
        }
    }

    public static class LabseqResult {
        public int n;
        public String value;
        public LabseqResult(int n, java.math.BigInteger value) {
            this.n = n;
            this.value = value.toString();
        }
    }
} 