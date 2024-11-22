package com.auchan.data;

import java.io.Serializable;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

@Entity

public class Category implements Serializable {

	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	
	// Attributs
	private Long idCategory;
	private String nameCategory;
	
	
	// Constructeur
	public Category() {
	}


	// Getters et Setters
	public Long getIdCategory() {
		return idCategory;
	}


	public void setIdCategory(Long idCategory) {
		this.idCategory = idCategory;
	}


	public String getNameCategory() {
		return nameCategory;
	}


	public void setNameCategory(String nameCategory) {
		this.nameCategory = nameCategory;
	}


	// Méthode toString
	@Override
	public String toString() {
		return "Category [idCategory=" + idCategory + ", nameCategory=" + nameCategory + "]";
	}

}
