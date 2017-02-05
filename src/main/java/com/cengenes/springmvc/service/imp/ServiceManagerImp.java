package com.cengenes.springmvc.service.imp;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;

import com.cengenes.springmvc.model.BlogPost;
import com.cengenes.springmvc.service.BlogPostService;
import com.cengenes.springmvc.service.ServiceManager;

public class ServiceManagerImp implements ServiceManager {

	@Autowired
	@Qualifier("Medium")
	private BlogPostService blogPostService;
	
	@Override
	public void sendBlogPost(BlogPost blogPost) {
	
		blogPostService.savePost(blogPost);

	}

}
