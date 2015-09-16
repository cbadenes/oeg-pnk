package es.upm.oeg.stemming.web;

import es.upm.oeg.stemming.web.domain.Entity;
import es.upm.oeg.stemming.web.domain.Request;
import es.upm.oeg.stemming.web.domain.Synonym;
import es.upm.oeg.stemming.web.service.EntityService;
import es.upm.oeg.stemming.web.service.RelationalService;
import es.upm.oeg.stemming.web.service.SparkService;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import java.io.IOException;
import java.util.List;

/**
 * Created by cbadenes on 09/07/15.
 */
public class EntityTest {

    EntityService service;
    SparkService sparkService;

    @Before
    public void setup(){
        sparkService = new SparkService();

        RelationalService relationalService = new RelationalService();
        relationalService.setSparkService(sparkService);
        relationalService.init();

        service = new EntityService();
        service.setSparkService(sparkService);
        service.setRelationalService(relationalService);
        service.init();
    }

    @After
    public void shutdown(){
        sparkService.getSc().stop();
    }


    @Test
    public void listPeople() throws IOException {

        List<Entity> response = service.listPeople();

        System.out.println(response);

        Assert.assertTrue("Number of people", response.size() > 0);
    }


    @Test
    public void getPeople() throws IOException {

        List<Synonym> response = service.getPeople("David");

        System.out.println(response);

        Assert.assertTrue("Number of people", response.size() > 0);
    }


}
