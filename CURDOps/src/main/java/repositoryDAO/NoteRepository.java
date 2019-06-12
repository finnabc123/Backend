package repositoryDAO;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.curdOps.DTO.Note;

@Repository
public interface NoteRepository extends JpaRepository<Note, Integer> {

}
