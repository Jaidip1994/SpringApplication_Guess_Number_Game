package academy.learnprogramming;

import lombok.AccessLevel;
import lombok.Getter;
import lombok.Setter;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;

@Slf4j
@Getter
@Component
public class GameImpl implements Game {

  @Getter(AccessLevel.NONE) // Lombok won't generate for this variable
  private final NumberGenerator numberGenerator;

  private final int guessCount;
  private int number;

  @Setter private int guess;

  private int smallest;
  private int biggest;
  private int remainingGuesses;
  private boolean validNumberRange = true;

  @Autowired
  public GameImpl(NumberGenerator numberGenerator, @GuessCount int guessCount) {
    this.numberGenerator = numberGenerator;
    this.guessCount = guessCount;
  }

  //    Init Method
  @PostConstruct
  @Override
  public void reset() {
    smallest = numberGenerator.getMinNumber();
    guess = numberGenerator.getMinNumber();
    remainingGuesses = guessCount;
    biggest = numberGenerator.getMaxNumber();
    number = numberGenerator.next();
    log.debug("GameImpl ::: The number is " + number);
  }

  @PreDestroy
  public void preDestroy() {
    log.info("GameImpl ::: In Game preDestroy()");
  }

  //    Constructor based Dependency Injection
  //    public GameImpl(NumberGenerator numberGenerator) {
  //        this.numberGenerator = numberGenerator;
  //    }

  //    Setter Based Dependency Injection
  //    public void setNumberGenerator(NumberGenerator numberGenerator) {
  //        this.numberGenerator = numberGenerator;
  //    }

  @Override
  public void check() {
    checkValidNumberRange();
    if (validNumberRange) {
      if (guess > number) {
        biggest = guess - 1;
      }
      if (guess < number) {
        smallest = guess + 1;
      }
    }
    remainingGuesses--;
  }

  @Override
  public boolean isGameWon() {
    return guess == number;
  }

  @Override
  public boolean isGameLost() {
    return !isGameWon() && remainingGuesses <= 0;
  }

  private void checkValidNumberRange() {
    validNumberRange = (guess >= smallest) && (guess <= biggest);
  }
}
