package com.sat.utility;

import com.sat.entity.Employee;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;

public class SecurityHelper {

    public static Long getEmployeeId(){
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        Employee user = (Employee) authentication.getPrincipal();
        return user.getId();
    }

}
