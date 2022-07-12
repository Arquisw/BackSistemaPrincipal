package co.edu.uco.arquisw;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.jdbc.datasource.embedded.EmbeddedDatabaseBuilder;
import org.springframework.jdbc.datasource.embedded.EmbeddedDatabaseType;

import javax.sql.DataSource;

@ComponentScan({"co.edu.uco.arquisw"})
@EnableJpaRepositories(basePackages = "co.edu.uco.arquisw")
public class ApplicationMock
{
    @Bean
    public DataSource h2DataSource()
    {
        return new EmbeddedDatabaseBuilder().setType(EmbeddedDatabaseType.H2).build();
    }
}