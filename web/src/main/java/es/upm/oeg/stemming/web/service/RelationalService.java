package es.upm.oeg.stemming.web.service;

import es.upm.oeg.pnk.Query;
import es.upm.oeg.stemming.web.domain.Synonym;
import org.apache.spark.mllib.feature.Word2VecModel;
import org.springframework.stereotype.Component;
import scala.Tuple2;
import scala.collection.JavaConversions;
import scala.collection.JavaConverters;


import java.util.ArrayList;
import java.util.List;

@Component
public class RelationalService {




    public RelationalService(){

    }

    public List<Synonym> findSynonyms(String word, String num){

        Word2VecModel model = Query.w2vModelOpt();

        Tuple2<String, Object>[] result = model.findSynonyms(word, Integer.valueOf(num));

        System.out.println(result);

        return null;

    }



}
