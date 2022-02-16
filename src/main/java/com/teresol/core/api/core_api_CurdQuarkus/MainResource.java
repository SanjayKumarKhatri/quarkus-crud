package com.teresol.core.api.core_api_CurdQuarkus;

import javax.inject.Inject;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import com.teresol.core.api.core_api_CurdQuarkus.connection.DBConnection;

@Path("/api")
public class MainResource {

    @Inject
    DBConnection dbConnection;

    @GET
    @Produces(MediaType.TEXT_PLAIN)
    public String hello() {
            dbConnection.GlobalDbConnection();
        return "Hello RESTEasy";
    }
}