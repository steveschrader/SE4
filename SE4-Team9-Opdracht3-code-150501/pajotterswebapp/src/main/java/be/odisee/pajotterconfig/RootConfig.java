package be.odisee.pajotterconfig;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.ComponentScan.Filter;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.FilterType;
import org.springframework.context.annotation.Import;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import be.odisee.pajotterconfig.*;

@Configuration
@Import({DataConfig.class, SecurityConfig.class})
@ComponentScan(basePackages = {"be.odisee.pajotter"}, 
    excludeFilters = {
        @Filter(type = FilterType.ANNOTATION, value = EnableWebMvc.class)
    })
public class RootConfig {
}