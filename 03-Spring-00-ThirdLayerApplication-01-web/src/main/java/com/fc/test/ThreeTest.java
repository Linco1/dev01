package com.fc.test;

import com.fc.dao.impl.UserDaoMySQLImpl;
import com.fc.service.UserServiceImpl;
import org.junit.Test;

public class ThreeTest {
   @Test
   public void  test(){
       UserServiceImpl userService = new UserServiceImpl();
       userService.setUserDao(new UserDaoMySQLImpl());
       userService.useJDBC();
   }
}
