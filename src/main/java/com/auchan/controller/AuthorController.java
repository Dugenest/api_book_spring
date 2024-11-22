package com.auchan.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.auchan.data.Author;
import com.auchan.service.AuthorService;

@RestController
@RequestMapping("/authors")
public class AuthorController {

	private final AuthorService authorService;

	public AuthorController(AuthorService authorService) {
		this.authorService = authorService;
	}

	// Obtenir tous les auteurs
	@GetMapping
	public ResponseEntity<List<Author>> getAllAuthors() {
		List<Author> authors = authorService.getAllAuthors();
		return ResponseEntity.ok(authors);
	}

	// Obtenir un auteur par ID
	@GetMapping("/{id}")
	public ResponseEntity<Author> getAuthorById(@PathVariable Long id) {
		Optional<Author> author = authorService.getAuthorById(id);
		if (author.isPresent()) {
			return ResponseEntity.ok(author.get());
		} else {
			return ResponseEntity.status(HttpStatus.NOT_FOUND).body(null);
		}
	}

	// Créer un nouvel auteur
	@PostMapping
	public ResponseEntity<Author> createAuthor(@RequestBody Author author) {
		Author createdAuthor = authorService.createAuthor(author);
		return ResponseEntity.status(HttpStatus.CREATED).body(createdAuthor);
	}

	// Mettre à jour un auteur
	@PutMapping("/{id}")
	public ResponseEntity<Author> updateAuthor(@PathVariable Long id, @RequestBody Author updatedAuthor) {
		Optional<Author> author = authorService.updateAuthor(id, updatedAuthor);
		if (author.isPresent()) {
			return ResponseEntity.ok(author.get());
		} else {
			return ResponseEntity.status(HttpStatus.NOT_FOUND).body(null);
		}
	}

	// Supprimer un auteur
	@DeleteMapping("/{id}")
	public ResponseEntity<Void> deleteAuthor(@PathVariable Long id) {
		boolean deleted = authorService.deleteAuthor(id);
		if (deleted) {
			return ResponseEntity.noContent().build();
		} else {
			return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
		}
	}

	@Override
	public String toString() {
		return "AuthorController [authorService=" + authorService + "]";
	}

}
