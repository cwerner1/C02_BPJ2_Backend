import org.springframework.context.annotation.Bean;
import org.springframework.context.support.PropertySourcesPlaceholderConfigurer;
import org.springframework.core.io.ClassPathResource;
import org.springframework.core.io.Resource;

public class PropertiesUtils {

    public static final String SPRING_PROFILES_ACTIVE = "spring.profiles.active";

    public static void initProperties() {
        String activeProfile = System.getProperty(SPRING_PROFILES_ACTIVE);
        if (activeProfile == null) {
            activeProfile = "dev";
        }
        // Switch between windows for mssql
        // and limux && mac for mysql
System.out.println(System.getProperty("os.name"));
        PropertySourcesPlaceholderConfigurer propertySourcesPlaceholderConfigurer
                = new PropertySourcesPlaceholderConfigurer();
        Resource[] resources = new ClassPathResource[]
                {new ClassPathResource("application.properties"),
                        new ClassPathResource("application-" + activeProfile + ".properties")};
        propertySourcesPlaceholderConfigurer.setLocations(resources);

    }

}