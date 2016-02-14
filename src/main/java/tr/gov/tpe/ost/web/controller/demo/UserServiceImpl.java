package tr.gov.tpe.ost.web.controller.demo;

import java.util.ArrayList;
import java.util.List;

/**
 * Demo User Service Implementation.
 */
public class UserServiceImpl implements UserService{
  /**
   * Our user base.
   */
  private List<User> users;

  /**
   * Creates a UserService and populates
   * it with test data.
   */
  public UserServiceImpl() {
    users = new ArrayList<User>();
    users.add(new User("Ahmet", "Gumus", "agumus"));
    users.add(new User("Baran", "Atakan", "batakan", "Admin"));
    users.add(new User("Mehmet", "Yildiz", "mehmet.yildiz"));
  }

  /**
   * Get all users.
   *
   * @return list of users
   */
  public List<User> getUsers() {

    return users;
  }
}
