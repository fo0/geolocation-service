package me.fo0.geolocation.service.api;

import lombok.RequiredArgsConstructor;
import me.fo0.geolocation.service.GeoLocationService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
public class GeoApi {
  private final GeoLocationService service;

  @GetMapping
  public String findByIp(@RequestParam String ip) {
    return service.countryIsoCode(ip);
  }

}
