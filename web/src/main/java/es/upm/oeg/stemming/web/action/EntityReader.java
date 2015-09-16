package es.upm.oeg.stemming.web.action;

import es.upm.oeg.stemming.web.domain.Entity;
import org.apache.spark.api.java.JavaSparkContext;
import org.apache.spark.api.java.function.Function;

import java.io.Serializable;
import java.util.List;

/**
 * Created by cbadenes on 15/09/15.
 */
public class EntityReader implements Serializable{

    public static List<Entity> load(JavaSparkContext sc, String file){
        return sc.textFile(file).map(new Function<String, Entity>() {
            public Entity call(String x) {
                return Entity.builder().name(x).build();
            }
        }).collect();
    }

}
