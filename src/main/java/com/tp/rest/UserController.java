package com.tp.rest;

import com.tp.dto.UserDTO;
import com.tp.model.User;
import com.tp.service.UserService;
import jakarta.ws.rs.*;
import jakarta.ws.rs.core.Response;


import java.util.List;

@Path("/users")
@Produces({"application/json"})
@Consumes({"application/json"})
public class UserController {

    private final UserService userService = new UserService();

    @GET
    @Path("/{userId}")
    public Response getUserById(@PathParam("userId") Long userId) {
        try {
            User user = userService.getUserById(userId);
            return Response.ok(user).build();
        } catch (IllegalArgumentException e) {
            return Response.status(Response.Status.NOT_FOUND).entity(e.getMessage()).build();  // 404 Not Found
        }
    }

    @GET
    public Response getAllUsers() {
        List<User> userDTOs = userService.getAllUsers();
        if (userDTOs.isEmpty()) {
            return Response.status(Response.Status.NOT_FOUND).entity("No users found").build();  // 404 Not Found
        }
        return Response.ok(userDTOs).build();
    }

    @POST
    public Response createUser(UserDTO userDTO) {
        if (userDTO == null || userDTO.getUsername() == null || userDTO.getEmail() == null) {
            return Response.status(Response.Status.BAD_REQUEST).entity("Invalid user data").build();  // 400 Bad Request
        }

        UserDTO createdUser = userService.createUser(userDTO);
        return Response.status(Response.Status.CREATED).entity(createdUser).build();  // 201 Created
    }

    @PUT
    @Path("/{userId}")
    public Response updateUser(@PathParam("userId") Long userId, User user) {
        try {
            if (user== null || user.getUsername() == null || user.getEmail() == null) {
                return Response.status(Response.Status.BAD_REQUEST).entity("Invalid user data").build();  // 400 Bad Request
            }

            user.setId(userId);
            User updatedUser = userService.updateUser(user);
            return Response.ok(updatedUser).build();
        } catch (IllegalArgumentException e) {
            return Response.status(Response.Status.NOT_FOUND).entity(e.getMessage()).build();  // 404 Not Found
        }
    }

    @DELETE
    @Path("/{userId}")
    public Response deleteUser(@PathParam("userId") Long userId) {
        try {
            userService.deleteUser(userId);
            return Response.noContent().build();
        } catch (IllegalArgumentException e) {
            return Response.status(Response.Status.NOT_FOUND).entity(e.getMessage()).build();  // 404 Not Found
        }
    }
}
