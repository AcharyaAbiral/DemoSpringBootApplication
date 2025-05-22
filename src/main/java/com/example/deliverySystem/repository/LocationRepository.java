package com.example.deliverySystem.repository;

import com.example.deliverySystem.dto.response.CityResponseDTO;
import com.example.deliverySystem.dto.response.CountryResponseDTO;
import com.example.deliverySystem.dto.response.StreetResponseDTO;
import com.example.deliverySystem.entity.Location;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;
import java.util.UUID;

public interface LocationRepository extends JpaRepository<Location, UUID> {

    @Query("SELECT DISTINCT new com.example.deliverySystem.dto.response.CountryResponseDTO(l.country) FROM Location l WHERE l.country LIKE CONCAT(:countryInitials, '%')")
    List<CountryResponseDTO> findByCountryInitials(@Param("countryInitials") String countryInitials);

    @Query("SELECT DISTINCT new com.example.deliverySystem.dto.response.CityResponseDTO(l.city) from Location l WHERE l.country=:country AND l.city LIKE CONCAT(:cityInitials,'%')")
    List<CityResponseDTO> findByCityInitials( @Param("country") String country,@Param("cityInitials") String cityInitials);

    @Query("SELECT DISTINCT new com.example.deliverySystem.dto.response.StreetResponseDTO(l.street) from Location l WHERE l.country=:country AND l.city=:city AND l.street LIKE CONCAT(:streetInitials,'%')")
    List<StreetResponseDTO> findByStreetInitials( @Param("country")String country,@Param("city")String city,@Param("streetInitials") String streetInitials);

    @Query("SELECT DISTINCT l from Location l WHERE l.country=:country AND l.city=:city AND l.street=:street")
    Location findLocationDetails(@Param("country") String country, @Param("city") String city,@Param("street") String street);

}
