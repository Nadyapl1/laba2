
package com.example.laba1.repository;

import com.example.laba1.model.CommercialOffer;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.concurrent.atomic.AtomicLong;

@Repository
public class CommercialOfferRepository {
    private final List<CommercialOffer> offers = new ArrayList<>();
    private final AtomicLong counter = new AtomicLong(0);

    public List<CommercialOffer> findAll() {
        return new ArrayList<>(offers);
    }

    public Optional<CommercialOffer> findById(Long id) {
        return offers.stream()
                .filter(item -> item.getId().equals(id))
                .findFirst();
    }

    public CommercialOffer save(CommercialOffer offer) {
        if (offer.getId() == null) {
            offer.setId(counter.incrementAndGet());
            offers.add(offer);
        } else {
            deleteById(offer.getId());
            offers.add(offer);
        }
        return offer;
    }

    public boolean deleteById(Long id) {
        return offers.removeIf(item -> item.getId().equals(id));
    }

    public boolean existsById(Long id) {
        return findById(id).isPresent();
    }
}
