package com.auchan.data;

import java.io.Serializable;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

@Entity

public class Book implements Serializable {

	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	

	// Attributs
	private Long idBook;
	private String titleBook;
	private int dateBook;

	// Constructeur
	public Book() {
	}

	// Getters et Setters
	public Long getIdBook() {
		return idBook;
	}

	public void setIdBook(Long idBook) {
		this.idBook = idBook;
	}

	public String getTitleBook() {
		return titleBook;
	}

	public void setTitleBook(String titleBook) {
		this.titleBook = titleBook;
	}

	public int getDateBook() {
		return dateBook;
	}

	public void setDateBook(int dateBook) {
		this.dateBook = dateBook;
	}

	// Méthode toString
	@Override
	public String toString() {
		return "Book [idBook=" + idBook + ", titleBook=" + titleBook + ", dateBook=" + dateBook + "]";
	}

}
