package com.backend.backend.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import java.util.List;

import com.backend.backend.model.Post;
import com.backend.backend.services.PostService;

// // @RestController indique à Spring que cette classe est un bean & 
// insérer le retour de la méthode dans le corps de la réponse HTTP

@RestController 

@RequestMapping("/api/posts")
  public class Controller {

    
    // injeter interface
  @Autowired
    private PostService postService;
}
  
@GetMapping ("")
  public List <Post> list(){
    return postService.list();
  }


  @GetMapping (path= "/{id}")
    public Post get (@PathVariable("id") Long id){
      Post result = postService.get(id);
      if (result == null){
        throw new NoSuchObjectException();
      }
    return result;
  }

@DeleteMapping(path= "/{id}")
  public Post delete (@PathVariable("id") Long id){
    Post result = postService.delete(id);
    return result;

  }


  @GetMapping(path= "/posts?title={title}")
    public Post get (@PathVariable("title") String title){
      Post result = postService.findByTitle(title);
      return result;
    }

    @PostMapping("")
      public Long create (@RequestBody Post post){
        Long result = postService.createNewPost(post);
        return result;
      }

    @PutMapping(path= "/{id}")
    public Post put (@PathVariable("id") Long id){
      Post result = postService.put(id);
      return result;
    }
    


