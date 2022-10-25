package team9.sse.sse.controller;

import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

//import oit.is.inudaisuki.springboot_samples.model.Fruit;
//import oit.is.inudaisuki.springboot_samples.model.FruitMapper;

@Controller
@RequestMapping("/sample5")
public class Sample51Controller {

  // @Autowired
  // FruitMapper fMapper;

  @GetMapping("step1")
  public String sample51() {
    return "sample51.html";
  }
}
