package webServices;

import logic.beanImp.UserBeanLogic;

import javax.ejb.EJB;
import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

/**
 * Created by error on 3/19/18.
 */
@Path("/user")
public class UserResource {

    @EJB
    UserBeanLogic userBeanLogic;

    @GET
    @Path("{regNo}")
    @Produces(MediaType.APPLICATION_JSON)
    @Consumes({MediaType.APPLICATION_JSON,MediaType.APPLICATION_XML})
    public Response getUser(@PathParam("regNo") String regNo){

        return null;




    }



}
