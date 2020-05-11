package com.learn.external.settings.demo.resource;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.learn.external.settings.demo.config.DbSettings;

@RestController
public class ConfigurationController {

	@Autowired
	private DbSettings dbSettings;
	
	@Value("${my.country}")
    private String country;
	
	@Value("${list.of.states}")
	private List<String> stateList;
    
	@Value("#{${electionRule}}")//#{} does the trick.
	private Map<String,String> electionRules;
	
	
    @RequestMapping("/country")
    public String country() {
        return "I am from country :"+ country;
    }
    
    @RequestMapping("/statelist")
	public List<String> stateList(){
    	return this.stateList;
    }
    
    @RequestMapping("/electionrules")
	public Map<String, String> electionRules(){
    	return this.electionRules;
    }
    
    @RequestMapping("/dbsettings")
	public String dbSettings(){
    	System.out.println(dbSettings.getConnectionString());
    	return "dbsettings";
    }
}
