package es.upm.oeg.stemming.web;

import es.upm.oeg.stemming.web.domain.Request;
import es.upm.oeg.stemming.web.domain.Synonym;
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
public class SynonymTest {

    RelationalService service;

    SparkService sparkService;

    @Before
    public void setup(){
        sparkService = new SparkService();

        service = new RelationalService();
        service.setSparkService(sparkService);
        service.init();
    }

    @After
    public void shutdown(){
        sparkService.getSc().stop();
    }


    @Test
    public void singleWord() throws IOException {

        Request request = new Request();
        request.setWord("Madrid");
        request.setNum(10);

        List<Synonym> synonyms = service.findSynonyms(request);

        System.out.println(synonyms);

        Assert.assertTrue("Number of synonyms", synonyms.size() > 0);


    }

}
