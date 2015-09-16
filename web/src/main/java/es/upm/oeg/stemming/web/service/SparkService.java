package es.upm.oeg.stemming.web.service;

import lombok.Getter;
import org.apache.spark.SparkConf;
import org.apache.spark.api.java.JavaSparkContext;
import org.springframework.stereotype.Component;

import java.io.Serializable;

@Component
public class SparkService {

    @Getter
    private final JavaSparkContext sc;

    public SparkService(){

        SparkConf conf = new SparkConf().
                setMaster("local").
                setAppName("My App").
                set("spark.executor.memory", "100m").
                set("spark.driver.maxResultSize","0")
                ;
        this.sc = new JavaSparkContext(conf);


    }





}
