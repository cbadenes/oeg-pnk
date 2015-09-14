package es.upm.oeg.stemming.web;

import es.upm.oeg.stemming.web.domain.Synonym;
import es.upm.oeg.stemming.web.service.RelationalService;
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

    @Before
    public void setup(){
        service = new RelationalService();
    }


    @Test
    public void singleWord() throws IOException {

        List<Synonym> result = service.findSynonyms("mostoles", "10");

        Assert.assertTrue("Number of synonyms", result.size() > 0);


    }

}
