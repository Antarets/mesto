package com.example.mesto.controller;

import com.example.mesto.entity.Property;
import com.example.mesto.entity.User;
import com.example.mesto.model.PropertyDTO;
import com.example.mesto.service.PropertyService;
import com.example.mesto.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/properties")
@RequiredArgsConstructor
public class PropertyController {
    private final PropertyService propertyService;
    private final UserService userService;

    @PostMapping
    public ResponseEntity<Property> createProperty(@RequestBody Property property, @RequestParam Long landlordId) {
        User landlord = userService.getUserById(landlordId);
        property.setLandlord(landlord);
        return ResponseEntity.ok(propertyService.createProperty(property));
    }

    @GetMapping("/{id}")
    public ResponseEntity<Property> getPropertyById(@PathVariable Long id) {
        return ResponseEntity.ok(propertyService.getPropertyById(id));
    }

    @GetMapping
    public ResponseEntity<List<Property>> getAllProperties() {
        return ResponseEntity.ok(propertyService.getAllProperties());
    }

    @PutMapping("/{id}")
    public ResponseEntity<Property> updateProperty(@PathVariable Long id, @RequestBody PropertyDTO propertyDTO) {
        Property propertyDetails = new Property();
        propertyDetails.setTitle(propertyDTO.getTitle());
        propertyDetails.setDescription(propertyDTO.getDescription());
        propertyDetails.setAddress(propertyDTO.getAddress());
        propertyDetails.setCapacity(propertyDTO.getCapacity());
        propertyDetails.setType(propertyDTO.getType());
        propertyDetails.setAvailabilityHours(propertyDTO.getAvailabilityHours());
        propertyDetails.setFeatures(propertyDTO.getFeatures());
        propertyDetails.setContactName(propertyDTO.getContactName());
        propertyDetails.setContactPhone(propertyDTO.getContactPhone());
        propertyDetails.setContactEmail(propertyDTO.getContactEmail());
        propertyDetails.setPricePerHour(propertyDTO.getPricePerHour());
        return ResponseEntity.ok(propertyService.updateProperty(id, propertyDetails));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteProperty(@PathVariable Long id) {
        propertyService.deleteProperty(id);
        return ResponseEntity.noContent().build();
    }
}
