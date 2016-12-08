package ca.nexapp.starterkit.rest.api.v2.resources;

import javax.inject.Inject;
import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import ca.nexapp.starterkit.application.users.FindUserByEmailUseCase;
import ca.nexapp.starterkit.application.users.UserAssembler;
import ca.nexapp.starterkit.application.users.UserResponse;
import ca.nexapp.starterkit.domain.users.User;
import ca.nexapp.starterkit.domain.users.UserNotFoundException;
import ca.nexapp.starterkit.domain.users.UserRepository;
import ca.nexapp.starterkit.rest.api.v2.parameters.EmailParameter;

@Path("user")
public class UserResource {

    @Inject
    private UserRepository userRepository;
    @Inject
    private UserAssembler userAssembler;

    @POST
    @Produces(MediaType.APPLICATION_JSON)
    @Consumes(MediaType.APPLICATION_JSON)
    public Response queryByEmail(EmailParameter email) throws UserNotFoundException {
        User user = new FindUserByEmailUseCase(userRepository).find(email.email);
        UserResponse userResponse = userAssembler.assembleToDTO(user);
        return Response.ok(userResponse).build();
    }
}
