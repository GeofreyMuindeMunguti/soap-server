package com.soap.tutorial;

import localhost.universities.University;
import org.springframework.stereotype.Component;


import javax.annotation.PostConstruct;
import java.util.HashMap;
import java.util.Map;

@Component
class UniversitiesRepository {

    private Map<String, University> university = new HashMap<>();

    @PostConstruct
    private void loadData(){

      University strath = new University();
      strath.setName("Strathmore");
      strath.setLocation("Nairobi");
      strath.setType("Private");
      strath.setYearfounded("09 1990");

      university.put(strath.getName(), strath);
    }

    public  University getUniversityByName(String name){
        return university.get(name);
    }

}
