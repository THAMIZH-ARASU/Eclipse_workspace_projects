package repository;

import org.springframework.data.jpa.repository.JpaRepository;
import model.BlogPost;

public interface BlogPostRepository extends JpaRepository<BlogPost, Long> {
    
}
