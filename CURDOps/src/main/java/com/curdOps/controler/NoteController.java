package com.curdOps.controler;

import java.util.List;

import javax.validation.Valid;

import org.apache.maven.wrapper.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.curdOps.DTO.Note;

import exception.ResourceNotFoundException;
import repositoryDAO.NoteRepository;

@RestController
@RequestMapping("/api")
public class NoteController {

	@Autowired(required = true)
	NoteRepository noteRepository;

	// GetAll Notes
	@GetMapping("/notes")
	public List<Note> getAllNotes() {
		return noteRepository.findAll();
	}

	// Create New Note
	@PostMapping("/notes")
	public Note createNote(@Valid @RequestBody Note note) {
		return noteRepository.save(note);
	}
	// Get a single Note
	@GetMapping("/note/{id}")
	public Note getNoteById(@PathVariable(value = "id") int noteId) {
		return noteRepository.findById(noteId).orElseThrow(()-> new ResourceNotFoundException("Note", "id", noteId));
	}
	// update a Note
	@PutMapping("/note/{id}")
	public Note updateNote(@PathVariable(value = "id") int noteId, @Valid@RequestBody Note noteDetails) {
		Note note = noteRepository.findById(noteId).orElseThrow(()-> new ResourceNotFoundException("Note", "id", noteId));
		note.setTittle(noteDetails.getTittle());
		note.setContent(noteDetails.getContent());
		Note updatedNote = noteRepository.save(note);
		return updatedNote;
	}
	// Delete a Note
	@DeleteMapping("/note/{id}")
	public ResponseEntity<?> deleteNote(@PathVariable(value = "id") int noteId) {
		Note note = noteRepository.findById(noteId).orElseThrow(()-> new ResourceNotFoundException("Note", "id", noteId));
		noteRepository.delete(note);
		return ResponseEntity.ok().build();
	}
}
