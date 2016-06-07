package org.june.hackathon;

import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import java.util.ArrayList;

/**
 * Root resource (exposed at "myresource" path)
 */
@Path("users")
public class MyResource {
    private DBInteraction dbInteraction = new DBInteraction();
    /**
     * Method handling HTTP GET requests. The returned object will be sent
     * to the client as "text/plain" media type.
     *
     * @return String that will be returned as a text/plain response.
     */
    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public ArrayList<String> getIt() {
        ArrayList<String> userNames = dbInteraction.fetchOnlineUsers();
        return userNames;
    }

    @PUT @Path("/logout/{user_name}")
    @Produces(MediaType.TEXT_PLAIN)
    public int logoutUser(@PathParam("user_name") String userName){
        return dbInteraction.logoutUser(userName);
    }

    @PUT @Path("/login/{user_name}")
    @Produces(MediaType.TEXT_PLAIN)
    public int loginUser(@PathParam("user_name") String userName){
        return dbInteraction.loginUser(userName);
    }

    @POST @Path("/authenticate")
    @Consumes("application/x-www-form-urlencoded")
    @Produces(MediaType.TEXT_PLAIN)
    public Boolean authenticateUser(@FormParam("UserName") String userName,
                                    @FormParam("Password") String password){
        return dbInteraction.authenticateUser(userName, password);
    }

    @POST @Path("/register/newuser")
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.TEXT_PLAIN)
    public String registerUser(Users user){
        return dbInteraction.registerUser(user);
    }

    @GET @Path("/{user_name}")
    @Produces(MediaType.APPLICATION_JSON)
    public Users getThat(@PathParam("user_name") String userName) {
        return dbInteraction.fetchUser(userName);
    }
}
