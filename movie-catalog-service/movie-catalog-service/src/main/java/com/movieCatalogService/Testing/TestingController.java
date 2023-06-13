package com.movieCatalogService.Testing;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.core.env.Environment;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/testing")
public class TestingController {

    @Value("${greeting}")
    private String greetingMessage;

    @Value("this is a default message")
    private String staticMessage;

    @Value("${default.value : this is a default value}")
    private String defaultValue;

    @Value("${list.values}")
    private List<String> listOfUser;

    @Value("#{${dbValues}}")
    private Map<String, String> dbValues;

    @Autowired
    private DbSettings dbSettings;

    @Autowired
    private Environment env;

    @RequestMapping("/home")
    public String greeting(){
        return greetingMessage;
    }

    @RequestMapping("/static")
    public String getStaticMessage(){
        return staticMessage;
    }

    @RequestMapping("/default")
    public String getDefaultValue(){
        return defaultValue;
    }



    @RequestMapping("/list")
    public List<String> getListOfUser(){

        return listOfUser;
    }
    @RequestMapping("/map")
    public String getMapValue(){
        return dbValues.toString();
    }

    @RequestMapping("/getValues")
    public String getDbValues(){
        return (dbSettings.getConnection() + "\n "+ dbSettings.getHost() + "\n "+ dbSettings.getPort());
    }

    @RequestMapping("/envDetails")
    public String getEnvironmentDetail(){

        return env.toString();
    }
}
