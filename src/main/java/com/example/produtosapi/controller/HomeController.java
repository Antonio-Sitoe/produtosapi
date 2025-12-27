package com.example.produtosapi.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HomeController {

  @GetMapping("/")
  public String home() {
    return "API de Produtos está funcionando! Acesse /produtos para ver os endpoints disponíveis.";
  }

}

