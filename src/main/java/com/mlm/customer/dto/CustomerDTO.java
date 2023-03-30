package com.mlm.customer.dto;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.mlm.customer.repository.model.Customer;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class CustomerDTO {

    private Long id;
    private String firstName;
    private String lastName;
    private String mail;
    @JsonIgnore
    private Integer age;

    // Metodo di utilità per la conversione da entità JPA a DTO
    public static CustomerDTO fromEntity(Customer customer) {
        return new CustomerDTO(customer.getId(), 
        		customer.getFirstName(), 
        		customer.getLastName(), 
        		customer.getLastName()+"."+customer.getFirstName()+"@email.com",
        		customer.getAge());
    }

    // Metodo di utilità per la conversione da DTO a entità JPA
    public Customer toEntity() {
        Customer customer = new Customer();
        customer.setId(this.id);
        customer.setFirstName(this.firstName);
        customer.setLastName(this.lastName);
        customer.setAge(this.age);
        return customer;
    }
}

