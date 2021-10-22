package com.backend.backend.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 * @entity permet d'indiquer que la classe correspond à une table de la BDD
 * @table indique le nom de la table associée
 * @id @generatedValue permet d'auto incrémenter l'id 
 * @column permet de faire le lien avec le nom du champ de la table 
 * constructeur Post vide , suivie des méthodes getter et setter 
 * {@ link com.backend.backend.model.Post} object from the Model package.
 * 
 * @author Group3
 */
@Entity
@Table(name = "post")
public class Post {

        @Id
        @GeneratedValue(strategy = GenerationType.IDENTITY)
        @Column(name="id")
        private Long id;
    
        @Column(name="title")
        private String title;
    
        @Column(name="content")
        private String content;
    
        @Column(name="tags")
        private String tags;
    
        @Column(name="published")
        private Boolean published;

        /**
         * Default constructor
         */
        public Post() {
        }

        /**
         * @return the Id of a post, as a Long object.
         */
        public Long getId() {
            return this.id;
        }
    
        /**
         * Sets the id of a post
         * @param id the Id of the post to set 
         */
        public void setId(Long id) {
            this.id = id;
        }
    
        public String getTitle() {
            return this.title;
        }
    
        public void setTitle(String title) {
            this.title = title;
        }
    
        public String getContent() {
            return this.content;
        }
    
        public void setContent(String content) {
            this.content = content;
        }
    
        public String getTags() {
            return this.tags;
        }
    
        public void setTags(String tags) {
            this.tags = tags;
        }
    
        public Boolean isPublished() {
            return this.published;
        }
   
        public Boolean getPublished() {
            return this.published;
        }
    
        public void setPublished(Boolean published) {
            this.published = published;
        }

 }
