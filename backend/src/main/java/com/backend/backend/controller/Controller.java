package com.backend.backend.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

import com.backend.backend.exceptions.ResourceNotFoundException;
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
  @GetMapping("")
  @CrossOrigin(origins = "http://localhost:4200")
  public List<Post> list() {
       /*Version longue
    List<Post> requete= new ArrayList<Post>();
    requete = postService.list();
    return requete;*/
    
    //version courte
    return postService.list();
  }

  // post for id
  @GetMapping(path = "/{id}")
  @CrossOrigin(origins = "http://localhost:4200")
  public Post get(@PathVariable("id") Long id) {
    Post result = postService.get(id);
    if (result == null) {
      throw new ResourceNotFoundException();
    }
    return result;
  }

  // DeletePost for id
  @DeleteMapping(path = "/{id}")
  @CrossOrigin(origins = "http://localhost:4200")
  @ResponseStatus(code=HttpStatus.OK)
  public void delete(@PathVariable("id") Long id) {
    if (postService.get(id)!=null){
     postService.delete(id);  
    } else {
      throw new ResourceNotFoundException();
    }
  }

  // findByTitle
  @GetMapping(path = "/posts?title={title}")
  @CrossOrigin(origins = "http://localhost:4200")
  public Post findByTitle(@PathVariable("title") String title) {
    Post result = postService.findByTitle(title);
    if (result == null) {
      throw new ResourceNotFoundException();
    }
    return result;
  }

  // createNewPost
  @PostMapping("")
  @CrossOrigin(origins = "http://localhost:4200")
  @ResponseStatus(code=HttpStatus.CREATED)
  public Long createNewPost(@RequestBody Post post) {
    Long result = postService.createNewPost(post);
    return result;
  }

  // updatePost
  @PutMapping("/{id}")
  @CrossOrigin(origins = "http://localhost:4200")
  @ResponseStatus(code=HttpStatus.OK)
  public void update(@PathVariable("id") Long id, @RequestBody Post post) {
    postService.update(post);   
  }

  @PutMapping("/{id}/publish")
  @CrossOrigin(origins = "http://localhost:4200")
  @ResponseStatus(code=HttpStatus.OK)
  public void publishUnpublish(@PathVariable("id")Long id, @RequestBody Post post){
    postService.publishUnpublish(id, post);
  }
}


