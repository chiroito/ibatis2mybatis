package org.example;

import jakarta.inject.Inject;
import jakarta.ws.rs.GET;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.Produces;
import jakarta.ws.rs.core.MediaType;
import org.apache.ibatis.session.SqlSession;

import java.util.List;

@Path("/hello")
public class HelloResource {

    @Inject
    SqlSession sqlSession;

    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public List<SampleEntity> hello() {
        return sqlSession.selectList("findList");
    }
}