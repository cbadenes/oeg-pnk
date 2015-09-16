package es.upm.oeg.stemming.web.route;

import es.upm.oeg.stemming.web.domain.Entity;
import es.upm.oeg.stemming.web.domain.Request;
import es.upm.oeg.stemming.web.domain.Synonym;
import org.apache.camel.builder.RouteBuilder;
import org.apache.camel.model.rest.RestBindingMode;
import org.springframework.stereotype.Component;


@Component
public class RelationalRouteBuilder extends RouteBuilder{

    @Override
    public void configure() throws Exception {

        restConfiguration()
                .component("servlet")
                .bindingMode(RestBindingMode.json_xml)
                .dataFormatProperty("prettyPrint", "true")
                .dataFormatProperty("json.in.disableFeatures", "FAIL_ON_UNKNOWN_PROPERTIES,ADJUST_DATES_TO_CONTEXT_TIME_ZONE")
                .dataFormatProperty("xml.out.mustBeJAXBElement", "false")
                .contextPath("pnk/rest")
                .port(8080);

//        rest("/stemmers").description("Stemmer rest service")
//                //.consumes("application/json").produces("application/json")
//
//                .get("/").description("List all stemmers").outTypeList(Stemmer.class)
//                .to("bean:stemmerService?method=listStemmers")
//
//                .get("/{id}").description("Find a stemmer by id").outType(Stemmer.class)
//                //.param().name("id").type(path).description("The id of the user to get").dataType("int").endParam()
//                .to("bean:stemmerService?method=getStemmer(${header.id})");

        rest("/people").description("People in the content")
                //.consumes("application/json").produces("application/json")

                .get("/").description("List all people").outTypeList(Entity.class)
                .to("bean:entityService?method=listPeople")

                .get("/{name}").description("Related people").outTypeList(Synonym.class)
                //.param().name("id").type(path).description("The id of the user to get").dataType("int").endParam()
                .to("bean:entityService?method=getPeople(${header.name})");

        rest("/companies").description("Companies in the content")
                //.consumes("application/json").produces("application/json")

                .get("/").description("List all companies").outTypeList(Entity.class)
                .to("bean:entityService?method=listCompanies")

                .get("/{name}").description("Related companies").outTypeList(Synonym.class)
                //.param().name("id").type(path).description("The id of the user to get").dataType("int").endParam()
                .to("bean:entityService?method=getCompanies(${header.name})");

        rest("/places").description("Places in the content")
                //.consumes("application/json").produces("application/json")

                .get("/").description("List all places").outTypeList(Entity.class)
                .to("bean:entityService?method=listPlaces")

                .get("/{name}").description("Related places").outTypeList(Synonym.class)
                //.param().name("id").type(path).description("The id of the user to get").dataType("int").endParam()
                .to("bean:entityService?method=getPlaces(${header.name})");

        rest("/synonyms").description("Find synonyms")

                .post().type(Request.class).outTypeList(Synonym.class).description("Get related words")
                //.param().name("body").type(body).description("The document to be stemmed").endParam()
                .to("bean:relationalService?method=findSynonyms");
    }
}
