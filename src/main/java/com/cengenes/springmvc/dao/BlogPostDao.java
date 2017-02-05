package com.cengenes.springmvc.dao;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

import com.cengenes.springmvc.model.BlogPost;
import com.cengenes.springmvc.model.User;

public interface BlogPostDao extends CrudRepository<BlogPost, Long>{
	
	//custom methods
	List<BlogPost> findAllBlogPostsByUserAndTitleContaining(User user,String title);
	List<BlogPost> findAllBlogPostsByUserAndDraft(User user,boolean draft);
	
	
	
}
