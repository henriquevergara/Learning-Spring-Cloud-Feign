package br.com.spring.feign.integration;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@FeignClient(name = "country-find",url = "https://restcountries.eu/rest/v2/")
public interface CountryService {
        @GetMapping("name/{country}")
        ResponseEntity<String> getCountry(@PathVariable String country);
}
