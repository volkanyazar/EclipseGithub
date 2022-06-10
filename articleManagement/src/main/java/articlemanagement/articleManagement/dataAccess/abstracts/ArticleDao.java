package articlemanagement.articleManagement.dataAccess.abstracts;

import java.util.List;


import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import articlemanagement.articleManagement.entities.concretes.Article;
import articlemanagement.articleManagement.entities.dtos.ArticleWithUserDto;

public interface ArticleDao extends JpaRepository<Article,Integer>{
		
	Article getBySubject(String subject);
	
	List<Article> getByArticleIdIn(List<Integer> articles);
	
	List<Article> getByJournalNameContains(String journalName);
	
	@Query("Select new articlemanagement.articleManagement.entities.dtos.ArticleWithUserDto"
			+ "(a.articleId,a.journalName,a.title,a.subject,a.authorName,u.username,u.email,u.gender,u.location)"
			+ " From Article a Inner Join User u On a.authorName = u.firstName")
	List<ArticleWithUserDto> getArticleWithAuthorDetails();
	

}
