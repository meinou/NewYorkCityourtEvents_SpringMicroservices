package social.social;

import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.ViewControllerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;

@Configuration
public class CustomWebMvcConfigurerAdapter extends WebMvcConfigurerAdapter {

    @Override
    public void addViewControllers(ViewControllerRegistry registry) {
        registry.addViewController("").setViewName("forward:/app/index.html");
        registry.addViewController("/").setViewName("forward:/app/index.html");
        registry.addViewController("/app").setViewName("redirect:/app/");
        registry.addViewController("/app/").setViewName("forward:/app/index.html");
        super.addViewControllers(registry);
    }
}