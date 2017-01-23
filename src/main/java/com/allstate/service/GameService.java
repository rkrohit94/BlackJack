package com.allstate.service;

import com.allstate.Entities.Game;
import com.allstate.Entities.User;
import com.allstate.models.Card;
import com.allstate.repositories.IGameRepository;
import com.allstate.repositories.IUserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

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
        user.setBalance(user.getBalance()-bet);

        Game game = new Game();
        game.setBet_amount(bet);
        game.setUser(user);

        this.userRepository.save(user);
        return this.gameRepository.save(game);
    }
    public Iterable<Game> findAll(){
        return this.gameRepository.findAll();
    }

    public List<Game> findAllGameOfUser(int id){
        User user = this.userRepository.findOne(id);
        return user.getGames();
    }

    public void hit(int gameId){
        Game game = this.gameRepository.findOne(gameId);
        Card card = this.cardService.draw();
        game.setPlayerCard(game.getPlayerCard()+","+card.getCard()+card.getSuite());
        String cardName = card.getCard();
        int cardValue = 0;
        if(cardName=="K" || cardName =="Q" || cardName == "J")
            cardValue = 10;
        else if(cardName == "A")
            cardValue = 1;
        else
            cardValue = Integer.parseInt(cardName);
        game.setPlayerCardValue(game.getDealerCardValue()+cardValue);

        if(game.getPlayerCardValue() >21){
            game.setStatus("lost");
        }
    }
    public void stand(int gameId){
        Game game = this.gameRepository.findOne(gameId);
        int dealerPoint = game.getDealerCardValue();
        int playerPoint = game.getPlayerCardValue();
        if(dealerPoint>playerPoint)
            game.setStatus("lost");
        else
            game.setStatus("won");
    }
}
