package com.tp.rest;


import com.tp.dto.GameSessionDTO;
import com.tp.service.GameSessionService;
import jakarta.ws.rs.*;
import jakarta.ws.rs.core.MediaType;
import jakarta.ws.rs.core.Response;

@Path("/gamesessions")
public class GameSessionController {

    private final GameSessionService gameSessionService =new GameSessionService();;



    @POST
    @Path("/{kahootId}")
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    public Response createGameSession(@PathParam("kahootId") Long kahootId) {
        try {
            GameSessionDTO gameSessionDTO = gameSessionService.createGameSession(kahootId);
            return Response.status(Response.Status.CREATED).entity(gameSessionDTO).build();
        } catch (IllegalArgumentException e) {
            return Response.status(Response.Status.NOT_FOUND).entity(e.getMessage()).build();
        } catch (Exception e) {
            return Response.status(Response.Status.INTERNAL_SERVER_ERROR).entity("An error occurred").build();
        }
    }
}

