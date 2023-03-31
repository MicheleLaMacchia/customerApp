package com.mlm.customer.dto;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.mlm.customer.repository.model.Customer;
import com.mlm.customer.repository.model.Product;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class CustomerDTO {

    private Long id;
    private String firstName;
    private String lastName;
    private String mail;
    private List<Product> products;
    @JsonIgnore
    private Integer age;

    // Metodo di utilità per la conversione da entità JPA a DTO
    public static CustomerDTO fromEntity(Customer customer, List<Product> products) {
        return new CustomerDTO(customer.getId(), 
        		customer.getFirstName(), 
        		customer.getLastName(), 
        		customer.getLastName()+"."+customer.getFirstName()+"@email.com",
        		products,
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

