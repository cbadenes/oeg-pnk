package es.upm.oeg.stemming.web.domain;


import lombok.Data;

import java.io.Serializable;

@Data
public class Synonym implements Serializable{

    private String word;

    private Double rate;

}
