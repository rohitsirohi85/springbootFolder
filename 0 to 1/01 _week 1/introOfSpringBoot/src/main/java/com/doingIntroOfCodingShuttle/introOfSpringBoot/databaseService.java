package com.doingIntroOfCodingShuttle.introOfSpringBoot;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class databaseService {

   /* if we want ton use dependency with autowired */

    // @Autowired
    // database db;  

    /* if we want ton use dependency with constructor(recommended) */

   final database db;  // when we use constructor way so we have a benefit to add some functionality like final , static etc
    // with final keyword we can sure that nobody will change the value after

    public databaseService(database db){
      this.db=db;
    }


    public String getdata(){
      return db.getdata();
    }
}
