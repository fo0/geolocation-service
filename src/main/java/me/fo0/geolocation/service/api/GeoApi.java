package me.fo0.geolocation.service.api;

import com.maxmind.geoip2.model.CountryResponse;
import lombok.RequiredArgsConstructor;
import me.fo0.geolocation.service.GeoLocationService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
@RequestMapping("geo-api")
public class GeoApi {
  private final GeoLocationService service;

  @GetMapping("find-by-ip")
  public CountryResponse findByIp(@RequestParam String ip) {
    return service.countryResponse(ip);
  }

}
