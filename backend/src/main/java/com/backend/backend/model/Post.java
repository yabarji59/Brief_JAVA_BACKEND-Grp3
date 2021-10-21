package com.backend.backend.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;


@Entity
@Table(name = "post")
public class Post {

        @Id
        @GeneratedValue(strategy = GenerationType.IDENTITY)
        private Long id;
    
        @Column(name="title")
        private String title;
    
        @Column(name="content")
        private String content;
    
        private String tags;
    
        private Boolean published;

        public Post() {
        }

        public Long getId() {
            return this.id;
        }
    
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
   
