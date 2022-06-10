package articlemanagement.articleManagement.core.entities;

import java.util.List;

import javax.persistence.*;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Entity
@Table(name="usertype")
@AllArgsConstructor
@NoArgsConstructor
@JsonIgnoreProperties({"hibernateLazyInitializer","handler","users"})
public class UserType {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name="type_id")
	private int typeId;
	
	@Column(name="description")
	private String description;
	
	@Column(name="type")
	private String type;
	
	@OneToMany(mappedBy = "userType")
	private List<User> users;
}
