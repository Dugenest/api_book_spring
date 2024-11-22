package com.auchan.data;

import java.io.Serializable;
import java.util.Set;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;

@Entity
public class Author implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	
	@OneToMany(mappedBy = "author", cascade = CascadeType.ALL)
	private Set<Book> books;
	
	private Long authorId;
	private String authorName;
	private String authorFirstname;
	private String authorEmail;

	public Author() {

	}

	public Author(String authorName, String authorFirstname, String authorEmail) {
		super();
		this.authorName = authorName;
		this.authorFirstname = authorFirstname;
		this.authorEmail = authorEmail;
	}

	public Long getAuthorId() {
		return authorId;
	}

	public void setAuthorId(Long authorId) {
		this.authorId = authorId;
	}

	public String getAuthorName() {
		return authorName;
	}

	public void setAuthorName(String authorName) {
		this.authorName = authorName;
	}

	public String getAuthorFirstname() {
		return authorFirstname;
	}

	public void setAuthorFirstname(String authorFirstname) {
		this.authorFirstname = authorFirstname;
	}

	public String getAuthorEmail() {
		return authorEmail;
	}

	public void setAuthorEmail(String authorEmail) {
		this.authorEmail = authorEmail;
	}

	@Override
	public String toString() {
		return "Author [authorId=" + authorId + ", authorName=" + authorName + ", authorFirstname=" + authorFirstname
				+ ", authorEmail=" + authorEmail + "]";
	}

}
