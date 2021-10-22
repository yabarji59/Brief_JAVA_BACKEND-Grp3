package com.backend.backend.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import java.util.List;

import com.backend.backend.model.Post;
import com.backend.backend.services.PostService;

// @RestController tells Spring that this class is a bean &
// insert the return of the method in the body response of the HTTP API REST 

@RestController 

@RequestMapping("/api/posts")
  public class Controller {

    
    // inject interface
  @Autowired
    private PostService postService;


  // list post 
@GetMapping ("")
  public List <Post> list(){
    return postService.list();
  }

// post for id 
  @GetMapping (path= "/{id}")
    public Post get (@PathVariable("id") Long id){
      Post result = postService.get(id);
      if (result == null){
        throw new NoSuchObjectException();
      }
    return result;
  }

// DeletePost for id 
@DeleteMapping(path= "/{id}")
  public Post delete (@PathVariable("id") Long id){
    Post result = postService.delete(id);
    return result;

  }

// findByTitle
  @GetMapping(path= "/posts?title={title}")
    public Post findByTitle (@PathVariable("title") String title){
      Post result = postService.findByTitle(title);
      return result;
    }

// createNewPost
    @PostMapping("")
      public Long createNewPost (@RequestBody Post post){
        Long result = postService.createNewPost(post);
        return result;
      }
//updatePost
    @PutMapping("")
    public Post update (@RequestBody Post post){
      Post result = postService.update(post);
      return result;
    }
    
}
