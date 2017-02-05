package com.cengenes.springmvc.controller;

import java.util.List;
import java.util.Locale;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.MessageSource;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.servlet.ModelAndView;

import com.cengenes.springmvc.model.BlogPost;
import com.cengenes.springmvc.model.User;
import com.cengenes.springmvc.service.BlogPostService;
import com.cengenes.springmvc.service.UserService;

@Controller
public class BlogPostController {

	private static Logger LOGGER = LoggerFactory.getLogger(BlogPostController.class);
	
	@Autowired
	private BlogPostService blogPostService;
	
	
	@Autowired
	private UserService userService;
	
	@Autowired
	private MessageSource messageSource;

	@RequestMapping(value = "/saveBlogPost", method = RequestMethod.POST)
	public ModelAndView saveBlogPost(
			@RequestParam(value = "title") String title,
			@RequestParam(value = "content") String content,
			@RequestParam(value = "draft", required = false) boolean draft
			,Locale locale) {

		
		BlogPost blogPost = new BlogPost();
	    blogPost.setTitle(title);
	    blogPost.setContent(content);
	    
	  blogPost.setUser(userService.findUserWithBlogPostByUserName("user"));
	
	  LOGGER.debug("Before If value of Draft :" +draft);
	  
	    if (draft==true) {
		  blogPostService.saveAsDraft(blogPost);
		} else {

			blogPostService.savePost(blogPost);;
			
		}
		return new ModelAndView("newblogpost","message",messageSource.getMessage("blogpost.saved",null ,locale));

	}
	
	@RequestMapping(value="/blogposts",method=RequestMethod.GET)
	public ModelAndView blogPosts(){
		
		User user = userService.findUserWithBlogPostByUserName("user");
		List<BlogPost> blogPosts = user.getBlogPosts();
		return new ModelAndView("blogposts","blogposts",blogPosts);
		
		
	}
	
	@RequestMapping(value="/draftblogposts",method=RequestMethod.GET)
	public ModelAndView draftBlogPosts(){
		
		User user = userService.findUserWithBlogPostByUserName("user");
		List<BlogPost> draftBlogPosts = blogPostService.listAllBlogPostByUserAndDraftStatus(user, true);
		return new ModelAndView("blogposts","blogposts",draftBlogPosts);
		
		
	}
	
	@RequestMapping(value="/searchByTitle",method=RequestMethod.POST)
	public ModelAndView searchByTitle(@RequestParam(value="title") String title){
		
		User user = userService.findUserWithBlogPostByUserName("user");
		List<BlogPost> blogPosts = blogPostService.listAllBlogPostByUserAndTitleLike(user, title);
		return new ModelAndView("blogposts","blogposts",blogPosts);
		
		
	}
	
	@RequestMapping(value="/getBlogPostById/{id}",method=RequestMethod.GET)
	@ResponseStatus(code=HttpStatus.OK)
	public @ResponseBody BlogPost getBlogPostById(@PathVariable(value="id") Long idBlogPost){
	
		return blogPostService.findBlogPostById(idBlogPost);
		
	}

}
