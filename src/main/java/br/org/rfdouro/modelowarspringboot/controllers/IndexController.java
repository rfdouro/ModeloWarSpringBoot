/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.org.rfdouro.modelowarspringboot.controllers;

import java.util.Date;
import java.util.Map;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 *
 * @author romulo.douro
 */
@Controller
public class IndexController {

 @Value("${application.message:ola mundo}")
 private String message = "ola aqui";

 @GetMapping("/")
 public String index(Map<String, Object> model) {
  model.put("date", new Date());
  model.put("message", this.message);
  return "index";
 }

}
