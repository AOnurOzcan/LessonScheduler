package com.lessonscheduler.resource;

import com.lessonscheduler.dto.LessonDto;
import com.lessonscheduler.service.LessonService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import java.util.List;

/**
 * Created by Onur on 6.4.2017.
 */

@Component
@Path("/lesson")
public class LessonResource {

    @Autowired
    LessonService lessonService;

    @GET
    @Path("/all")
    @Produces(MediaType.APPLICATION_JSON)
    public Response getAllLessons() {

        List<LessonDto> lessonDtoList;

        try {
            lessonDtoList = lessonService.getAllLessons();
        } catch (Exception e) {
            return Response.status(Response.Status.INTERNAL_SERVER_ERROR).entity(e.getMessage()).build();
        }

        return Response.ok(lessonDtoList).build();
    }

    @POST
    @Consumes(MediaType.APPLICATION_JSON)
    public Response addLesson(LessonDto lessonDto) {

        try {
            lessonService.saveLesson(lessonDto);
        } catch (Exception e) {
            return Response.status(Response.Status.INTERNAL_SERVER_ERROR).entity(e.getMessage()).build();
        }

        return Response.ok().build();
    }

    @PUT
    @Consumes(MediaType.APPLICATION_JSON)
    public Response editLesson(LessonDto lessonDto) {

        try {
            lessonService.saveLesson(lessonDto);
        } catch (Exception e) {
            return Response.status(Response.Status.INTERNAL_SERVER_ERROR).entity(e.getMessage()).build();
        }

        return Response.ok().build();
    }

    @DELETE
    @Path("/{id}")
    public Response removeLesson(@PathParam("id") Integer lessonId) {

        try {
            lessonService.removeLesson(lessonId);
        } catch (Exception e) {
            return Response.status(Response.Status.INTERNAL_SERVER_ERROR).entity(e.getMessage()).build();
        }

        return Response.ok().build();
    }

    @GET
    @Path("/{id}")
    @Produces(MediaType.APPLICATION_JSON)
    public Response findLesson(@PathParam("id") Integer lessonId) {

        LessonDto lessonDto;

        try {
            lessonDto = lessonService.findLesson(lessonId);
        } catch (Exception e) {
            return Response.status(Response.Status.INTERNAL_SERVER_ERROR).entity(e.getMessage()).build();
        }

        return Response.ok(lessonDto).build();
    }

    @GET
    @Path("/notChosen")
    @Produces(MediaType.APPLICATION_JSON)
    public Response findNotChosenLessons() {
        List<LessonDto> lessonDtoList;

        try {
            lessonDtoList = lessonService.findNotChosenLessons();
        } catch (Exception e) {
            return Response.status(Response.Status.INTERNAL_SERVER_ERROR).entity(e.getMessage()).build();
        }

        return Response.ok(lessonDtoList).build();
    }

    @POST
    @Path("/multi")
    @Consumes(MediaType.APPLICATION_JSON)
    public Response saveMultiLesson(List<LessonDto> lessonDtoList) {
        try {
            lessonService.saveMultiLesson(lessonDtoList);
        } catch (Exception e) {
            return Response.status(Response.Status.INTERNAL_SERVER_ERROR).entity(e.getMessage()).build();
        }

        return Response.ok().build();
    }

}
