package es.upm.oeg.stemming.web.domain;

/**
 * Created by cbadenes on 15/09/15.
 */

import lombok.Builder;
import lombok.Data;

import java.io.Serializable;

@Builder
@Data
public class Entity implements Serializable {

    private String name;

}
