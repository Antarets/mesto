package com.example.mesto.service;

import com.example.mesto.entity.Property;
import com.example.mesto.exception.ResourceNotFoundException;
import com.example.mesto.repository.PropertyRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class PropertyService {
    private final PropertyRepository propertyRepository;

    public Property createProperty(Property property) {
        return propertyRepository.save(property);
    }

    public Property getPropertyById(Long id) {
        return propertyRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Property not found with id " + id));
    }

    public List<Property> getAllProperties() {
        return propertyRepository.findAll();
    }

    public Property updateProperty(Long id, Property propertyDetails) {
        Property property = getPropertyById(id);
        property.setTitle(propertyDetails.getTitle());
        property.setDescription(propertyDetails.getDescription());
        property.setAddress(propertyDetails.getAddress());
        property.setCapacity(propertyDetails.getCapacity());
        property.setType(propertyDetails.getType());
        property.setAvailabilityHours(propertyDetails.getAvailabilityHours());
        property.setFeatures(propertyDetails.getFeatures());
        property.setContactName(propertyDetails.getContactName());
        property.setContactPhone(propertyDetails.getContactPhone());
        property.setContactEmail(propertyDetails.getContactEmail());
        property.setPricePerHour(propertyDetails.getPricePerHour());
        return propertyRepository.save(property);
    }

    public void deleteProperty(Long id) {
        propertyRepository.deleteById(id);
    }
}
