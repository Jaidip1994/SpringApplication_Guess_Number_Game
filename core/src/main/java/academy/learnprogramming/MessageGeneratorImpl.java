package academy.learnprogramming;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;

@Slf4j
@Component
public class MessageGeneratorImpl implements MessageGenerator {

  private final Game game;

  @Autowired
  public MessageGeneratorImpl(Game game) {
    this.game = game;
  }

  @PostConstruct
  public void init() {
    log.info(" MessageGeneratorImpl::: Game: " + game);
  }
//
//  @PreDestroy
//  public void destroy() {
//    log.info("MessageGeneratorImpl ::: Message Generator is Destroyed");
//  }

  @Override
  public String getMainMessage() {
    return "Number is between "
        + game.getSmallest()
        + "&&  "
        + game.getBiggest()
        + " Can you guess it ?";
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
