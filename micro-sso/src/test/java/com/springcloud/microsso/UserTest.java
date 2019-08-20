package com.springcloud.microsso;

import com.springcloud.microsso.domain.User;
import org.junit.Test;

import io.ebean.DB;
import io.ebean.Database;

public class UserTest {

 @Test
 public void insertFindDelete() {

  User User = new User();
  User.setUsername("Hello world中文推测");

  Database database = DB.getDefault();

  // insert the User in the DB
  database.save(User);


  // Find by Id
  User foundHello = database.find(User.class, 1);

  System.out.print("hello " + foundHello.getUsername());

  // delete the User
  // database.delete(User);
 }

}