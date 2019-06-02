package restaurant.controller;


import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import restaurant.Application;
import restaurant.model.OfferItem;
import restaurant.service.OfferService;

import java.util.List;

@RequestMapping("/offer")
@RestController
public class OfferController {
    @Autowired
    private OfferService offerService;

    @GetMapping
    public List<OfferItem> getAll() {
        logger.info("In offer controller");
        return offerService.getAll();
    }

    private static Logger logger = LoggerFactory.getLogger(Application.class);

    @GetMapping("{id}")
    public OfferItem findOne(@PathVariable Long id) {
        return offerService.findOne(id);
    }

    @PostMapping
    public OfferItem save(@RequestBody OfferItem offerItem) {

        return offerService.save(offerItem);
    }

    @PutMapping("{id}")
    public OfferItem update(@RequestBody OfferItem offerItem, @PathVariable Long id) {
        return offerService.update(offerItem, id);
    }

    @DeleteMapping("{id}")
    public void delete(@PathVariable Long offerItem) {
        offerService.delete(offerItem);
    }
}
