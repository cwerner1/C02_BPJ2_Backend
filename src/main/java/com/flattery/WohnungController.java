package com.flattery;

import com.fasterxml.jackson.databind.JsonNode;
import com.flattery.mapper.WohnungMapper;
import com.flattery.models.Wohnung;
import com.flattery.repositories.WohnungRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.io.IOException;
import java.math.BigDecimal;
import java.math.RoundingMode;
import java.time.LocalDateTime;
import java.util.*;

@RestController    // This means that this class is a Controller
@RequestMapping(path = "/wohnung") // This means URL's start with /demo (after Application path)
@CrossOrigin(origins = "http://localhost:8080")

public class WohnungController extends BaseController {
    // Which is auto-generated by Spring, we will use it to handle the data
    @Autowired
    WohnungRepository wohnungRepository;

    private static final String TOTAL_NAME = "GESAMT";

    public WohnungController(WohnungRepository wohnungRepository2) {
        this.wohnungRepository = wohnungRepository2;
    }

    // TODO @Peter Demo Objekte Befüllen

    // Url: "/wohnung/demoadd"
    @GetMapping(path = "/demoadd") // Map ONLY GET Requests
    public @ResponseBody
    String addNewWohnungDemo() {
        Wohnung n = new Wohnung();
        n.setAddress("Grazbachgasse 20");
        n.setCity("Graz");
        n.setCountry("Steiermark");
        n.setRent(406);
        n.setSurfaceArea(40);
        n.setAddedAt(LocalDateTime.now());
        n.setRoomCount(2);
        n.setDescription("Geförderte Innenstadt Wohnung zum Bestpreis Privat");
        n.setPostalCode("8010");
        n.setUserID(1);
        wohnungRepository.save(n);

        n = new Wohnung();
        n.setAddress("Degengasse 49");
        n.setCity("Wien");
        n.setCountry("Wien");
        n.setRent(750);
        n.setSurfaceArea(44);
        n.setAddedAt(LocalDateTime.now());
        n.setRoomCount(2);
        n.setDescription("Sehr ruhige 2 Zimmerwohnung mit hofseitigem Balkon");
        n.setPostalCode("1160");
        n.setUserID(3);
        wohnungRepository.save(n);

        n = new Wohnung();
        n.setAddress("Ulmgasse 102");
        n.setCity("Wien");
        n.setCountry("Wien");
        n.setRent(1190);
        n.setSurfaceArea(76);
        n.setAddedAt(LocalDateTime.now());
        n.setRoomCount(3);
        n.setDescription("Traumdomizil mit privaten Pool und Terrasse! Erstbezug!");
        n.setPostalCode("1100");
        n.setUserID(3);
        wohnungRepository.save(n);

      n = new Wohnung();
        n.setAddress("Naglergasse 23");
        n.setCity("Graz");
        n.setCountry("Steiermark");
        n.setRent(730);
        n.setSurfaceArea(84);
        n.setAddedAt(LocalDateTime.now());
        n.setRoomCount(2);
        n.setDescription("Schöne 2- Zimmerwohnung im Herz Jesu Viertl");
        n.setPostalCode("8010");
        n.setUserID(2);
        wohnungRepository.save(n);

        n = new Wohnung();
        n.setAddress("Robertgasse 70");
        n.setCity("Wien");
        n.setCountry("Wien");
        n.setRent(895);
        n.setSurfaceArea(56);
        n.setAddedAt(LocalDateTime.now());
        n.setRoomCount(2);
        n.setDescription("Gemütliche 2-Zimmer Wohnung");
        n.setPostalCode("1020");
        n.setUserID(4);
        wohnungRepository.save(n);

        n = new Wohnung();
        n.setAddress("Elisabethstraße 12");
        n.setCity("Graz");
        n.setCountry("Steiermark");
        n.setRent(895);
        n.setSurfaceArea(100);
        n.setAddedAt(LocalDateTime.now());
        n.setRoomCount(3);
        n.setDescription("Helle und geräumige 3-Zimmerwohnung!");
        n.setPostalCode("8010");
        n.setUserID(1);
        wohnungRepository.save(n);

        n = new Wohnung();
        n.setAddress("Olivierstraße 6a");
        n.setCity("Salzburg");
        n.setCountry("Salzburg");
        n.setRent(994);
        n.setSurfaceArea(53);
        n.setAddedAt(LocalDateTime.now());
        n.setRoomCount(2);
        n.setDescription("Schicke 2-Zi. -Wohnung mit Südbalkon!");
        n.setPostalCode("5020");
        n.setUserID(7);
        wohnungRepository.save(n);

        n = new Wohnung();
        n.setAddress("Kanitzgasse 12");
        n.setCity("Wien");
        n.setCountry("Wien");
        n.setRent(500);
        n.setSurfaceArea(35);
        n.setAddedAt(LocalDateTime.now());
        n.setRoomCount(1);
        n.setDescription("Wohnen im Zentrum - Apartment zum Wohlfühlen");
        n.setPostalCode("1230");
        n.setUserID(1);
        wohnungRepository.save(n);

        n = new Wohnung();
        n.setAddress("Liefering 16");
        n.setCity("Salzburg");
        n.setCountry("Salzburg");
        n.setRent(960);
        n.setSurfaceArea(54);
        n.setAddedAt(LocalDateTime.now());
        n.setRoomCount(2);
        n.setDescription("Neubau! Exquisite 2-Zimmer-Wohnung mit Sonnenbalkon und Blick ins Grüne");
        n.setPostalCode("5020");
        n.setUserID(6);
        wohnungRepository.save(n);

        n = new Wohnung();
        n.setAddress("Kallerweg 5");
        n.setCity("Wien");
        n.setCountry("Wien");
        n.setRent(650);
        n.setSurfaceArea(48);
        n.setAddedAt(LocalDateTime.now());
        n.setRoomCount(2);
        n.setDescription("Ruhige und helle Wohnung direkt beim Floridsdorfer Spitz!");
        n.setPostalCode("1210");
        n.setUserID(5);
        wohnungRepository.save(n);

        n = new Wohnung();
        n.setAddress("Mozartgasse 23");
        n.setCity("Salzburg");
        n.setCountry("Salzburg");
        n.setRent(550);
        n.setSurfaceArea(24);
        n.setAddedAt(LocalDateTime.now());
        n.setRoomCount(1);
        n.setDescription("Salzburg-Herrnau: Sonnige Garconniere in Toplage");
        n.setPostalCode("5020");
        n.setUserID(6);
        wohnungRepository.save(n);

        n = new Wohnung();
        n.setAddress("Schillerplatz 7");
        n.setCity("Graz");
        n.setCountry("Steiermark");
        n.setRent(985);
        n.setSurfaceArea(79);
        n.setAddedAt(LocalDateTime.now());
        n.setRoomCount(3);
        n.setDescription("Perfekte 3-Zimmer Studenten WG-Wohnung am Schillerplatz");
        n.setPostalCode("8010");
        n.setUserID(8);
        wohnungRepository.save(n);

        n = new Wohnung();
        n.setAddress("Bacherstraße 90");
        n.setCity("Graz");
        n.setCountry("Steiermark");
        n.setRent(744);
        n.setSurfaceArea(87);
        n.setAddedAt(LocalDateTime.now());
        n.setRoomCount(4);
        n.setDescription("Graz - ÖWG Wohnbau - geförderte Miete mit Kaufoption - 4 Zimmer");
        n.setPostalCode("8010");
        n.setUserID(8);
        wohnungRepository.save(n);

        n = new Wohnung();
        n.setAddress("Zinzendorfgasse 34");
        n.setCity("Graz");
        n.setCountry("Steiermark");
        n.setRent(690);
        n.setSurfaceArea(90);
        n.setAddedAt(LocalDateTime.now());
        n.setRoomCount(2);
        n.setDescription("Wohnung am Shared Space UNI- Nähe");
        n.setPostalCode("8010");
        n.setUserID(9);
        wohnungRepository.save(n);

        n = new Wohnung();
        n.setAddress("Harrerweg 17");
        n.setCity("Graz");
        n.setCountry("Steiermark");
        n.setRent(1050);
        n.setSurfaceArea(108);
        n.setAddedAt(LocalDateTime.now());
        n.setRoomCount(3);
        n.setDescription("3 Zimmer Wohnung mit Balkon in Ruhelage - Rosenberg / Mariagrün");
        n.setPostalCode("8043");
        n.setUserID(10);
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

            if (n.getAddedAt() == null) {
                n.setAddedAt(LocalDateTime.now());
            }

            if (n.getRent() <= 0) {
                return getError("Die Gesamtmiete muss eine positive Zahl sein.");
            }

            if (n.getSurfaceArea() <= 0.0) {
                return getError("Die Wohnfläche muss eine positive Zahl sein.");
            }

            if (n.getRoomCount() <= 0) {
                return getError("Die Raumanzahl muss eine positive Zahl sein.");
            }

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
            if (!_isReceived(a,"id")) {
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
                if (a.get("surfaceArea").asDouble() <= 0.0) {
                    return getError("Die Wohnfläche muss eine positive Zahl sein.");
                }
                wohnung.setSurfaceArea(a.get("surfaceArea").asDouble());
            }

            if (_isReceived(a,"roomCount")) {
                if (a.get("roomCount").asInt() <= 0) {
                    return getError("Die Raumanzahl muss eine positive Zahl sein.");
                }
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
                if (a.get("rent").asInt() <= 0) {
                    return getError("Die Gesamtmiete muss eine positive Zahl sein.");
                }
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

            if (!_isReceived(a, "wohnungID")) {
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
            if (_isReceived(a, "city")) {
                city = a.get("city").asText();
            }

        } catch (IOException e) {
            return getError();
        }

        List<Map> data = new ArrayList<>();
        List<Wohnung> wohnungs = new ArrayList<>();

        if (city != null) {
            wohnungs = wohnungRepository.findAllByCityStartingWith(city);
        } else {
            Iterable<Wohnung> iterable = wohnungRepository.findAll();
            iterable.forEach(wohnungs::add);
        }

        if (wohnungs.isEmpty()) {
            setData(data);
            return getResponse();
        }

        Map<String, Map> averageByCity = new TreeMap<>();
        for (Wohnung w : wohnungs) {
            double surfaceArea = w.getSurfaceArea();
            double rent = w.getRent();
            double rentSqM = rent / surfaceArea;
            String currentCity = w.getCity();

            if (!averageByCity.containsKey(currentCity)) {
                Map<String, Double> values = new HashMap<>();
                values.put("totalRent", 0.0);
                values.put("totalRentSqM", 0.0);
                values.put("count", 0.0);
                averageByCity.put(currentCity, values);
            }

            if (!averageByCity.containsKey(TOTAL_NAME)) {
                Map<String, Double> values = new HashMap<>();
                values.put("totalRent", 0.0);
                values.put("totalRentSqM", 0.0);
                values.put("count", 0.0);
                averageByCity.put(TOTAL_NAME, values);
            }

            Map<String, Double> values = averageByCity.get(currentCity);
            values.put("totalRent", values.get("totalRent") + rent);
            values.put("totalRentSqM", values.get("totalRentSqM") + rentSqM);
            values.put("count", values.get("count") + 1.0);
            averageByCity.put(currentCity, values);

            values = averageByCity.get(TOTAL_NAME);
            values.put("totalRent", values.get("totalRent") + rent);
            values.put("totalRentSqM", values.get("totalRentSqM") + rentSqM);
            values.put("count", values.get("count") + 1.0);
            averageByCity.put(TOTAL_NAME, values);
        }

        Map<String, Object> objTotal = new HashMap<>();
        for (String c : averageByCity.keySet()) {
            Map<String, Double> values = averageByCity.get(c);
            // values.put("average", _round(values.get("totalRent") / values.get("count"), 2));
            // values.put("averageSqM", _round(values.get("totalRentSqM") / values.get("count"), 2));
            // values.remove("totalRent");
            // values.remove("totalRentSqM");
            // values.remove("count");
            // averageByCity.put(c, values);

            if (c.equals(TOTAL_NAME)) {
                objTotal.put("cityName", c);
                objTotal.put("average", _round(values.get("totalRent") / values.get("count"), 2));
                objTotal.put("averageSqM", _round(values.get("totalRentSqM") / values.get("count"), 2));
                continue;
            }
            Map<String, Object> objReturn = new HashMap<>();
            objReturn.put("cityName", c);
            objReturn.put("average", _round(values.get("totalRent") / values.get("count"), 2));
            objReturn.put("averageSqM", _round(values.get("totalRentSqM") / values.get("count"), 2));
            data.add(objReturn);
        }
        if (data.size() > 1) {
            data.add(objTotal);
        }

        // setData(averageByCity);
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

    private static double _round(double value, int precision) {

        return new BigDecimal(value).setScale(precision, RoundingMode.HALF_EVEN).doubleValue();
    }
}
