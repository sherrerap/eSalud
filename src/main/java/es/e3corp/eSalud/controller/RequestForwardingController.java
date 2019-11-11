package es.e3corp.eSalud.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
/**
 * @author e3corp
 */
public class RequestForwardingController {
  @RequestMapping(value = "/**/{[path:[^\\.]*}")
  /**
   * @author e3corp
   */
  public String redirect() {
    // Forward to home page so that angular routing is preserved.
    return "forward:/";
  }
}