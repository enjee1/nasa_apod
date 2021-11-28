package com.careerdevs.NASA_APOD.controllers;

import com.careerdevs.NASA_APOD.models.Apod;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.Environment;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

@RestController
public class ApodController {

    @Autowired
    private Environment env;
    private static final String NASA_URL = "https://api.nasa.gov/planetary/apod";

    @GetMapping("/")
    public String rootRoute() {
        return "Root route successful";
    }

    @GetMapping("/apod")
    public Apod apodInfo(RestTemplate restTemplate) {
        String tempUrl = NASA_URL + "?api_key=" + env.getProperty("nasa.token");

        Apod apod = restTemplate.getForObject(tempUrl, Apod.class);

        return apod;
    }
}
