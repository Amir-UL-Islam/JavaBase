//A stateless system sends a request to the server and relays the response (or the state)
// back without storing any information.
// On the other hand, stateful systems expect a response, track information, and resend the request
// if no response is received.

package com.aiokleo.gettingstarted;

import org.springframework.beans.factory.annotation.Configurable;
import org.springframework.context.annotation.Bean;

//The container will Create the Object for Us
@Configurable // Class Level Annotation
public class CustomerBeanConfig {
    @Bean // Method level Annotation
//    @Bean("AC")
//    If we DON'T mention the REFERENCE in @Bean. Then the OBJECT REFERENCE will be "accountDetails"
    public AccountDetails accountDetails(){ // USING  "accountDetails" as REFERENCE in TestGetSet.java File
        return new AccountDetails();
    }
}
