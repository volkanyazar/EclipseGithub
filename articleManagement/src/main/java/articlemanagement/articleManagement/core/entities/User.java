package articlemanagement.articleManagement.core.entities;

import javax.persistence.*;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Entity
@Table(name="user")
@AllArgsConstructor
@NoArgsConstructor
public class User {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name="user_id")
    private int userId;
	
	@Column(name="first_name")
    private String firstName;
	
	@Column(name="last_name")
    private String lastName;
	
	@Column(name="email")
	@Email
	@NotBlank
	@NotNull
    private String email;
	
	@Column(name="username")
    private String username;
	
	@Column(name="password")
	@NotBlank
	@NotNull
    private String password;
	
	@Column(name="gender")
    private String gender;
	
	@Column(name="location")
    private String location;
	
	//ORM
	@ManyToOne()
	@JoinColumn(name="user_type")
	@NotNull
	private UserType userType;
	
	/* NORMAL CTORSSSS LOMBOKSIZ
	public User() {
		
	}

    public User(int id, String firstName, String lastName, String username, String gender, String location) {
        this.id = id;
        this.firstName = firstName;
        this.lastName = lastName;
        this.username = username;
        this.gender = gender;
        this.location = location;
    }

    public User(int id,String firstName, String lastName, String username) {
        this.id = id;
        this.firstName = firstName;
        this.lastName = lastName;
        this.username = username;
    }

    public User(String firstName, String lastName, String username, String password, String gender, String location) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.username = username;
        this.password = password;
        this.gender = gender;
        this.location = location;
    }
    */
    /* NORMAL GETTER SETTERS LOMBOKSIZ LOMBOK ILE GEREK YOK BUNLARA!!!!
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }
	*/
}
