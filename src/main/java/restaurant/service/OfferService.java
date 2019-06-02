package restaurant.service;

import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;
import restaurant.model.OfferItem;
import restaurant.repository.OfferItemRepository;

import java.time.LocalDateTime;
import java.util.List;

import static org.springframework.http.HttpStatus.BAD_REQUEST;

@Service
@Component("OfferService")
public class OfferService {
    @Autowired
    private OfferItemRepository offerRepository;

    public List<OfferItem> getAll() {

        return offerRepository.findAll();
    }

    public OfferItem findOne(Long id) {
        OfferItem offer = offerRepository.findById(id)
                .orElseThrow(this::badRequest);
        //List<Lease> leases = leaseRepository.findByCar(car);
        //car.setLeases(leases);
        return offer;
    }

    public OfferItem save(OfferItem offer) {

        return offerRepository.save(offer);
    }

    public OfferItem update(OfferItem offer, Long id) {
        OfferItem dbOffer = findOne(id);
        dbOffer.setOfferName(offer.getOfferName());
        dbOffer.setFoodItems(offer.getFoodItems());
        dbOffer.setOfferPrice(offer.getOfferPrice());
        return offerRepository.save(dbOffer);
    }

    public void delete(Long id) {
        OfferItem dbOffer = findOne(id);
        offerRepository.delete(dbOffer);
    }
    private ResponseStatusException badRequest() {
        return new ResponseStatusException(BAD_REQUEST, "id doesnt exist");
    }
}
