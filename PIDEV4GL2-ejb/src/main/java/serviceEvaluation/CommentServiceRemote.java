package serviceEvaluation;



import java.util.List;

import javax.ejb.Remote;

import entities.Comment;

@Remote
public interface CommentServiceRemote {

	public void addComment(Comment comment);

	public List<Comment> getAllComments();

}
