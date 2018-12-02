package com.youngstone.customer;

import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
public class CustomerDAO {

    private static List<Customer> customers;
    {
        customers = new ArrayList();
        customers.add(new Customer(101L, "John", "Doe", "djohn@gmail.com", "121-232-3435"));
        customers.add(new Customer(201L, "Russ", "Smith", "sruss@gmail.com", "343-545-2345"));
        customers.add(new Customer(301L, "Kate", "Williams", "kwilliams@gmail.com", "876-237-2987"));
    }


    public List getCustomers() {
        return customers;
    }

    public Customer get(Long id){

        for(Customer c: customers){
            if(c.getId().equals(id)){
                return c;
            }
        }

        return null;
    }

    public Customer create(Customer customer){
        customers.add(customer);
        return customer;
    }


    public Long delete(Long id){
        for(Customer c: customers){
            if(c.getId().equals(id)){
                customers.remove(c);
                return id;
            }
        }
        return null;
    }

    public Customer update(Long id, Customer customer){
        for(Customer c: customers){
            if(c.getId().equals(id)){
                customer.setId(c.getId());
                customers.remove(c);
                customers.add(customer);
                return customer;
            }
        }
        return null;
    }
}


