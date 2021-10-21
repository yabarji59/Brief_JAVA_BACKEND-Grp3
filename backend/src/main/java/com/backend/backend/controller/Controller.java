package com.backend.backend.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import java.util.List;

// // @RestController indique à Spring que cette classe est un bean & 
// insérer le retour de la méthode au format JSON dans le corps de la réponse HTTP
// MainController appeler les méthodes pour communiquer avec la base de données.

@RestController
  public class Controller {

    // injeter interface
  @Autowired
    private PostService postService;

}
  
@RequestMapping(path = "", method = RequestMethod)
  public List <Post> List()

  
