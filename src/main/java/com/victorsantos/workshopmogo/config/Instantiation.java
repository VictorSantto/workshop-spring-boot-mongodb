package com.victorsantos.workshopmogo.config;

import java.text.SimpleDateFormat;
import java.util.Arrays;
import java.util.TimeZone;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Configuration;

import com.victorsantos.workshopmogo.domain.Post;
import com.victorsantos.workshopmogo.domain.User;
import com.victorsantos.workshopmogo.dto.AuthorDTO;
import com.victorsantos.workshopmogo.dto.CommentDTO;
import com.victorsantos.workshopmogo.repository.PostRepository;
import com.victorsantos.workshopmogo.repository.UserRepository;

@Configuration
public class Instantiation implements CommandLineRunner {
	
	@Autowired
	private UserRepository userRepository;
	
	@Autowired
	private PostRepository postRepository;
	
	@Override
	public void run(String... args0) throws Exception {
		
		SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
		sdf.setTimeZone(TimeZone.getTimeZone("GMT"));
		
		userRepository.deleteAll();
		postRepository.deleteAll();
		
		
		User maria = new User(null, "Maria Brown", "maria@gmail.com");
		User alex = new User(null, "Alex Green", "alex@gmail.com");
		User bob = new User(null, "Bob Grey", "bob@gmail.com");
		
		userRepository.saveAll(Arrays.asList(maria, alex, bob));
		
		Post mariaBrown = new Post(null,sdf.parse("21/03/2018") , "Partiu viagem", "Vou viajar para São Paulo. Abraços!", new AuthorDTO(maria));
		Post mariaBrown1 = new Post(null, sdf.parse("23/03/2018"), "Bom dia", "Acordei feliz hoje!", new AuthorDTO(maria));
		
		CommentDTO c1 = new CommentDTO("Boa viagem mano!", sdf.parse("21/03/2018"), new AuthorDTO(alex));
		CommentDTO c2 = new CommentDTO("Aproveite", sdf.parse("22/03/2018"), new AuthorDTO(bob));
		CommentDTO c3 = new CommentDTO("Tenha um ótimo dia!", sdf.parse("23/03/2018"), new AuthorDTO(alex));
		
		mariaBrown.getComments().addAll(Arrays.asList(c1, c2));
		mariaBrown1.getComments().addAll(Arrays.asList(c3));
		
		postRepository.saveAll(Arrays.asList(mariaBrown, mariaBrown1));
		
		maria.getPosts().addAll(Arrays.asList(mariaBrown, mariaBrown1));
		userRepository.save(maria);
	}
	
}
