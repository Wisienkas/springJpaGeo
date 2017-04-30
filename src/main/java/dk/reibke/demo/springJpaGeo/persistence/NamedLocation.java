package dk.reibke.demo.springJpaGeo.persistence;

import com.vividsolutions.jts.geom.Point;
import org.hibernate.annotations.*;

import javax.persistence.*;
import javax.persistence.Entity;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;

/**
 * Created by Nikolaj Schaldemose Reibke on 4/30/17.
 */
@Entity
@NamedQueries({
        @NamedQuery(name = "NamedLocation.findNearest",
                query = "SELECT id, name, point\n" +
                        "FROM NamedLocation\n" +
                        "ORDER BY ST_Distance(point, ST_MakePoint(:lat, :lon)) ASC")
})
public class NamedLocation {
    
    /**
     * Automatic ID generator, also primary key as stated by @Id
     */
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    
    /**
     * Hibernate dont put qoutes around names, causing errors
     */
    @Column(name = "\"name\"")
    private String name;
    
    /**
     * jts_geometry will map the point type to a Geometry of the postgis type for a postgresql database with postgis
     */
    @Column(name = "\"point\"")
    @Type(type = "jts_geometry")
    private Point point;
    
    
    public NamedLocation(String name, Point point) {
        this.name = name;
        this.point = point;
    }
    
    public NamedLocation() {
    }
    
    public long getId() {
        return id;
    }
    
    public void setId(long id) {
        this.id = id;
    }
    
    public String getName() {
        return name;
    }
    
    public void setName(String name) {
        this.name = name;
    }
    
    public Point getPoint() {
        return point;
    }
    
    public void setPoint(Point point) {
        this.point = point;
    }
}
