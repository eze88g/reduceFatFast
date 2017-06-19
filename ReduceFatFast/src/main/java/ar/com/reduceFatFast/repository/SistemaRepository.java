/**
 * 
 */
package ar.com.reduceFatFast.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import ar.com.reduceFatFast.model.Sistema;

/**
 * @author joaco
 *
 */
@Repository
public interface SistemaRepository extends CrudRepository<Sistema, Long> {

}
