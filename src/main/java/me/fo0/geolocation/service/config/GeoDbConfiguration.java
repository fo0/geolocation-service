package me.fo0.geolocation.service.config;

import static me.fo0.geolocation.service.config.GeoDbProperties.PROPERTY_PREFIX;

import com.maxmind.geoip2.DatabaseReader;
import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.springframework.boot.autoconfigure.condition.ConditionalOnProperty;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.io.Resource;

@Configuration
@ConditionalOnProperty(prefix = PROPERTY_PREFIX, value = {"enabled"}, matchIfMissing = true)
@RequiredArgsConstructor
@Log4j2
public class GeoDbConfiguration {
  private final GeoDbProperties properties;

  @Bean
  public DatabaseReader geoIpDatabaseReader() throws Exception {
    final Resource database = properties.getDatabase();
    log.info("loading database: {}", database.getURI());
    return new DatabaseReader.Builder(database.getInputStream()).build();
  }

}