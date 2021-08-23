package com.saravanan.assetmgmt;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication //(exclude = {DataSourceAutoConfiguration.class})
//@EnableAutoConfiguration(exclude = {DataSourceAutoConfiguration.class})
public class AssetmgmtApplication {

    public static final Logger log = LoggerFactory.getLogger(AssetmgmtApplication.class);


    public static void main(String[] args) {
        SpringApplication.run(AssetmgmtApplication.class, args);
    }

   // @Autowired
   // AssetMgmtRepository repository;

   // @Bean
   // public CommandLineRunner demo ( ) {
   //     return ( args -> {
   //         repository.save ( new License ( 123456L , "Test" , "Test" , "Test" , "Test" , "Test" ) );
   //         log.info ( repository.findAll ( ).toString ( ) );

    //    } );
   // }
}
