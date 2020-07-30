package academy.learnprogramming;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class Main {
    private final static Logger log = LoggerFactory.getLogger(Main.class);
    private static final String CONFIG_LOCATION = "beans.xml";

    public static void main(String[] args) {
        log.info("Hello Information");
        ConfigurableApplicationContext context = new ClassPathXmlApplicationContext(CONFIG_LOCATION);
        // Get the Number Generator bean from context
        NumberGenerator numberGenerator = context.getBean(NumberGenerator.class);


        int number = numberGenerator.next();
        log.info("Generated Number =  " +  number);

        // Get the game bean from the context
        Game game = context.getBean(Game.class);

        context.close();
    }
}
