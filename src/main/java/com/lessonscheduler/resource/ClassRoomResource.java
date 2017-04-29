package com.lessonscheduler.resource;

import com.lessonscheduler.dto.ClassRoomDto;
import com.lessonscheduler.service.ClassRoomService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import java.util.List;

/**
 * Created by Günay on 3.4.2017.
 */

@Component
@Path("/classroom")
public class ClassRoomResource {

    @Autowired
    ClassRoomService classRoomService;

    @GET
    @Path("/all")
    @Produces(MediaType.APPLICATION_JSON)
    public Response getAllClassRooms() {

        List<ClassRoomDto> classRoomDtoList;

        try {
            classRoomDtoList = classRoomService.getAllClassRooms();
        } catch (Exception e) {
            return Response.status(Response.Status.INTERNAL_SERVER_ERROR).entity(e.getMessage()).build();
        }

        return Response.ok(classRoomDtoList).build();
    }

    @POST
    @Consumes(MediaType.APPLICATION_JSON)
    public Response addClassRoom(ClassRoomDto classRoomDto) {

        try {
            classRoomService.saveClassRoom(classRoomDto);
        } catch (Exception e) {
            return Response.status(Response.Status.INTERNAL_SERVER_ERROR).entity(e.getMessage()).build();
        }

        return Response.ok().build();
    }

    @PUT
    @Consumes(MediaType.APPLICATION_JSON)
    public Response editClassRoom(ClassRoomDto classRoomDto) {

        try {
            classRoomService.saveClassRoom(classRoomDto);
        } catch (Exception e) {
            return Response.status(Response.Status.INTERNAL_SERVER_ERROR).entity(e.getMessage()).build();
        }

        return Response.ok().build();
    }

    @DELETE
    @Path("/{id}")
    public Response removeClassRoom(@PathParam("id") Integer classRoomId) {

        try {
            classRoomService.removeClassRoom(classRoomId);
        } catch (Exception e) {
            return Response.status(Response.Status.INTERNAL_SERVER_ERROR).entity(e.getMessage()).build();
        }

        return Response.ok().build();
    }

    @GET
    @Path("/{id}")
    @Produces(MediaType.APPLICATION_JSON)
    public Response findClassRoom(@PathParam("id") Integer classRoomId) {

        ClassRoomDto classRoomDto;

        try {
            classRoomDto = classRoomService.findClasRoom(classRoomId);
        } catch (Exception e) {
            return Response.status(Response.Status.INTERNAL_SERVER_ERROR).entity(e.getMessage()).build();
        }

        return Response.ok(classRoomDto).build();
    }

}
