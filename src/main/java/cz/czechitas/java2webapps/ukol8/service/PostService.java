package cz.czechitas.java2webapps.ukol8.service;

import cz.czechitas.java2webapps.ukol8.entity.Post;
import cz.czechitas.java2webapps.ukol8.repository.PostRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;


@Service
public class PostService {
    private final PostRepository postRepository;

    @Autowired
    public PostService(PostRepository postRepository) {
        this.postRepository = postRepository;
    }

//    metoda list(), která vrací stránkový seznam všech postů v DB, stránkování po 20, třídění sestupně

    public Page<Post> list() {
        Pageable pageable = PageRequest.of(0, 20, Sort.by("published").descending());
        return postRepository.findALLPublished(pageable);
    }

//    metoda singlePost(String slug), která najde a vrátí jeden post podle zadaného slug

    public Page<Post> singlePost (String slug, Pageable pageable) {
        return postRepository.findBySlug(slug, pageable);
    }

}
