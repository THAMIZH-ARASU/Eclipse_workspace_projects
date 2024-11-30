package service;

public class BlogPostNotFoundException extends RuntimeException {

    /**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public BlogPostNotFoundException(String message) {
        super(message);
    }
}
