package tr.gov.tpe.ost.web.controller.demo;

/**
 * Demo User model.
 */
public class User {
  private static final String DEFAULT_ROLE = "User";
  private static long ID_SEQUENCE = 0L;

  private final long id;
  private final String firstName;
  private final String lastName;
  private final String username;
  private final String role;

  /**
   * Creates a user with default role.
   */
  public User(String name, String surname, String username) {
    id = User.ID_SEQUENCE++;
    this.firstName = name;
    this.lastName = surname;
    this.username = username;
    this.role = DEFAULT_ROLE;
  }

  /**
   * Creates a user with a defined role.
   */
  public User(String name, String surname, String username, String role) {
    id = User.ID_SEQUENCE++; //nopmd
    this.firstName = name;
    this.lastName = surname;
    this.username = username;
    this.role = role;
  }

  public long getId() {
    return id;
  }

  public String getFirstName() {
    return firstName;
  }

  public String getLastName() {
    return lastName;
  }

  public String getUsername() {
    return username;
  }

  public String getRole() {
    return role;
  }

  @Override
  public String toString() {
    return "User{"
        + "id=" + id
        + ", firstName='" + firstName + '\''
        + ", lastName='" + lastName + '\''
        + ", username='" + username + '\''
        + ", role='" + role + '\''
        + '}';
  }
}
