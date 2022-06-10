package articlemanagement.articleManagement.entities.dtos;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class ArticleWithUserDto {
	private int articleId;
	private String journalName;
	private String title;
	private String subject;
	private String authorName;
	private String username;
	private String email;
	private String gender;
	private String location;
	
//DTO - DATA TRANSFORMATION OBJECT //TRANSFORM
}
