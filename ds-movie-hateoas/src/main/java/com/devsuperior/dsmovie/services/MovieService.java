package com.devsuperior.dsmovie.services;

import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.linkTo;
import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.methodOn;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.devsuperior.dsmovie.controllers.MovieController;
import com.devsuperior.dsmovie.dto.MovieDTO;
import com.devsuperior.dsmovie.entities.Movie;
import com.devsuperior.dsmovie.repositories.MovieRepository;
import com.devsuperior.dsmovie.services.exceptions.DatabaseException;
import com.devsuperior.dsmovie.services.exceptions.ResourceNotFoundException;

import jakarta.persistence.EntityNotFoundException;

@Service
public class MovieService {

	@Autowired
	private MovieRepository repository;

	@Transactional(readOnly = true)
	public Page<MovieDTO> findAll(Pageable pageable) {
		Page<Movie> result = repository.findAll(pageable);
		Page<MovieDTO> page = result.map(x -> new MovieDTO(x)
				.add(linkTo(methodOn(MovieController.class).findAll(null)).withSelfRel())
				.add(linkTo(methodOn(MovieController.class).findById(x.getId())).withRel("GET - Movie by Id")));
		return page;
	}

	@Transactional(readOnly = true)
	public MovieDTO findById(Long id) {
		Movie result = repository.findById(id)
				.orElseThrow(() -> new ResourceNotFoundException("Recurso não encontrado"));
		
		MovieDTO dto = new MovieDTO(result)
							.add(linkTo(methodOn(MovieController.class).findById(id)).withSelfRel())
							.add(linkTo(methodOn(MovieController.class).findAll(null)).withRel("GET - Movies"))
							.add(linkTo(methodOn(MovieController.class).update(id, null)).withRel("PUT - Update movie"))
							.add(linkTo(methodOn(MovieController.class).delete(id)).withRel("DELETE - Delete movie"));
		return dto;
		//return new MovieDTO(result).add(linkTo(methodOn(MovieController.class).findAll(null)).withRel("Movies List"));
	}
	
	@Transactional
	public MovieDTO insert(MovieDTO dto) {
		Movie entity = dto.toEntity();
		entity = repository.save(entity);
		return new MovieDTO(entity).add(linkTo(methodOn(MovieController.class).findById(entity.getId())).withRel("GET - Movie by Id"));
	}

	@Transactional
	public MovieDTO update(Long id, MovieDTO dto) {
		try {
			Movie entity = repository.getReferenceById(id);
			copyDtoToEntity(dto, entity);
			entity = repository.save(entity);
			return new MovieDTO(entity).add(linkTo(methodOn(MovieController.class).findById(entity.getId())).withRel("GET - Movie by Id"));
		} catch (EntityNotFoundException e) {
			throw new ResourceNotFoundException("Recurso não encontrado");
		}
	}

	@Transactional(propagation = Propagation.SUPPORTS)
	public void delete(Long id) {
		try {
			repository.deleteById(id);
		} catch (EmptyResultDataAccessException e) {
			throw new ResourceNotFoundException("Recurso não encontrado");
		} catch (DataIntegrityViolationException e) {
			throw new DatabaseException("Falha de integridade referencial");
		}
	}

	private void copyDtoToEntity(MovieDTO dto, Movie entity) {
		entity.setTitle(dto.getTitle());
		entity.setScore(dto.getScore());
		entity.setCount(dto.getCount());
		entity.setImage(dto.getImage());
	}
}