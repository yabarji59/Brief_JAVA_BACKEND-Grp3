package com.backend.backend.services.Impl;

import java.util.ArrayList;
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
        List<Post> liste = new ArrayList<Post>();
        PostRepository.findAll().forEach(liste::add);
        return liste;
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

    public Long createNewPost(Post post) {
        // TODO Auto-generated method stub

        return null;
    }

     /**
     * Find one post
     *
     * @param title of the post 
     * @return the post
     */
    @Override
    public Post findByTitle(String title) {
        System.out.println("Find one post : " + title);
        return PostRepository.findByTitle(title);
    }

    @Override
    public Post publishUnpublish(Long id, Post post) {
        // TODO Auto-generated method stub
        return null;
    }

    
	



}



    

