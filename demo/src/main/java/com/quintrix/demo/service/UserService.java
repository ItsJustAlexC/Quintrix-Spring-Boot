package com.quintrix.demo.service;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import com.quintrix.demo.dao.UserDao;
import com.quintrix.demo.model.User;

@Component
public class UserService implements ServiceInterface {

  @Autowired
  UserDao dao;

  @Override
  public int createUser(int id, String firstName, String lastName) {
    return dao.createUser(id, firstName, lastName);
  }

  @Override
  public int createUser(User user) {
    return dao.createUser(user);
  }

  @Override
  public int updateUser(int id, String firstName, String lastName) {
    return dao.updateUser(id, firstName, lastName);
  }

  @Override
  public int updateUser(User user) {
    return dao.updateUser(user);
  }

  @Override
  public User selectUser(int id) {
    return dao.selectUser(id);
  }

  @Override
  public List<User> selectAll() {
    return dao.selectAll();
  }

  @Override
  public int deleteUser(int id) {
    return dao.deleteUser(id);
  }

  @Override
  public void deleteAll() {
    // TODO Auto-generated method stub

  }
}
