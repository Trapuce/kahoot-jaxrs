package com.tp.rest;

import com.tp.dto.QuestionDTO;
import com.tp.service.QuestionService;
import jakarta.ws.rs.*;
import jakarta.ws.rs.core.Response;

@Path("/questions")
@Produces({"application/json"})
@Consumes({"application/json"})
public class QuestionController {

    private final QuestionService questionService = new QuestionService();

    @POST
    @Path("/{kahootId}")
    public Response createQuestion(@PathParam("kahootId") Long kahootId, QuestionDTO questionDTO) {
        try {
            System.out.println("Received QuestionDTO: " + questionDTO);

            QuestionDTO createdQuestion = questionService.createQuestion(questionDTO, kahootId);
            return Response.status(Response.Status.CREATED).entity(createdQuestion).build();
        } catch (IllegalArgumentException e) {
            return Response.status(Response.Status.NOT_FOUND).entity(e.getMessage()).build();
        } catch (Exception e) {
            return Response.status(Response.Status.INTERNAL_SERVER_ERROR).entity("An error occurred while creating the question.").build();
        }
    }
}
