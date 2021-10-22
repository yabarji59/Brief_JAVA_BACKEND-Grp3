package com.backend.backend.services.Impl;

import java.util.List;
import com.backend.backend.repository.PostRepository;
import com.backend.backend.services.PostService;
import com.backend.backend.model.Post;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


@Service
public class PostServiceImpl implements PostService {
    
    @Autowired
	private PostRepository PostRepository;

    @Override
    public List<Post> list() {
        // TODO Auto-generated method stub
        return null;
    }

    @Override
    public Iterable<Post> findAll() {
        // TODO Auto-generated method stub
        return null;
    }

    @Override
    public void delete(Long id) {
        // TODO Auto-generated method stub
        
    }

    @Override
    public Post update(Long id, Post post) {
        // TODO Auto-generated method stub
        return null;
    }

    @Override
    public String createNewPost(Post post) {
        return PostRepository.save(post).getId();
        return null;
    }

    @Override
    public Post findByTitle(String title) {
        // TODO Auto-generated method stub
        return null;
    }

    @Override
    public Post publishUnpublish(Long id, Post post) {
        // TODO Auto-generated method stub
        return null;
    } 
	



}



    

