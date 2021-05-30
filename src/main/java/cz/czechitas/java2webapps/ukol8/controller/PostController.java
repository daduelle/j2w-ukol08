package cz.czechitas.java2webapps.ukol8.controller;

import cz.czechitas.java2webapps.ukol8.entity.Post;
import cz.czechitas.java2webapps.ukol8.repository.PostRepository;
import cz.czechitas.java2webapps.ukol8.service.PostService;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.util.UriComponentsBuilder;
import org.springframework.web.util.UrlPathHelper;

import javax.servlet.http.HttpServletRequest;
import javax.validation.Valid;
import java.util.Optional;

@Controller
public class PostController {
    private final PostService service;

    public PostController(PostService service) {
        this.service = service;
    }

    //zobrazení úvodní stránky se seznamem postů
    @GetMapping("/")
    public ModelAndView seznam(@PageableDefault Pageable pageable) {
        return new ModelAndView("index")
                .addObject("post", service.list());
    }

    @GetMapping("/post/{slug}")
    public ModelAndView detail (@PathVariable String slug) {
        return new ModelAndView("detail")
                .addObject("post", service.singlePost(slug));
    }

}


