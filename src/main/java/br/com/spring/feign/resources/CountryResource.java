package br.com.spring.feign.resources;

import br.com.spring.feign.integration.CountryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/country")
public class CountryResource {

    @Autowired
    private CountryService service;

    @GetMapping(produces = MediaType.APPLICATION_JSON_VALUE,path = "/{country}")
    public ResponseEntity<String> getCountry(@PathVariable String country){

        ResponseEntity<String> result = service.getCountry(country);
        String jsonObject = result.getBody().substring(1,result.getBody().length() - 1);

        return ResponseEntity.ok().body(jsonObject);
    }

}
