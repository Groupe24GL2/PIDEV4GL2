package serviceEvaluation;



import java.util.List;

import javax.ejb.LocalBean;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;

import entities.Comment;

@Stateless
@LocalBean
public class CommentService implements CommentServiceRemote{
	@PersistenceContext(unitName = "pidev4gl2-ejb")
	EntityManager em;
	
	@Override
	public void addComment(Comment comment) {
		em.persist(comment);
	}

	@Override
	public List<Comment> getAllComments() {
		TypedQuery<Comment> query = em.createQuery("Select c from Comment", Comment.class);
		return query.getResultList();
	}
}
