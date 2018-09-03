package com.pearl.spring;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.task.configuration.EnableTask;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
@EnableTask
public class DemoApplication {

    public static void main(String[] args) {
        SpringApplication.run(DemoApplication.class, args);
    }


    @Bean
    public TollProcessingTask tollProcessingTask() {
        return new TollProcessingTask();
    }

    public class TollProcessingTask implements CommandLineRunner {

        @Override
        public void run(String... args) throws Exception {
            if (null != args) {
                System.out.println("Parameter length is " + args.length);

                if (args.length != 0) {

                    String stationId = args[0];
                    String licensePlate = args[1];
                    String timestamp = args[2];
                    System.out.println("Station ID is " + stationId + ", Plate is " +
                            licensePlate + ", timestamp is " + timestamp);
                }


            }
        }
    }


}
