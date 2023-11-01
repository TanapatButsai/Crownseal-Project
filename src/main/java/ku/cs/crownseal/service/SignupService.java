package ku.cs.crownseal.service;

import ku.cs.crownseal.entity.Member;
import ku.cs.crownseal.model.SignupRequest;
import ku.cs.crownseal.repository.CustomerRepository;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;


@Service


public class SignupService {

    @Autowired
    private CustomerRepository repository;


    @Autowired
    private PasswordEncoder passwordEncoder;

    @Autowired
    private ModelMapper modelMapper;
    public boolean isUsernameAvailable(String username) {
        return repository.findByUsername(username) == null;
    }


    public void createUser(SignupRequest customer) {
        Member record =  modelMapper.map(customer, Member.class);

        record.setRole("ROLE_CUSTOMER");


        String hashedPassword = passwordEncoder.encode(customer.getPassword());
        record.setPassword(hashedPassword);


        repository.save(record);
    }

    public void createEngineer(SignupRequest customer) {
        Member record =  modelMapper.map(customer, Member.class);

        record.setRole("ROLE_ENGINEER");


        String hashedPassword = passwordEncoder.encode(customer.getPassword());
        record.setPassword(hashedPassword);


        repository.save(record);
    }


    public Member getUser(String username) {
        return repository.findByUsername(username);
    }

}
