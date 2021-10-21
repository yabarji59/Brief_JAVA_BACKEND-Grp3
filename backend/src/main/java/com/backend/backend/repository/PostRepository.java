import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

/**
 * This interface calls CRUD methods from the Spring Dao it extends, passing them a
 * {@ link com.backend.backend.model.Post} object from the Model package.
 * 
 * @see {@link org.springframework.data.repository.CrudRepository}
 * @see {@link org.springframework.stereotype.Repository}
 * 
 * @author Group3
 */
@Repository
interface PostRepository extends CrudRepository<Post,Integer> {

}