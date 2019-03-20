package com.iroshnk.demo.resource;

import com.iroshnk.demo.core.user.UserManager;
import com.iroshnk.demo.model.User;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;

import javax.enterprise.context.RequestScoped;
import javax.inject.Inject;
import javax.ws.rs.*;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import javax.ws.rs.core.UriInfo;

@RequestScoped
@Consumes(MediaType.APPLICATION_JSON)
@Produces(MediaType.APPLICATION_JSON)
@Path("users")
@Api
public class UserResource {
    @Context
    protected UriInfo uriInfo;

    @Inject
    private UserManager userManager;

    @GET
    @Path("{userId}")
    @ApiOperation(value = "Get user by id", tags = {"user"}, notes = "Returns a details of user.")
    @ApiResponses(value = {@ApiResponse(message = "List of customers", code = 200, response = User.class)})
    public Response getCustomer(@PathParam("userId") int userId) {
        User user = userManager.getUser(userId);
        return user != null
                ? Response.ok(user).build()
                : Response.status(Response.Status.NOT_FOUND).build();
    }
}
