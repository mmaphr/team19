package com.se.team19.server.Controller;

import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.se.team19.server.Entity.BookAPlace;
import com.se.team19.server.Entity.OutActivity;
import com.se.team19.server.Entity.PlaceTy;
import com.se.team19.server.Entity.Staff;
import com.se.team19.server.Repository.BookAPlaceRopository;
import com.se.team19.server.Repository.OutActivityRepository;
import com.se.team19.server.Repository.PlaceTyRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.net.URLDecoder;
import java.util.Collection;
import java.util.stream.Collectors;
@RestController
@CrossOrigin(origins = "http://localhost:4200")
public class BookAPlaceController {
    @Autowired
    private OutActivityRepository outActivityRepository;
    @Autowired
    private BookAPlaceRopository bookAPlaceRopository;
    @Autowired
    private PlaceTyRepository placeTyRepository;

    @Autowired
    public BookAPlaceController(OutActivityRepository outActivityRepository, BookAPlaceRopository bookAPlaceRopository, PlaceTyRepository placeTyRepository) {
        this.outActivityRepository = outActivityRepository;
        this.bookAPlaceRopository = bookAPlaceRopository;
        this.placeTyRepository = placeTyRepository;
    }
    @GetMapping("/BookAPlace")
    public Collection<BookAPlace> getBookAPlace() {
        return bookAPlaceRopository.findAll().stream().collect(Collectors.toList());
    }
    @GetMapping("/out/{outactivityid}")
    public OutActivity getOutActivity(@PathVariable long outactivityid ) {
        return outActivityRepository.findById(outactivityid);
    }


    @PostMapping(path ="/bookaplace/{place_id}/{outa}")
    public BookAPlace  postBookAPlace(
                                        @PathVariable Long place_id,
                                      @PathVariable Long outa,@RequestBody String dataBookAPlace
    )throws Exception {


        final String decoded = URLDecoder.decode(dataBookAPlace, "UTF-8");
        dataBookAPlace = decoded;

        BookAPlace newBook = new BookAPlace();

        if (dataBookAPlace.charAt(0) == '{') {
            ObjectMapper mapper = new ObjectMapper();
            JsonNode actualObj = mapper.readTree(dataBookAPlace);

            newBook.setCardid(actualObj.get("cardid").textValue());
            newBook.setNameCaretaker(actualObj.get("nameCaretaker").textValue());
            newBook.setPhonCaretaker(actualObj.get("phonCaretaker").textValue());
            newBook.setNamePlace(actualObj.get("namePlace").textValue());
            newBook.setDescriptionPlace(actualObj.get("descriptionPlace").textValue());
        }


        newBook.setPlaceTy(placeTyRepository.findById(place_id).get());
        newBook.setOutActivity(outActivityRepository.findById(outa).get());

        return bookAPlaceRopository.save(newBook);
    }
}
