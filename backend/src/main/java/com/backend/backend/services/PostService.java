package com.backend.backend.services;

import java.util.List;

import com.backend.backend.model.Post;

public interface PostService {

    public List<Post> list();
    //list () doit etre définit dans la classe message (controller?)/ getter 
    //list() est définit dans le front (équivaut à findall())
    public Post get(Long id);

    public void delete(Long id);// ou long

    public void update(Post post);

    public Long createNewPost(Post post);

    public Post findByTitle(String title);

    public void publishUnpublish(Long id, Post post);
        
	}

