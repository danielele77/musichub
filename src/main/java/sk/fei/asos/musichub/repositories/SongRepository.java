package sk.fei.asos.musichub.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import sk.fei.asos.musichub.models.Song;

import java.util.List;

@Repository
public interface SongRepository extends JpaRepository<Song,Long> {


    List<Song> findAllByName(String name);
    List<Song> findAll();

    List<Song> findAllByGenre(String genre);

}
