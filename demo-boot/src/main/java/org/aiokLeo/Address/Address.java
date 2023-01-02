package org.aiokLeo.Address;

import lombok.*;
import org.springframework.stereotype.Component;

@Component
@Getter
@Setter
@AllArgsConstructor
@ToString
@NoArgsConstructor
public class Address {
    private int id;
    private String address;
    public void Compile(){
        System.out.println("Address is Rolling!");
    }

}
