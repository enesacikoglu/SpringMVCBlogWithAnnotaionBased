package com.cengenes.springmvc.service.imp;

import java.util.Date;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;

import com.cengenes.springmvc.dao.BlogPostDao;
import com.cengenes.springmvc.model.BlogPost;
import com.cengenes.springmvc.model.User;
import com.cengenes.springmvc.service.BlogPostService;
import com.cengenes.springmvc.service.EmailService;


public class BlogPostServiceImp implements BlogPostService {

	public static final Logger LOGGER=LoggerFactory.getLogger(BlogPostServiceImp.class);
	
	@Autowired
	private BlogPostDao blogPostDao;
	
	/*
	@Autowired
	private DataSource dataSource;
	*/
	
	/*
	@Autowired
	private EmailService emailService;
	*/
	
	@Override
	public void savePost(BlogPost blogPost) {
		//LOGGER.debug("dataSource : " +dataSource.getURL());
		//emailService.sendEmail();
		//LOGGER.debug("EmailServiceImp : "  +"emailService.sendEmail() is Called.");
		LOGGER.debug("BlogPostServiceImp : " +"Save Post is CALLED.");
		// TODO Auto-generated method stub
        blogPost.setPublishDate(new Date());
		blogPostDao.save(blogPost);
		
	}

	@Override
	public void saveAsDraft(BlogPost blogPost) {
		blogPost.setDraft(true);
		blogPostDao.save(blogPost);
		
	}

	@Override
	public void deletePost(BlogPost blogPost) {
		// TODO Auto-generated method stub
		blogPostDao.delete(blogPost);
	}

	@Override
	public List<BlogPost> listAllBlogPostByUserAndDraftStatus(User user, boolean draft) {
		// TODO Auto-generated method stub
		return blogPostDao.findAllBlogPostsByUserAndDraft(user, draft);
	}

	@Override
	public List<BlogPost> listAllBlogPostByUserAndTitleLike(User user, String title) {
		// TODO Auto-generated method stub
		return blogPostDao.findAllBlogPostsByUserAndTitleContaining(user, title);
	}

	@Override
	public BlogPost findBlogPostById(Long id) {
		// TODO Auto-generated method stub
		return blogPostDao.findOne(id);
	}


}
