package com.flattery;

import com.fasterxml.jackson.databind.JsonNode;
import com.flattery.mapper.WohnungMapper;
import com.flattery.models.Wohnung;
import com.flattery.repositories.WohnungRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.io.IOException;
import java.time.LocalDateTime;
import java.util.*;

@RestController    // This means that this class is a Controller
@RequestMapping(path = "/wohnung") // This means URL's start with /demo (after Application path)
@CrossOrigin(origins = "http://localhost:8080")

public class WohnungController extends BaseController {
    // Which is auto-generated by Spring, we will use it to handle the data
    @Autowired
    WohnungRepository wohnungRepository;

    public WohnungController(WohnungRepository wohnungRepository2) {
        this.wohnungRepository = wohnungRepository2;
    }

    // TODO: Remove me later.
    @GetMapping(path = "/demoadd") // Map ONLY GET Requests
    public @ResponseBody
    String addNewWohnungDemo() {
        Wohnung n = new Wohnung();
        n.setAddress("Tannenstrasse 12");
        n.setCity("Obiberg");
        n.setCountry("Steiermark");
        n.setRent(500);
        n.setSurfaceArea(42);
        n.setAddedAt(LocalDateTime.now());
        n.setRoomCount(1);
        n.setDescription("Eine schöne Altbauwohnung mit Loggia");
        n.setPostalCode("8888");
        n.setUserID(1);
        wohnungRepository.save(n);

        Map<String, Integer> data = new HashMap<>();
        data.put("wohnungID", n.getId());
        setData(data);

        return getResponse();
    }

    @PostMapping(path = "/add")
    public @ResponseBody
    String addNewWohnung(@RequestBody String payload) {
        // @ResponseBody means the returned String is the response, not a view name
        // @RequestParam means it is a parameter from the GET or POST request

        try {
            Wohnung n = WohnungMapper.readJsonWithObjectMapper(payload);
            wohnungRepository.save(n);

            Map<String, Integer> data = new HashMap<>();
            data.put("wohnungID", n.getId());
            setData(data);

            return getResponse();

        } catch (IOException exc) {
            return getError();
        }
    }

    @PostMapping(path = "/update")
    public @ResponseBody
    String updateWohnung(@RequestBody String payload) {

        try {
            JsonNode a = _JSONParse(payload);
            if (!a.has("id") || a.get("id").asText().equals("null")) {
                return getError("Received no id.");
            }

            int wohnungID = a.get("id").asInt();
            Optional<Wohnung> wohnungOptional = wohnungRepository.findById(wohnungID);
            if (!wohnungOptional.isPresent()) {
                return getError("Diese Wohnung existiert nicht.");
            }
            Wohnung wohnung = wohnungOptional.get();

            if (_isReceived(a,"description")) {
                wohnung.setDescription(a.get("description").asText());
            }

            if (_isReceived(a,"surfaceArea")) {
                wohnung.setSurfaceArea(a.get("surfaceArea").asDouble());
            }

            if (_isReceived(a,"roomCount")) {
                wohnung.setRoomCount(a.get("roomCount").asInt());
            }

            if (_isReceived(a,"address")) {
                wohnung.setAddress(a.get("address").asText());
            }

            if (_isReceived(a,"postalCode")) {
                wohnung.setPostalCode(a.get("postalCode").asText());
            }

            if (_isReceived(a,"country")) {
                wohnung.setCountry(a.get("country").asText());
            }

            if (_isReceived(a,"rent")) {
                wohnung.setRent(a.get("rent").asInt());
            }

            if (_isReceived(a,"city")) {
                wohnung.setCity(a.get("city").asText());
            }

            wohnungRepository.save(wohnung);

            Map<String, Integer> data = new HashMap<>();
            data.put("wohnungID", wohnungID);
            setData(data);

            return getResponse();

        } catch (IOException exc) {
            return getError();
        }
    }

    @PostMapping(path = "/remove")
    public @ResponseBody
    String removeWohnung(@RequestBody String payload) {

        try {
            JsonNode a = _JSONParse(payload);

            if (a.get("wohnungID").asText().equals("null")) {
                return getError("Received no wohnungID.");
            }

            int wohnungID = Integer.parseInt(a.get("wohnungID").asText());
            wohnungRepository.deleteById(wohnungID);

        } catch (Exception exc) {
            return getError("Die Wohnung konnte nicht gelöscht werden.");
        }

        return getResponse();
    }

    @GetMapping(path = "/all")
    public @ResponseBody
    String getAllWohnung() {

        Iterable<Wohnung> wohnungs = wohnungRepository.findAll();
        setData(wohnungs);

        return getResponse();
    }

    @GetMapping(path = "/get/{str_id}")
    public @ResponseBody
    String getWohnung(@PathVariable String str_id) {

        Integer id = Integer.parseInt(str_id);

        Optional<Wohnung> wohnungOptional = wohnungRepository.findById(id);
        if (!wohnungOptional.isPresent()) {

            return getError("Diese Wohnung existiert nicht.");
        }
        Wohnung wohnung = wohnungOptional.get();
        setData(wohnung);

        return getResponse();
    }

    @PostMapping(path = "/average")
    public @ResponseBody
    String getAverage(@RequestBody String payload) {

        String city = null;
        try {
            JsonNode a = _JSONParse(payload);
            city = a.get("city").asText();

            if (city.equals("null") || city.equals("undefined") || city.equals("")) {
                city = null;
            }

        } catch (IOException e) {
            return getError();
        }

        Map<String, Double> data = new HashMap<>();
        data.put("average", 0.0);
        data.put("averageSqM", 0.0);

        List<Wohnung> wohnungs = new ArrayList<>();

        if (city != null) {
            wohnungs = wohnungRepository.findAllByCity(city);
        } else {
            Iterable<Wohnung> iterable = wohnungRepository.findAll();
            iterable.forEach(wohnungs::add);
        }

        if (wohnungs.isEmpty()) {
            setData(data);
            return getResponse();
        }

        double totalRent = 0.0;
        double totalRentSqM = 0.0;
        int count = 0;
        for (Wohnung w : wohnungs) {
            double surfaceArea = w.getSurfaceArea();
            double rent = w.getRent();

            totalRent += rent;
            totalRentSqM += rent / surfaceArea;

            count++;
        }

        data.put("average", totalRent / count);
        data.put("averageSqM", totalRentSqM / count);
        setData(data);

        return getResponse();
    }

    @GetMapping(path = "/getByUserID/{str_id}")
    public @ResponseBody
    String getAllWohnungenByUserID(@PathVariable String str_id) {

        Integer id = Integer.parseInt(str_id);
        Iterable<Wohnung> wohnungs = wohnungRepository.findAllByUserID(id);

        setData(wohnungs);

        return getResponse();
    }

}
