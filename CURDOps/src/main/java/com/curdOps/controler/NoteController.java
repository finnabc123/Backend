package com.curdOps.controler;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.curdOps.DTO.Note;

import repositoryDAO.NoteRepository;

@RestController
@RequestMapping("/api")
public class NoteController {

	@Autowired
	NoteRepository noteRepository;

	// GetAll Notes
	@GetMapping("/notes")
	public List<Note> getAllNotes(){
		return noteRepository.findAll();
	}
	// Create New Note
	// Get a single Note
	// update a Note
	// Delete a Note
}
