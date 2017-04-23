package com.lessonscheduler.resource;

import com.lessonscheduler.dto.ScheduleDto;
import com.lessonscheduler.service.ScheduleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import java.util.List;


/**
 * Created by Onur on 8.4.2017.
 */

@Component
@Path("/schedule")
public class ScheduleResource {

    @Autowired
    ScheduleService scheduleService;

    @GET
    @Path("/calculate")
    public Response calculateSchedule() {

//        try {
//            scheduleService.createSchedule();
//        } catch (Exception e) {
//            return Response.status(Response.Status.INTERNAL_SERVER_ERROR).build();
//        }

        scheduleService.createSchedule();

        return Response.ok().build();
    }

    @GET
    @Path("/all")
    @Produces(MediaType.APPLICATION_JSON)
    public Response getSchedule() {
        List<ScheduleDto> scheduleDtoList;

        try {
            scheduleDtoList = scheduleService.getSchedule();
        } catch (Exception e) {
            return Response.status(Response.Status.INTERNAL_SERVER_ERROR).build();
        }

        return Response.ok(scheduleDtoList).build();
    }

}
