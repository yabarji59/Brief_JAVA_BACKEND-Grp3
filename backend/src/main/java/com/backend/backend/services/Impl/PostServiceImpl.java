package com.backend.backend.services.Impl;

import java.util.ArrayList;
import java.util.List;

import com.backend.backend.repository.PostRepository;
import com.backend.backend.services.PostService;
import com.backend.backend.model.Post;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.backend.backend.exceptions.InsertionException;
import com.backend.backend.exceptions.ResourceNotFoundException;

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
     * 
     */
    @Override
    public void delete(Long id) {
        // TODO remove.production
        System.out.println("Delete one post : " + id);
        postRepository.deleteById(id);

    }

    /**
     * Update one post
     * 
     * @param the post that we want to update
     * @return the updated post or Invalid object exception
     */
    @Override
    public Post update(Post post) {

        // TODO remove.production
        System.out.println("update one post : " + post.getTitle());
        if (validateForm(post)) {
           return postRepository.save(post);
        }
        throw new InsertionException("invalide object");

    }

    /**
     * Update one post
     *
     */
    @Override
    public Long createNewPost(Post post) {
        System.out.println(post.toString());
        if (validateForm(post)) {
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
        // TODO remove.production
        System.out.println("Find one post : " + title);
        return postRepository.findByTitle(title);
    }

    @Override
    public Post get(Long id) {
        return postRepository.findById(id).get();
    }

    /**
     * This method updates a post from the database, changing its published
     * attribute to true or false. Since the post object given by front has null
     * fields, we must first find the full corresponding object in the database
     * (passing the given ID to a get method). If we do not do that, database will
     * reject the request because of NOT NULL constraint violation. We could also
     * use a PATCH method rather than PUT method to update only the desired fields,
     * but front send us PUT method so we have to deal with it.
     * 
     * @param id   the ID of the post that we want to update in the database, given
     *             by front HTTP request
     * @param post a Post object with null attributes, except for the "published"
     *             attribute, which is the attribute that we want to update on the
     *             object in the database.
     * 
     * @throws ResourceNotFoundException if no post in the database matches the id
     *                                   given to us by the front.
     */
    @Override
    public void publishUnpublish(Long id, Post post) {
        Post postToUpdate = this.get(id);
        if (postToUpdate != null) {
            postToUpdate.setPublished(post.getPublished());
            this.update(postToUpdate);
        }
        throw new ResourceNotFoundException();
    }

    
    private boolean validateForm(Post post) {
        if (post == null 
        || post.getTitle() == null 
        || post.getTitle().trim().isEmpty() 
        || post.getTags() == null
        || post.getContent() == null) {

            return false;
        }
        return true;

    }

}
