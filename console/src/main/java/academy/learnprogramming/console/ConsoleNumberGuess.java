package academy.learnprogramming.console;

import academy.learnprogramming.Game;
import academy.learnprogramming.MessageGenerator;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.event.ContextRefreshedEvent;
import org.springframework.context.event.EventListener;
import org.springframework.stereotype.Component;

import java.util.Scanner;

@Component
//public class ConsoleNumberGuess implements ApplicationListener<ContextRefreshedEvent> {
public class ConsoleNumberGuess {
    private static final Logger logger = LoggerFactory.getLogger(ConsoleNumberGuess.class);
    @Autowired
    private Game game;

    @Autowired
    private MessageGenerator messageGenerator;

    @EventListener(ContextRefreshedEvent.class)
//    @Override
    // Event Listener Parameter
    public void onApplicationEvent() {
        logger.info("Start() -> Container ready for use!!!");
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
