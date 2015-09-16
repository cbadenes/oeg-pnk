package es.upm.oeg.stemming.web.service;

import es.upm.oeg.stemming.web.domain.Request;
import es.upm.oeg.stemming.web.domain.Synonym;
import lombok.Setter;
import org.apache.spark.mllib.feature.Word2VecModel;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import scala.Tuple2;

import javax.annotation.PostConstruct;
import java.util.ArrayList;
import java.util.List;

@Component
public class RelationalService {


    @Setter
    @Autowired
    SparkService sparkService;

    private Word2VecModel optModel;

    private Word2VecModel entModel;

    public RelationalService(){

    }

    @PostConstruct
    public void init() {

//        this.optModel = Word2VecModel.load(sparkService.getSc().sc(), "model/w2v/optimized");

        this.entModel = Word2VecModel.load(sparkService.getSc().sc(), "model/w2v/entities");
    }


    public List<Synonym> findSynonyms(Request request){

        Tuple2<String, Object>[] result = entModel.findSynonyms(request.getWord(), request.getNum());

        List<Synonym> synonyms = new ArrayList<>();

        if (result != null){
            for (int i=0;i < result.length; i++){
                Tuple2<String, Object> tuple = result[i];
                Synonym synonym = new Synonym();
                synonym.setWord(tuple._1());
                synonym.setRate((Double) tuple._2());
                synonyms.add(synonym);
            }
        }

        return synonyms;

    }



}
