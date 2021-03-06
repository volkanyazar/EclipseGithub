package articlemanagement.articleManagement.api.controllers;

import java.util.List;


import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.http.ResponseEntity;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

import org.springframework.web.bind.annotation.RestController;

import articlemanagement.articleManagement.business.abstracts.ArticleService;
import articlemanagement.articleManagement.core.utilities.results.DataResult;

import articlemanagement.articleManagement.entities.concretes.Article;
import articlemanagement.articleManagement.entities.dtos.ArticleWithUserDto;

@RestController
@RequestMapping("/api/articles")
public class ArticlesController {
	
	private ArticleService articleService;
	
	@Autowired
	public ArticlesController(ArticleService articleService) {
		super();
		this.articleService = articleService;
	}


	@GetMapping("/getAllArticles")
	public DataResult<List<Article>> getAll(){
		return this.articleService.getAll();
	}
	
	@GetMapping("/getArticleWithAuthorDetails")
	public DataResult<List<ArticleWithUserDto>> getArticleWithAuthorDetails(){
		return this.articleService.getArticleWithAuthorDetails();
	}
	
	@PostMapping("/addArticle")
	public ResponseEntity<?> add(@RequestBody Article article) {
		return ResponseEntity.ok(articleService.add(article));
	}
	
	@GetMapping("/getAllArticlesByPage")
	DataResult<List<Article>> getAll(int pageNo, int pageSize){
		return this.articleService.getAll(pageNo, pageSize);
	}
	
	@GetMapping("/getAllArticlesBySortedDesc")
	DataResult<List<Article>> getAllSorted(){
		return this.articleService.getAllSorted();
	}
	
	
}
