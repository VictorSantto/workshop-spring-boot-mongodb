package com.victorsantos.workshopmogo.services;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.victorsantos.workshopmogo.domain.Post;
import com.victorsantos.workshopmogo.repository.PostRepository;
import com.victorsantos.workshopmogo.services.exception.ObjectNotFoundException;

@Service
public class PostService {
	
	@Autowired
	private PostRepository repo;
	
	
	public Post findById(String id) {
		Optional<Post> obj = repo.findById(id);
		return obj.orElseThrow(() -> new ObjectNotFoundException("Objeto não encontrado"));
	}
	
//	public Post findById(String id) {
//		Post post = repo.findOne(id);
//		if (post == null) {
//			throw new ObjectNotFoundException("Objeto não encontrado");
//		}
//		return post;
//	}
}
