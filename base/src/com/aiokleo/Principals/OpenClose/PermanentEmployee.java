package com.aiokleo.Principals.OpenClose;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class PermanentEmployee extends Employee {
    private Boolean isPermanent;

    public PermanentEmployee(Long id, String name, Boolean isPermanent) {
        // by calling super() we are calling the constructor of the parent class
        // and Extending the functionality of the parent class
        // without modifying the parent class
        super(id, name);
        this.isPermanent = isPermanent;
    }
}
