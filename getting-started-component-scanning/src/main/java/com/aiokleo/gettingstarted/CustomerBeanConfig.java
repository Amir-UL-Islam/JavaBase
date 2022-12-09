//A stateless system sends a request to the server and relays the response (or the state)
// back without storing any information.
// On the other hand, stateful systems expect a response, track information, and resend the request
// if no response is received.

package com.aiokleo.gettingstarted;

import org.springframework.beans.factory.annotation.Configurable;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;

//The container will Create the Object for Us
@Configurable // Class Level Annotation
@ComponentScan(basePackages = {"com.aiokleo.gettingstarted"}) // basePackages = {} will Scan ALL the Classes
                                                                // UNDER com.aiokleo.gettingstarted Package
                                                                // And we need to add the component Annotation
                                                                // (Where to find the COMPONENT)
                                                                // In this case The AccountDetails Class
public class CustomerBeanConfig {
}
