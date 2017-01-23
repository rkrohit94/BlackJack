package com.allstate.controllers;

import com.allstate.Entities.Game;
import com.allstate.service.GameService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * Created by localadmin on 23/01/17.
 */
@RestController
@RequestMapping(value = "games")
public class GameController {

    private GameService service;

    @Autowired
    public void setService(GameService service) {
        this.service = service;
    }

    @RequestMapping(value = "", method = RequestMethod.GET)
    public Iterable<Game> findAll(){
        return this.service.findAll();
    }

    @RequestMapping(value = "/{userId}/{bet}" ,method = RequestMethod.POST)
    public Game createGame(@PathVariable int userId, @PathVariable int bet){
        return this.service.createGame(userId,bet);
    }
    @RequestMapping(value = "/{userId}/stat", method = RequestMethod.GET)
    public List<Game> findAllGameOfUser(@PathVariable int userId){
        return this.service.findAllGameOfUser(userId);
    }
}
