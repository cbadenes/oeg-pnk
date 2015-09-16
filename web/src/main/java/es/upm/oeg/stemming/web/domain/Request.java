package es.upm.oeg.stemming.web.domain;

import lombok.Data;

import java.io.Serializable;

/**
 * Created by cbadenes on 14/09/15.
 */
@Data
public class Request implements Serializable{

    private String word;

    private Integer num;

}
