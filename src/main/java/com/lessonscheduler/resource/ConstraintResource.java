package com.lessonscheduler.resource;

import com.lessonscheduler.dto.ClassRoomDto;
import com.lessonscheduler.dto.ConstraintDto;
import com.lessonscheduler.service.ClassRoomService;
import com.lessonscheduler.service.ConstraintService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import java.util.List;

/**
 * Created by Günay on 5.4.2017.
 */

@Component
@Path("/constraint")
public class ConstraintResource {

    @Autowired
    ConstraintService constraintService;

    @GET
    @Path("/all")
    @Produces(MediaType.APPLICATION_JSON)
    public Response getAllConstraints() {

        List<ConstraintDto> constraintDtoList;

        try {
            constraintDtoList = constraintService.getAllConstraints();
        } catch (Exception e) {
            return Response.status(Response.Status.INTERNAL_SERVER_ERROR).entity(e.getMessage()).build();
        }

        return Response.ok(constraintDtoList).build();
    }

    @POST
    @Consumes(MediaType.APPLICATION_JSON)
    public Response addConstraint(ConstraintDto constraintDto) {

        try {
            constraintService.saveConstraint(constraintDto);
        } catch (Exception e) {
            return Response.status(Response.Status.INTERNAL_SERVER_ERROR).entity(e.getMessage()).build();
        }

        return Response.ok().build();
    }

    @PUT
    @Consumes(MediaType.APPLICATION_JSON)
    public Response editConstraint(ConstraintDto constraintDto) {

        try {
            constraintService.saveConstraint(constraintDto);
        } catch (Exception e) {
            return Response.status(Response.Status.INTERNAL_SERVER_ERROR).entity(e.getMessage()).build();
        }

        return Response.ok().build();
    }

    @DELETE
    @Path("/{id}")
    public Response removeConstraint(@PathParam("id") Integer constraintId) {

        try {
            constraintService.removeConstraint(constraintId);
        } catch (Exception e) {
            return Response.status(Response.Status.INTERNAL_SERVER_ERROR).entity(e.getMessage()).build();
        }

        return Response.ok().build();
    }

    @GET
    @Path("/{id}")
    @Produces(MediaType.APPLICATION_JSON)
    public Response findConstraint(@PathParam("id") Integer constraintId) {

        ConstraintDto constraintDto;

        try {
            constraintDto = constraintService.findConstraint(constraintId);
        } catch (Exception e) {
            return Response.status(Response.Status.INTERNAL_SERVER_ERROR).entity(e.getMessage()).build();
        }

        return Response.ok(constraintDto).build();
    }
}
