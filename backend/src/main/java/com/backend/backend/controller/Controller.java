package com.backend.backend.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import java.util.List;

import com.backend.backend.model.Post;

// // @RestController indique à Spring que cette classe est un bean & 
// insérer le retour de la méthode au format JSON dans le corps de la réponse HTTP
// MainController appeler les méthodes pour communiquer avec la base de données.

@RestController (path= " 'http://localhost:8080/api/posts'")
  public class Controller {

    
    // injeter interface
  @Autowired
    private PostService postService;

}
  
@RequestMapping
  public List <post> List()


  @GetMapping (path= "/{id}")
  public Post get (@PathVariable("id") Long id){
    Post result = postService.get();
    return null;
  }


  @GetMapping (path= "/{id}, 
    public List<ost> getAll



  // value method est un alias pour la méthode path.

  // @RequestMapping(value = "/path", method = {RequestMethod.GET, RequestMethod.POST, RequestMethod.PUT)
  //   public void handleRequet() {
    
  //   }







  
  // @RequestMapping("/users")
  // public class UserController {
  
  //     @PostMapping
  //     public void createUser(Request request) {
  //         // POST /users
  //         // create a user
  //     }
  
  //     @GetMapping
  //     public Users getUsers(Request request) {
  //         // GET /users
  //         // get users
  //     }
  
  //     @GetMapping("/{id}")
  //     public Users getUserById(@PathVariable long id) {
  //         // GET /users/1
  //         // get user by id
  //     }
  // }





  // The @GetMapping maps a / root path from a GET request to the index()method

