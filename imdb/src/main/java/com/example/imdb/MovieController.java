package com.example.imdb;

import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@RequestMapping("/movies")
@CrossOrigin(origins = "*")
public class MovieController {

  private final MovieRepository repo;

  public MovieController(MovieRepository repo) {
    this.repo = repo;
  }

  @PostMapping("/add")
  public Movie addMovie(@RequestBody Movie movie) {
    return repo.save(movie);
  }

  @GetMapping("/list")
  public List<Movie> getAllMovies() {
    return repo.findAll();
  }

  @DeleteMapping("/delete/{id}")
  public void deleteMovie(@PathVariable Long id) {
    repo.deleteById(id);
  }
}
