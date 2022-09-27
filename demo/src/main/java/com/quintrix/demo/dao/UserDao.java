package com.quintrix.demo.dao;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;
import com.quintrix.demo.model.User;

@Repository
public class UserDao implements DaoInterface {

  @Autowired
  JdbcTemplate jdbcTemplate;

  @Override
  public int createUser(int id, String firstName, String lastName) {
    String sqlQuery = "insert into user values(?, ?, ?)";
    return jdbcTemplate.update(sqlQuery, id, firstName, lastName);
  }

  @Override
  public int createUser(User user) {
    String sqlQuery = "insert into user values(?, ?, ?)";
    return jdbcTemplate.update(sqlQuery, user.getId(), user.getFirstName(), user.getLastName());
  }

  @Override
  public int updateUser(int id, String firstName, String lastName) {
    String sqlQuery =
        String.format("update user set first_name = \"%s\", last_name = \"%s\" where id = %d",
            firstName, lastName, id);
    return jdbcTemplate.update(sqlQuery);
  }

  @Override
  public int updateUser(User user) {
    String sqlQuery =
        String.format("update user set first_name = \"%s\", last_name = \"%s\" where id = %d",
            user.getFirstName(), user.getLastName(), user.getId());
    return jdbcTemplate.update(sqlQuery);
  }

  @Override
  public User selectUser(int id) {
    String sqlQuery = "select * from user where id=?";
    User user = jdbcTemplate.queryForObject(sqlQuery, new Object[] {id},
        (result, rowNum) -> new User(result.getInt("id"), result.getString("first_name"),
            result.getString("last_name")));
    return user;
  }

  @Override
  public List<User> selectAll() {
    List<User> users = jdbcTemplate.query("select id, first_name, last_name from user",
        (result, rowNum) -> new User(result.getInt("id"), result.getString("first_name"),
            result.getString("last_name")));
    return users;
  }

  @Override
  public int deleteUser(int id) {
    String sqlQuery = "delete from user where id = ?";
    return jdbcTemplate.update(sqlQuery, id);
  }

  @Override
  public void deleteAll() {
    // TODO Auto-generated method stub

  }

}
