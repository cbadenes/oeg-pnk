package es.upm.oeg.stemming.web.service;

import lombok.Getter;
import org.apache.spark.SparkConf;
import org.apache.spark.SparkContext;
import org.springframework.stereotype.Component;

@Component
@Getter
public class SparkService {


    private final SparkConf sparkConf;

    private final SparkContext sc;

    public SparkService(){
        this.sparkConf = new SparkConf()
                .setMaster("local")
                .setAppName("Pnk Spark Example")
                .set("spark.executor.memory", "8g")
                .set("spark.driver.maxResultSize","2g");

        this.sc = new SparkContext(sparkConf);


    }

}
