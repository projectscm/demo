package tr.gov.tpe.ost.web.controller.demo;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;


@Controller
@RequestMapping("/demo")
@SuppressWarnings({"PMD.TooManyMethods"})
public class DemoController {
  @Autowired
  UserService userService;

  @RequestMapping("/")
  public String index() {
    return "demo/index";
  }

  @RequestMapping("/people")
  public String people(Model model) {
    model.addAttribute("users", userService.getUsers());
    return "demo/people";
  }

  @RequestMapping("/login")
  public String login(Model model) {

    return "demo/login";
  }

  @RequestMapping("/signup")
  public String signup(Model model) {

    return "demo/signup";
  }

  @RequestMapping("/userarea")
  public String userarea(Model model) {

    return "demo/userarea";
  }

  @RequestMapping("/newSubprofile")
  public String newSubprofile(Model model) {

    return "demo/newSubprofile";
  }

  @RequestMapping("/newPassword")
  public String newPassword(Model model) {

    return "demo/newPassword";
  }

  @RequestMapping("/recover")
  public String recover(Model model) {

    return "demo/recover";
  }

  @RequestMapping("/trademark_search")
  public String trademark_search(Model model) {

    return "demo/trademark_search";
  }

  @RequestMapping("/trademark_result")
  public String trademark_result(Model model) {

    return "demo/trademark_result";
  }

  @RequestMapping("/trademark_search_dossier")
  public String trademark_search_dossier(Model model) {

    return "demo/trademark_search_dossier";
  }

  @RequestMapping("/patent_search")
  public String patent_search(Model model) {

    return "demo/patent_search";
  }

  @RequestMapping("/patent_search_dossier")
  public String patent_search_dossier(Model model) {

    return "demo/patent_search_dossier";
  }

  @RequestMapping("/designs_search")
  public String designs_search(Model model) {

    return "demo/designs_search";
  }

  @RequestMapping("/designs_search_dossier")
  public String designs_search_dossier(Model model) {

    return "demo/designs_search_dossier";
  }

  @Bean
  public UserService userService() {
    return new UserServiceImpl();
  }
}



