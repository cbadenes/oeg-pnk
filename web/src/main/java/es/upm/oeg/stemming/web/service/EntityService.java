package es.upm.oeg.stemming.web.service;

import es.upm.oeg.stemming.web.action.EntityReader;
import es.upm.oeg.stemming.web.domain.Entity;
import es.upm.oeg.stemming.web.domain.Request;
import es.upm.oeg.stemming.web.domain.Synonym;
import lombok.Setter;
import org.apache.spark.api.java.function.Function;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;
import java.io.Serializable;
import java.util.List;
import java.util.stream.Collectors;

@Component
public class EntityService  {

    @Setter
    @Autowired
    SparkService sparkService;

    @Setter
    @Autowired
    RelationalService relationalService;


    private List<Entity> companies;
    private List<Entity> people;
    private List<Entity> places;


    public EntityService(){

    }

    @PostConstruct
    public void init() {

        this.companies = EntityReader.load(sparkService.getSc(), "entities/empresas.txt");

        this.people = EntityReader.load(sparkService.getSc(), "entities/personas.txt");



        this.places = EntityReader.load(sparkService.getSc(), "entities/lugares.txt");

    }


    public List<Entity> listPeople(){
            return this.people;
    }

    public List<Synonym> getPeople(String name){
        return findRelations(name).stream().filter(u -> this.people.contains(Entity.builder().name(u.getWord()).build())).collect(Collectors.toList());
    }

    public List<Entity> listCompanies(){
        return this.companies;
    }

    public List<Synonym> getCompanies(String name){
        return findRelations(name).stream().filter(u -> this.companies.contains(Entity.builder().name(u.getWord()).build())).collect(Collectors.toList());
    }

    public List<Entity> listPlaces(){
        return this.places;
    }

    public List<Synonym> getPlaces(String name){
        return findRelations(name).stream().filter(u -> this.places.contains(Entity.builder().name(u.getWord()).build())).collect(Collectors.toList());
    }

    private List<Synonym> findRelations(String name){
        Request request = new Request();
        request.setWord(name);
        request.setNum(20);

        return relationalService.findSynonyms(request);
    }


}
