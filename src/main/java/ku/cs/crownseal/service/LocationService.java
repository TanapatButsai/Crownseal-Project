package ku.cs.crownseal.service;

import ku.cs.crownseal.entity.Location;
import ku.cs.crownseal.entity.Problem;
import ku.cs.crownseal.model.LocationRequest;
import ku.cs.crownseal.model.ProblemRequest;
import ku.cs.crownseal.repository.CustomerRepository;
import ku.cs.crownseal.repository.LocationRepository;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;

@Service
public class LocationService {

    @Autowired
    private LocationRepository locationRepository;

    @Autowired
    private CustomerRepository customerRepository;

    @Autowired
    private ModelMapper modelMapper;

    public void createLocation(LocationRequest locationRequest,String name) {
        Location record = modelMapper.map(locationRequest, Location.class);
        record.setMember(customerRepository.findByUsername(name));
        locationRepository.save(record);
    }
}
