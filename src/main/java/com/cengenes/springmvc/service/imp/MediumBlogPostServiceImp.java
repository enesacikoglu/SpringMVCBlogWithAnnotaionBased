package com.cengenes.springmvc.service.imp;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.cengenes.springmvc.model.BlogPost;
import com.cengenes.springmvc.model.User;
import com.cengenes.springmvc.service.BlogPostService;

public class MediumBlogPostServiceImp implements BlogPostService {

	public static final Logger LOGGER=LoggerFactory.getLogger(MediumBlogPostServiceImp.class);
	
	@Override
	public void savePost(BlogPost blogPost) {
		LOGGER.debug("MediumBlogPostServiceImp :" + " SERVICE CALLED.");
		// TODO Auto-generated method stub

	}

	@Override
	public void saveAsDraft(BlogPost blogPost) {
		// TODO Auto-generated method stub
		
	}

	

	@Override
	public List<BlogPost> listAllBlogPostByUserAndDraftStatus(User user, boolean draft) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<BlogPost> listAllBlogPostByUserAndTitleLike(User user, String title) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public BlogPost findBlogPostById(Long id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void deletePost(BlogPost blogPost) {
		// TODO Auto-generated method stub
		
	}

}
