package tr.gov.tpe.ost.web.controller.demo;

import org.hamcrest.Matchers;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.web.context.WebApplicationContext;
import tr.gov.tpe.ost.config.TestContext;
import tr.gov.tpe.ost.config.WebConfig;

import java.util.ArrayList;
import java.util.List;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;


@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes = {WebConfig.class, TestContext.class})
@WebAppConfiguration

public class DemoIntegrationTest {
  private static final String VIEW_INDEX = "demo/index";
  private static final String VIEW_PEOPLE = "demo/people";

  private MockMvc mockMvc;

  @Autowired
  private WebApplicationContext webApplicationContext;

  @Autowired
  private UserService userServiceMock;

  /**
   * Set up controller.
   */
  @Before
  public void setUp() {
    Mockito.reset(userServiceMock);
    mockMvc = MockMvcBuilders.webAppContextSetup(webApplicationContext).build();
  }


  @Test
  public void indexTest() throws Exception {
    mockMvc.perform(get("/demo/"))
        .andDo(print())
        .andExpect(MockMvcResultMatchers.status().isOk())
        .andExpect(MockMvcResultMatchers.view().name(VIEW_INDEX));
  }

  @Test
  public void peopleTest() throws Exception {

    Mockito.when(userServiceMock.getUsers()).thenReturn(testUsers());

    mockMvc.perform(
        get("/demo/people"))
        .andDo(print())
        .andExpect(MockMvcResultMatchers.status().isOk())
        .andExpect(MockMvcResultMatchers.view().name(VIEW_PEOPLE))
        .andExpect(MockMvcResultMatchers.model().attribute("users", Matchers.hasSize(2)))
        .andExpect(MockMvcResultMatchers.model().attribute("users", Matchers.hasItem(
            Matchers.allOf(
                Matchers.hasProperty("id", Matchers.is(0L)),
                Matchers.hasProperty("firstName", Matchers.is("ali")),
                Matchers.hasProperty("lastName", Matchers.is("ok")),
                Matchers.hasProperty("username", Matchers.is("aok")),
                Matchers.hasProperty("role", Matchers.is("User"))
            )
        )))
        .andExpect(MockMvcResultMatchers.model().attribute("users", Matchers.hasItem(
            Matchers.allOf(
                Matchers.hasProperty("id", Matchers.is(1L)),
                Matchers.hasProperty("firstName", Matchers.is("veli")),
                Matchers.hasProperty("lastName", Matchers.is("ok")),
                Matchers.hasProperty("username", Matchers.is("vok")),
                Matchers.hasProperty("role", Matchers.is("admin"))
            )
        )));

    Mockito.verify(userServiceMock, Mockito.times(1)).getUsers();
    Mockito.verifyNoMoreInteractions(userServiceMock);
  }

  private List<User> testUsers() {
    List<User> users = new ArrayList<User>();
    users.add(new User("ali", "ok", "aok"));
    users.add(new User("veli", "ok", "vok", "admin"));
    return users;
  }
}
