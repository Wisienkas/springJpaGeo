package dk.reibke.demo.springJpaGeo.persistence.Repositories;

import com.vividsolutions.jts.geom.Point;
import dk.reibke.demo.springJpaGeo.persistence.NamedLocation;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import javax.persistence.NamedNativeQuery;

/**
 * Created by Nikolaj Schaldemose Reibke on 4/30/17.
 */
public interface NamedLocationService extends CrudRepository<NamedLocation, Long> {

}
