package com.flattery;

import com.fasterxml.jackson.databind.JsonNode;
import com.flattery.models.Favorite;
import com.flattery.models.Wohnung;
import com.flattery.repositories.FavoriteRepository;
import com.flattery.repositories.WohnungRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping(path = "/favorite")
@CrossOrigin(origins = "http://localhost:8100")
public class FavoriteController extends BaseController {
    // Which is auto-generated by Spring, we will use it to handle the data
    @Autowired
    FavoriteRepository favoriteRepository;
    @Autowired
    WohnungRepository wohnungRepository;


    public FavoriteController(FavoriteRepository favoriteRepository, WohnungRepository wohnungRepository2) {
        this.wohnungRepository = wohnungRepository2;
        this.favoriteRepository = favoriteRepository;
    }

    @PostMapping(path = "/add")
    public @ResponseBody
    String addFavorite(@RequestBody String payload) throws IOException {
        JsonNode a = this._JSONParse(payload);
        if (a.get("userID").asText().equals("null")) {
            return getError("Received no userID.");
        }
        if (a.get("wohnungID").asText().equals("null")) {
            return getError("Received no wohnungID.");
        }
        Integer userID = Integer.parseInt(a.get("userID").asText());
        Integer wohnungID = Integer.parseInt(a.get("wohnungID").asText());


        List<Favorite> l = favoriteRepository.findByUserIDAndWohnungID(userID, wohnungID);
        Integer fId = null;
        if (l.size() == 0) {
            Favorite favorite = new Favorite();
            favorite.setUserID(userID);
            favorite.setWohnungID(wohnungID);
            favoriteRepository.save(favorite);
            fId = favorite.getId();
        } else {
            fId = l.get(0).getId();

        }
        Map<String, Integer> data = new HashMap<>();
        data.put("favoriteID", fId);
        setData(data);
        return getResponse();
    }


    @PostMapping(path = "/remove")
    public String removeFavorite(@RequestBody String payload) throws IOException {
        JsonNode a = this._JSONParse(payload);
        Integer id = Integer.parseInt(a.get("favoriteId").asText());
        try {
            favoriteRepository.deleteById(id);

        } catch (IllegalArgumentException exc) {

            return getError(exc.getMessage());
        }

        return getResponse();
    }


    @PostMapping(path = "/removeByUserIDAndWohnungID")
    public String removeByUserIDAndWohnungID(@RequestBody String payload) throws IOException {
        JsonNode a = this._JSONParse(payload);
        if (a.get("userID").asText().equals("null")) {
            return getError("Received no userID.");
        }
        if (a.get("wohnungID").asText().equals("null")) {
            return getError("Received no wohnungID.");
        }
        Integer userID = Integer.parseInt(a.get("userID").asText());
        Integer favoriteID = Integer.parseInt(a.get("wohnungID").asText());
        try {
            List<Favorite> l = favoriteRepository.findByUserIDAndWohnungID(userID, favoriteID);
            favoriteRepository.deleteAll(l);


        } catch (IllegalArgumentException exc) {

            return getError(exc.getMessage());
        }

        return getResponse();
    }


    @GetMapping(path = "/clear")
    public @ResponseBody
    String clearFavorites() {
        favoriteRepository.deleteAll();
        return getResponse();
    }

    @PostMapping(path = "/getAllFavoriteWohnungByUserID")
    public String getAllFavoriteWohnungByUserID(@RequestBody String payload) throws IOException {
        JsonNode a = this._JSONParse(payload);
        if (a.get("userID").asText().equals("null")) {
            return getError("Received no userID.");
        }
        Integer UserID = Integer.parseInt(a.get("userID").asText());
        List<Favorite> l = favoriteRepository.findByUserID(UserID);

        List<Integer> idList = new ArrayList<>();
        for (Favorite favorite : l) {
            idList.add(favorite.getWohnungID());
        }
        List<Wohnung> WohnungListe = wohnungRepository.findByIdIn(idList);
        setData(WohnungListe);
        return getResponse();
    }

    @PostMapping(path = "/getAllFavoriteByUserId")
    public String getAllFavoriteByUserID(@RequestBody String payload) throws IOException {
        JsonNode a = this._JSONParse(payload);
        if (a.get("userID").asText().equals("null")) {
            return getError("Received no userID.");
        }
        Integer UserID = Integer.parseInt(a.get("userID").asText());
        List<Favorite> l = favoriteRepository.findByUserID(UserID);
        setData(l);
        return getResponse();
    }
}
