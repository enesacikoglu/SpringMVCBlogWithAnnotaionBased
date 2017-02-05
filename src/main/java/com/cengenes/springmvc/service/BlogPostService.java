package com.cengenes.springmvc.service;

import java.util.List;

import com.cengenes.springmvc.model.BlogPost;
import com.cengenes.springmvc.model.User;

public interface BlogPostService {
	
	
	void savePost(BlogPost blogPost);
    void saveAsDraft(BlogPost blogPost);
    void deletePost(BlogPost blogPost);
    List<BlogPost> listAllBlogPostByUserAndDraftStatus(User user,boolean draft);
    List<BlogPost> listAllBlogPostByUserAndTitleLike(User user,String title);
    BlogPost findBlogPostById(Long id);
}
