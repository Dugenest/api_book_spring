package com.auchan.service;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import com.auchan.data.AuthorRepository;
import com.auchan.model.Author;

@Service
public class AuthorService {

	private AuthorRepository authorRepository;

	public AuthorService(AuthorRepository authorRepository) {
		this.authorRepository = authorRepository;
	}

	// Obtenir un auteur par son ID
	public Optional<Author> getAuthorById(Long id) {
		return authorRepository.findById(id);
	}

	// Obtenir tous les auteurs
	public List<Author> getAllAuthors() {
		return (List<Author>) authorRepository.findAll();
	}

	// Créer un auteur (vérifie avant s'il existe déjà par ID)
	public Author createAuthor(Author author) {
		// Vérifier si un auteur avec le même ID existe déjà
		if (author.getAuthorId() != null && authorRepository.findById(author.getAuthorId()).isPresent()) {
			// Retourner l'auteur existant ou lever une exception personnalisée
			return authorRepository.findById(author.getAuthorId()).get();
		}
		// Si aucun auteur avec cet ID n'existe, créer l'auteur
		return authorRepository.save(author);
	}

	// Update Author
	public Optional<Author> updateAuthor(Long id, Author updatedAuthor) {
		// Rechercher l'auteur par ID
		return authorRepository.findById(id).map(existingAuthor -> {
			// Si l'auteur existe, mettre à jour ses données
			existingAuthor.setAuthorName(updatedAuthor.getAuthorName());
			existingAuthor.setAuthorFirstname(updatedAuthor.getAuthorFirstname());
			existingAuthor.setAuthorEmail(updatedAuthor.getAuthorEmail());
			// Sauvegarder les modifications
			return authorRepository.save(existingAuthor);
		});
		// Si l'auteur n'existe pas, on retourne un Optional.empty()
	}

	// Supprimer un auteur
	public boolean deleteAuthor(Long id) {
		if (authorRepository.existsById(id)) {
			authorRepository.deleteById(id);
			return true; // Suppression réussie
		}
		return false; // Auteur non trouvé
	}

	public AuthorRepository getAuthorRepository() {
		return authorRepository;
	}

	public void setAuthorRepository(AuthorRepository authorRepository) {
		this.authorRepository = authorRepository;
	}

}
