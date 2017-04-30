package dk.reibke.demo.springJpaGeo;

import com.bedatadriven.jackson.datatype.jts.JtsModule;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * Created by Nikolaj Schaldemose Reibke on 4/30/17.
 */
@Configuration
public class JacksonConfig {

    @Bean
    JtsModule jtsModule() {
        return new JtsModule();
    }

}
