package com.backend.backend.services;

import java.util.List;

import com.backend.backend.model.Post;

public interface PostService {

    public List<Post> list();
    //list () doit etre définit dans la classe message (controller?)/ getter 
    //list() est définit dans le front 
    public Iterable<Post> findAll();

    public void delete(Long id);// ou long

    public Post update(Long id, Post post);

    public String createNewPost(Post post);

    public Post findByTitle(String title);

    public Post publishUnpublish(Long id, Post post);

        
	}

