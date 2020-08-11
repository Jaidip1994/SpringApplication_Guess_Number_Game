package academy.learnprogramming.console;

import academy.learnprogramming.Game;
import academy.learnprogramming.MessageGenerator;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.event.ContextRefreshedEvent;
import org.springframework.context.event.EventListener;
import org.springframework.stereotype.Component;

import java.util.Scanner;

@Slf4j
@Component
// public class ConsoleNumberGuess implements ApplicationListener<ContextRefreshedEvent> {
public class ConsoleNumberGuess {
  private final Game game;
  private final MessageGenerator messageGenerator;

  @Autowired
  public ConsoleNumberGuess(Game game, MessageGenerator messageGenerator) {
    this.game = game;
    this.messageGenerator = messageGenerator;
  }

  @EventListener(ContextRefreshedEvent.class)
  //    @Override
  // Event Listener Parameter
  public void onApplicationEvent() {
    log.info("Start() -> Container ready for use!!!");
    Scanner scanner = new Scanner(System.in);
    while (true) {
      System.out.println(messageGenerator.getMainMessage());
      System.out.println(messageGenerator.getResultMessage());
      int guess = scanner.nextInt();
      scanner.nextLine();
      game.setGuess(guess);
      game.check();
      if (game.isGameWon() || game.isGameLost()) {
        System.out.println(messageGenerator.getResultMessage());
        System.out.println("Play Again (y/n) ? ");
        String playAgain = scanner.nextLine().trim();
        if (!playAgain.equalsIgnoreCase("y")) {
          break;
        }
        game.reset();
      }
    }
  }
}
