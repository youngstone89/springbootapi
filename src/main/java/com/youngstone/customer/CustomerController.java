package com.youngstone.customer;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class CustomerController {

    @Autowired
    private CustomerDAO customerDAO;


    @GetMapping("/customers")
    public List getCustomers(){
        return customerDAO.getCustomers();
    }

    @GetMapping("/customers/{id}")
    public ResponseEntity getCustomer(@PathVariable("id") Long id){
        Customer customer = customerDAO.get(id);
        if( customer == null){
            return new ResponseEntity("No Customer Found for ID" +id,HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity(customer,HttpStatus.OK);
    }

    @PostMapping(value = "/customers")
    public ResponseEntity createCustomer(@RequestBody Customer customer){
        customerDAO.create(customer);
        return new ResponseEntity(customer,HttpStatus.OK);
    }

    @DeleteMapping("/customers/{id}")
    public ResponseEntity deleteCustomer(@PathVariable Long id){
        if(null == customerDAO.delete(id)){
            return new ResponseEntity("No Customer Found for ID" +id,HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity(id, HttpStatus.OK);
    }

    @PutMapping("/customers/{id}")
    public ResponseEntity updateCustomer(@PathVariable Long id, @RequestBody Customer customer){

        customer = customerDAO.update(id,customer);
        if( null == customer){
            return new ResponseEntity("No customer found for ID"+id, HttpStatus.OK);
        }
        return new ResponseEntity(customer,HttpStatus.OK);
    }
}
