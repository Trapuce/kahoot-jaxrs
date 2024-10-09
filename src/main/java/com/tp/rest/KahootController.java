package com.tp.rest;


import com.tp.dto.KahootDTO;
import com.tp.model.Kahoot;
import com.tp.service.KahootService;
import jakarta.ws.rs.*;
import jakarta.ws.rs.core.MediaType;
import jakarta.ws.rs.core.Response;

import java.util.List;

@Path("/kahoots")
@Produces({"application/json"})
@Consumes({"application/json"})
public class KahootController {

    private final KahootService kahootService = new KahootService();



    @POST
    @Path("/{userId}")
    public Response create(@PathParam("userId") Long userId, KahootDTO kahootDTO) {
        try {
            KahootDTO createdKahoot = kahootService.createKahoot(kahootDTO, userId);
            return Response.status(Response.Status.CREATED).entity(createdKahoot).build();
        } catch (IllegalArgumentException e) {
            return Response.status(Response.Status.NOT_FOUND).entity(e.getMessage()).build();
        } catch (Exception e) {
            return Response.status(Response.Status.INTERNAL_SERVER_ERROR).entity("An error occurred").build();
        }
    }


    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public Response getAllKahoots() {
        try {
            List<KahootDTO> kahoots = kahootService.getAllKahoots();
            return Response.ok(kahoots).build(); // 200 OK with kahoots in JSON
        } catch (Exception e) {
            return Response.status(Response.Status.INTERNAL_SERVER_ERROR).entity("Error fetching kahoots").build();
        }
    }

    @GET
    @Path("/{id}")
    public Response getKahootById(@PathParam("id") Long kahootId) {
        try {
            KahootDTO kahoot = kahootService.getKahoot(kahootId);
            if (kahoot != null) {
                return Response.ok(kahoot).build(); // Renvoie 200 avec les détails du kahoot
            } else {
                return Response.status(Response.Status.NOT_FOUND)
                        .entity("Kahoot with ID " + kahootId + " not found").build(); // Kahoot non trouvé
            }
        } catch (Exception e) {
            return Response.status(Response.Status.INTERNAL_SERVER_ERROR)
                    .entity("Error fetching kahoot").build(); // Gestion des erreurs
        }
    }

}
