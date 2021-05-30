package cz.czechitas.java2webapps.ukol8.service;

import cz.czechitas.java2webapps.ukol8.entity.Post;
import cz.czechitas.java2webapps.ukol8.repository.PostRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.*;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;


@Service
public class PostService {
    private final PostRepository postRepository;
    private Pageable pageable;

    @Autowired
    public PostService(PostRepository postRepository) {
        this.postRepository = postRepository;
    }


//    metoda list(), která vrací stránkový seznam všech postů v DB, stránkování po 20, třídění sestupně

    public Page<Post> list() {
       final Pageable pageable = PageRequest.of(0, 20, Sort.by("published").descending());
        return postRepository.findALLPublished(pageable);
    }

//    metoda singlePost(String slug), která najde a vrátí jeden post podle zadaného slug

    public Post singlePost (String slug) {
        return postRepository.findBySlug(slug);
    }

}
