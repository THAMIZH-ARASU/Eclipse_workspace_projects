package service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import model.BlogPost;
import repository.BlogPostRepository;
import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

@Service
public class BlogPostService {
	
	@Autowired
    private final BlogPostRepository blogPostRepository;

    
    public BlogPostService(BlogPostRepository blogPostRepository) {
        this.blogPostRepository = blogPostRepository;
    }

    public BlogPost createBlogPost(BlogPost blogPost) {
        // Set the createdAt timestamp
        blogPost.setCreatedAt(LocalDateTime.now());
        return blogPostRepository.save(blogPost);
    }

    public List<BlogPost> getAllBlogPosts() {
        return blogPostRepository.findAll();
    }

    public Optional<BlogPost> getBlogPostById(Long id) {
        return blogPostRepository.findById(id);
    }

    public BlogPost updateBlogPost(Long id, BlogPost updatedPost) {
        Optional<BlogPost> existingPost = blogPostRepository.findById(id);

        if (existingPost.isPresent()) {
            BlogPost postToUpdate = existingPost.get();
            postToUpdate.setTitle(updatedPost.getTitle());
            postToUpdate.setContent(updatedPost.getContent());

            // You can update other fields as needed
            // For example, you might want to update the "updatedAt" timestamp

            return blogPostRepository.save(postToUpdate);
        } else {
            throw new BlogPostNotFoundException("Blog post with id " + id + " not found.");
        }
    }

    public void deleteBlogPost(Long id) {
        Optional<BlogPost> existingPost = blogPostRepository.findById(id);

        if (existingPost.isPresent()) {
            blogPostRepository.deleteById(id);
        } else {
            throw new BlogPostNotFoundException("Blog post with id " + id + " not found.");
        }
    }

    // You can add more service methods as needed for your project
}
