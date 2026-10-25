package com.epi.ven.details.controller;

import com.epi.ven.details.model.DetailsData;
import com.epi.ven.details.service.DetailsService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/details")
public class detailsController {
    private final DetailsService detailsService;
    public detailsController(DetailsService detailsService) {
        this.detailsService = detailsService;
    }
    @GetMapping("/users")
    public List<DetailsData> getDetailsById(){
        return detailsService.getDetailsData();
    }

    @GetMapping("/users/{id}")
    public DetailsData getDetailsById(@PathVariable Integer id){
        return detailsService.getDetailsById(id);
    }
    @PostMapping("/users/{id}")
    public DetailsData updateDetails(@PathVariable Integer id, @RequestBody DetailsData detailsData){
        return detailsService.updateDetails(id, detailsData);
    }
}
