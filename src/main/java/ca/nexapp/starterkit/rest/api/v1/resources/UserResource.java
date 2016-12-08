package ca.nexapp.starterkit.rest.api.v1.resources;

import ca.nexapp.starterkit.application.users.FindUserByEmailUseCase;
import ca.nexapp.starterkit.application.users.UserAssembler;
import ca.nexapp.starterkit.application.users.UserResponse;
import ca.nexapp.starterkit.domain.users.User;
import ca.nexapp.starterkit.domain.users.UserNotFoundException;
import ca.nexapp.starterkit.domain.users.UserRepository;

import javax.inject.Inject;
import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

@Path("user")
public class UserResource {

    @Inject
    private UserRepository userRepository;
    @Inject
    private UserAssembler userAssembler;

    @GET
    @Path("{email}")
    @Produces(MediaType.APPLICATION_JSON)
    @Consumes(MediaType.APPLICATION_JSON)
    public Response findByEmail(@PathParam("email") String email) throws UserNotFoundException {
        User user = new FindUserByEmailUseCase(userRepository).find(email);
        UserResponse userResponse = userAssembler.assembleToDTO(user);
        return Response.ok(userResponse).build();
    }
}
