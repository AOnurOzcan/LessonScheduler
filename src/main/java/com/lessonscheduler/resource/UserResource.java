package com.lessonscheduler.resource;

import com.lessonscheduler.dto.UserDto;
import com.lessonscheduler.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import javax.annotation.Resource;
import javax.persistence.NoResultException;
import javax.print.attribute.standard.Media;
import javax.servlet.http.HttpSession;
import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

/**
 * Created by Onur on 4.4.2017.
 */

@Component
@Path("/user")
public class UserResource {

    @Autowired
    UserService userService;

    @POST
    @Path("/register")
    @Produces("text/plain")
    public Response registerUser(UserDto userDto) {

        try {
            userService.registerUser(userDto);
        } catch (Exception e) {
            return Response.status(Response.Status.INTERNAL_SERVER_ERROR).entity(e.getMessage()).build();
        }

        return Response.ok("Kayıt Başarılı").build();
    }

    @GET
    @Path("/authentication")
    @Produces(MediaType.APPLICATION_JSON)
    public Response checkAuthentication() {

        UserDto userDto;

        try {
            userDto = userService.checkAuthentication();

            if (userDto == null) {
                return Response.status(Response.Status.UNAUTHORIZED).build();
            }

        } catch (Exception e) {
            return Response.status(Response.Status.INTERNAL_SERVER_ERROR).entity(e.getMessage()).build();
        }

        return Response.ok(userDto).build();
    }

    @POST
    @Path("/login")
    @Consumes(MediaType.APPLICATION_JSON)
    public Response login(UserDto userDto) {

        try {
            userDto = userService.login(userDto);

        } catch (NoResultException e) { //Kullanıcı adı ya da şifre yanlış
            return Response.status(Response.Status.UNAUTHORIZED).build();
        } catch (Exception e) { //Beklenmedik bir hata oluştu
            return Response.status(Response.Status.INTERNAL_SERVER_ERROR).build();
        }

        return Response.ok(userDto).build(); //Giriş başarılı
    }

    @GET
    @Path("/logout")
    public Response logout() {

        try {
            userService.invalidateSession();
        } catch (Exception e) {
            return Response.status(Response.Status.INTERNAL_SERVER_ERROR).build();
        }

        return Response.ok().build();
    }

}
