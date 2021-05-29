package cz.czechitas.java2webapps.ukol8.repository;

import cz.czechitas.java2webapps.ukol8.entity.Post;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.time.LocalDate;

@Repository
public interface PostRepository extends JpaRepository<Post, Long> {

//    vyber posty dle zvolného slug
    @Query("SELECT p FROM Post p WHERE p.slug = ?1")
    Page<Post> findBySlug(String slug, Pageable pageable);

//    vyber posty, které obsahují datum publikace a nejsou v budoucnosti
    @Query("SELECT p FROM Post p WHERE p.published <= NOW()")
    Page<Post> findALLPublished(Pageable pageable);

}
