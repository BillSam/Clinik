package webServices;

import com.google.gson.Gson;
import logic.beanInterface.BookingInt;
import pojos.actions.Booking;

import javax.ejb.EJB;
import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

/**
 * Created by error on 3/19/18.
 */
@Path("/bookings")
public class BookingResource {

    @EJB
    private BookingInt bookingInt;

    @GET
    @Produces(MediaType.APPLICATION_JSON)
    @Consumes({MediaType.APPLICATION_JSON,MediaType.APPLICATION_XML})
    public Response getAllbookings(){

        if (bookingInt.getAllBookings() != null){
            return Response
                    .status(200)
                    .entity(new Gson().toJson(bookingInt.getAllBookings()))
                    .build();
        }
        return Response
                .status(304)
                .entity("Failed to get bookings")
                .build();
    }

    @GET
    @Path("/{patientId}")
    @Produces(MediaType.APPLICATION_JSON)
    public Response getBookingById(@PathParam("patientId") String id){


        Gson gson = new Gson();
        Booking booking  = bookingInt.getBooking(id);

        if (booking != null){
            return Response
                    .status(200)
                    .entity(gson.toJson(booking))
                    .build();
        }else {

            return Response
                    .status(404)
                    .entity("Booking not found")
                    .build();
        }



    }

    @POST
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    public Response addBooking(String s){

        Gson gson = new Gson();



        if (bookingInt.createBooking(gson.fromJson(s, Booking.class))){

            return Response
                    .status(200)
                    .entity("Booking Successfully added")
                    .build();
        }

        return Response
                .status(304)
                .entity("Booking not modified")
                .build();



    }
    @DELETE
    @Path("/{patientId}")
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    public Response deleteBooking(String id){

        if (bookingInt.deleteBooking(id)){

            return Response
                    .status(200)
                    .entity("Successfully deleted")
                    .build();
        }
        return Response
                .status(304)
                .entity("Failed to delete")
                .build();

    }
}
