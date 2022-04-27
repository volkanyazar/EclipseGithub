package articlemanagement.articleManagement.dataAccess.abstracts;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import articlemanagement.articleManagement.entities.concretes.Article;

public interface ArticleDao extends JpaRepository<Article,Integer>{
		
	Article getBySubject(String subject);
	
	List<Article> getByArticleIdIn(List<Integer> articles);
	
	List<Article> getByJournalNameContains(String journalName);
	

}
