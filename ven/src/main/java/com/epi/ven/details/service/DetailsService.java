package com.epi.ven.details.service;

import com.epi.ven.details.model.DetailsData;
import com.epi.ven.details.repository.DetailsRepo;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class DetailsService {
    private final DetailsRepo detailsRepo;

    public DetailsService(DetailsRepo detailsRepo) {
        this.detailsRepo = detailsRepo;
    }

    public List<DetailsData> getDetailsData(){
        return detailsRepo.findAll();
    }

    public DetailsData getDetailsById(Integer id){
        return detailsRepo.findById(id).get();
    }
    public DetailsData updateDetails(Integer id,DetailsData detailsData){
        DetailsData existingDetails = detailsRepo.findById(id).get();
        existingDetails.setName(detailsData.getName());
        existingDetails.setEmail(detailsData.getEmail());
        existingDetails.setCity(detailsData.getCity());
        existingDetails.setAge(detailsData.getAge());

        return detailsRepo.save(existingDetails);
    }
}
