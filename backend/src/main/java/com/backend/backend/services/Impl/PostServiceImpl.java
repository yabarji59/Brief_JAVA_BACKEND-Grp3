package com.backend.backend.services.Impl;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import com.backend.backend.repository.PostRepository;
import com.backend.backend.services.PostService;
import com.backend.backend.model.Post;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.backend.backend.exceptions.InsertionException;


@Service
public class PostServiceImpl implements PostService {
    
    @Autowired
	private PostRepository postRepository;



    @Override
    public List<Post> list() {
        List<Post> liste = new ArrayList<Post>();
        postRepository.findAll().forEach(liste::add);
        return liste;
    }

   /**
     * Delete one post
     *
     * @param id the Id of the post that we want to delete
     * @return the post
     */
    @Override
    public void delete(Long id) {
        //TODO remove.production
        System.out.println("Delete one post : " + id);
        postRepository.deleteById(id);

    }

 /**
     * Update one post
     * 
     *@param update of the post 
     * @return the post
     */
    @Override
    public Post update(Post post) {

        //TODO remove.production
        System.out.println("update one post : " + post);      
        return postRepository.save(post);

    }

 /**
     * Update one post
     *
     */
    @Override
    public Long createNewPost(Post post) {
        System.out.println(post.toString()); 
        if (validateForm(post))  {
        System.out.println(" la méthode createNewPost est passée"); 
        // TO DO remove after test
        return postRepository.save(post).getId();
        }
    
        throw new InsertionException("invalide object");
    }
  

     /**
     * Find one post
     *
     * @param title of the post 
     * @return the post
     */
    @Override
    public Post findByTitle(String title) {
        //TODO remove.production
        System.out.println("Find one post : " + title);
        return postRepository.findByTitle(title);
    }

   
   private boolean  validateForm(Post post) {
        if ( post == null
        || post.getTitle() == null || post.getTitle().trim().isEmpty()
        || post.getTags() == null
        || post.getContent() == null
        ) {
            return false;
        }
        return true;

   }

@Override
public Post get(Long id) {
    return postRepository.findById(id).get();   
} 
	



}



    

