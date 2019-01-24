package com.se.team19.server.Controller;


import com.se.team19.server.Entity.Staff;
import com.se.team19.server.Repository.StaffRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
@CrossOrigin(origins = "http://localhost:4200")
public class LoginController {
    @Autowired
    StaffRepository staffRepository;

    @PostMapping("/Login")
    @CrossOrigin(origins = "http://localhost:4200")
    public void Staff(@RequestBody Staff login) throws Exception{
        Staff admin = staffRepository.findByUsername(login.getUsername());
        if (!loginAuth(login.getPassword().getBytes(),admin.getPassword().getBytes()))
            throw new Exception();
    }

    public boolean loginAuth(byte[] loginPassword,byte[] password){
        int result = 0;
        if(loginPassword.length != password.length)
            return false;
        else{
            for(int i = 0; i < loginPassword.length ; i++)
                result |= password[i] ^ loginPassword[i];
        }
        return  result == 0;
    }

}
