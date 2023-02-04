package ee.biceps.api.config;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.CacheControl;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.DefaultServletHandlerConfigurer;

import java.time.Duration;

@EnableWebMvc
@Configuration
@ComponentScan({
        "ee.biceps.api.controller",
        "ee.biceps.generated.api"})
public class WebConfig implements WebMvcConfigurer {
    // for static resources, make it look into swagger-ui folder
    @Override
    public void addResourceHandlers(ResourceHandlerRegistry registry) {
        // I have no idea how pathPatterns works
        registry.addResourceHandler("/")
                .addResourceLocations("/swagger-ui/")
                .setCacheControl(CacheControl.maxAge(Duration.ofDays(365)));
    }

    // If DispatcherServlet overwrites default servlet path, then re-enable default servlet
    @Override
    public void configureDefaultServletHandling(DefaultServletHandlerConfigurer configurer) {
        configurer.enable();
    }
}
