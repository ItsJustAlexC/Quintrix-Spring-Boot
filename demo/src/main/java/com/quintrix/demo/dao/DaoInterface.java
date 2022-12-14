package com.quintrix.demo.dao;

import java.util.List;
import com.quintrix.demo.model.User;

public interface DaoInterface {

  int createUser(int id, String firstName, String lastName);

  int createUser(User user);

  int updateUser(int id, String firstName, String lastName);

  int updateUser(User user);

  User selectUser(int id);

  List<User> selectAll();

  int deleteUser(int id);

  void deleteAll();
}

