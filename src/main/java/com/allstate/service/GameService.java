package com.allstate.service;

import com.allstate.Entities.Game;
import com.allstate.Entities.User;
import com.allstate.repositories.IGameRepository;
import com.allstate.repositories.IUserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * Created by localadmin on 23/01/17.
 */
@Service
public class GameService {
    private IGameRepository gameRepository;
    private IUserRepository userRepository;
    private CardService cardService;

    @Autowired
    public void setGameRepository(IGameRepository gameRepository) {
        this.gameRepository = gameRepository;
    }

    @Autowired
    public void setUserRepository(IUserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @Autowired
    public void setCardService(CardService cardService) {
        this.cardService = cardService;
    }

    public Game createGame(int userId,int bet){

        User user = this.userRepository.findOne(userId);

        Game game = new Game();
        game.setBet_amount(bet);
        game.setUser(user);

        return this.gameRepository.save(game);
    }
}
