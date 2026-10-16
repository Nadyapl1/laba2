
package com.example.demo.service;

import com.example.demo.model.CommercialOffer;
import com.example.demo.repository.CommercialOfferRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class CommercialOfferService {

    private final CommercialOfferRepository repository;

    public CommercialOfferService(CommercialOfferRepository repository) {
        this.repository = repository;
    }

    public List<CommercialOffer> findAll() {
        return repository.findAll();
    }

    public Optional<CommercialOffer> findById(Long id) {
        return repository.findById(id);
    }

    public CommercialOffer save(CommercialOffer offer) {
        return repository.save(offer);
    }

    public void deleteById(Long id) {
        repository.deleteById(id);
    }
}
