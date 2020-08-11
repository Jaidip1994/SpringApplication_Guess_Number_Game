//package academy.learnprogramming.config;
//
//import academy.learnprogramming.*;
//import org.springframework.context.annotation.Bean;
//import org.springframework.context.annotation.ComponentScan;
//import org.springframework.context.annotation.Configuration;
//import org.springframework.context.annotation.Import;
//
//// Streotype Annotation
//
//// This class is used for initializing the container
//@Configuration
//@Import(GameConfig.class) // Load another configuration class
//// Search for all the components
//@ComponentScan(basePackages = "academy.learnprogramming")
//public class AppConfig {
//    // Bean Methods
//    @Bean
//    public NumberGenerator numberGenerator() {
//        return new NumberGeneratorImpl();
//    }
//
//    @Bean
//    public Game game() {
//        return new GameImpl();
//    }
//
//    @Bean
//    public MessageGenerator messageGenerator() {
//        return new MessageGeneratorImpl();
//    }
//}
