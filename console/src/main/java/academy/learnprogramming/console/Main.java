package academy.learnprogramming.console;

import academy.learnprogramming.Game;
import lombok.extern.slf4j.Slf4j;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

@Slf4j
public class Main {
  //    As this was used for Bean Based Configuration
  //    private static final String CONFIG_LOCATION = "beans.xml";

  public static void main(String[] args) {
    log.info("Hello Information");
    //        XML Based Configuration
    //        ConfigurableApplicationContext context = new
    // ClassPathXmlApplicationContext(CONFIG_LOCATION);

    //        Annotation Based Configuration
    ConfigurableApplicationContext context = new AnnotationConfigApplicationContext(Game.class);
    //        // Get the Number Generator bean from context
    //        NumberGenerator numberGenerator = context.getBean(NumberGenerator.class);
    //
    //
    //        int number = numberGenerator.next();
    //        log.info("Main -> numberGenerator ::: Generated Number =  " + number);
    //
    //        // Get the game bean from the context
    ////        Game game = context.getBean(Game.class);
    //
    ////        Get the Message Generator from the context
    //        MessageGenerator messageGenerator = context.getBean(MessageGenerator.class);
    //        log.info("Main->messageGenerator ::: getMainMessage(): " +
    // messageGenerator.getMainMessage());
    //        log.info("Main->messageGenerator :::getResultMessage(): " +
    // messageGenerator.getResultMessage());

    context.close();
  }
}
