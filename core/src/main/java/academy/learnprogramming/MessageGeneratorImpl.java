package academy.learnprogramming;


import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;

public class MessageGeneratorImpl implements MessageGenerator {
    private static final Logger logger = LoggerFactory.getLogger(MessageGeneratorImpl.class);

    @Autowired
    private Game game;

    @PostConstruct
    public void init() {
        logger.info(" MessageGeneratorImpl::: Game: " + game);
    }

    @PreDestroy
    public void destroy() {
        game = null;
        logger.info("MessageGeneratorImpl ::: Message Generator is Destroyed");
    }

    @Override
    public String getMainMessage() {
        return "Number is between " + game.getSmallest() + "&&  " + game.getBiggest() + " Can you guess it ?";
    }

    @Override
    public String getResultMessage() {
        if (game.isGameWon()) {
            return "You WON!!!, Number is " + game.getNumber();
        } else if (game.isGameLost()) {
            return "You LOST, Number was " + game.getNumber();
        } else if (!game.isValidNumberRange()) {
            return "Invalid number Range !!!";
        } else if (game.getRemainingGuesses() == game.getGuessCount()) {
            return "What is your first guess";
        } else {
            String direction = "Lower";
            if (game.getGuess() < game.getNumber()) {
                direction = "Higher";
            }
            return direction + " ! You have " + game.getRemainingGuesses() + " guesses Left ....";
        }
    }
}
