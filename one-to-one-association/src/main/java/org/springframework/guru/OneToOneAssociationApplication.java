package org.springframework.guru;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.guru.domain.Address;
import org.springframework.guru.domain.Person;
import org.springframework.guru.repository.AddressRepository;
import org.springframework.guru.repository.PersonRepository;

@SpringBootApplication
public class OneToOneAssociationApplication {

    public static void main(String[] args) {
        SpringApplication.run(OneToOneAssociationApplication.class, args);
    }

    @Bean
    public CommandLineRunner mappingDemo(PersonRepository personRepository,
                                         AddressRepository addressRepository) {
        return args -> {


            Person person = new Person("Martin", "martin.page@example.com", "1234abcd");

            Address address = new Address("Lake victoria", "Berlin", "Berlin",
                    "95781", "DE");

            address.setPerson(person);
            person.setAddress(address);
            personRepository.save(person);
        };
    }
}


