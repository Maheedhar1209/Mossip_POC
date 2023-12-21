package com.iiitb.POC.JwtUtil;

import com.iiitb.POC.AuthenticationService;
//import com.iiitb.spe.models.User_Login;
//import com.iiitb.spe.repositories.UserLoginRepository;
import com.iiitb.POC.service.MovieDetailsService;
import com.iiitb.POC.JwtUtil.models.JwtResponseModel;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.web.bind.annotation.*;

import java.util.Objects;

@CrossOrigin(origins = "*")
@RestController

public class JwtController {

    private  final MovieDetailsService movieDetailsService;

  //  private final UserLoginRepository userlogin;
    private final AuthenticationService authenticationService;
    public JwtController(AuthenticationService authenticationService, MovieDetailsService movieDetailsService)
    {
        this.authenticationService = authenticationService;
        this.movieDetailsService=movieDetailsService;
       // this.userlogin = userlogin;
    }
    @Autowired
    private JwtUserDetailsService userDetailsService;
    @Autowired
    private AuthenticationManager authenticationManager;
    @Autowired
    private TokenManager tokenManager;


    @CrossOrigin
    @GetMapping("user/verifyOTP")
    public ResponseEntity createToken(@RequestParam String phone_number,@RequestParam String password,@RequestParam String age,@RequestParam String fathername) {

        String auth = this.authenticationService.verify_otp(password, phone_number);
        System.out.println("reached: "+ auth);

        if (Objects.equals(auth, "approved")) {

            System.out.println("entered");
            final UserDetails userDetails = userDetailsService.loadUserByUsername(phone_number);
            final String jwtToken = tokenManager.generateJwtToken(phone_number,password,age,fathername);
        System.out.println("hellso");
        //System.out.println(jwtToken);
        //System.out.println());
        return ResponseEntity.ok(new JwtResponseModel(jwtToken));

        }
        else
        {
            return ResponseEntity.ok(new JwtResponseModel("not"));
        }
        //return auth;
    }
    @CrossOrigin
    @GetMapping("user/father_name")
    public ResponseEntity createToken(@RequestParam String phone_number) {




            System.out.println("entered");

           // final UserDetails userDetails = userDetailsService.loadUserByUsername(phone_number);
            final String jwtToken = tokenManager.generateJwtToken1(phone_number);
            System.out.println("hellso");
            //System.out.println(jwtToken);
            //System.out.println());
            return ResponseEntity.ok(new JwtResponseModel(jwtToken));


        //return auth;
    }
    @CrossOrigin
    @GetMapping("user/age")
    public ResponseEntity createToken1(@RequestParam String phone_number) {




        System.out.println("entered");

        // final UserDetails userDetails = userDetailsService.loadUserByUsername(phone_number);
        final String jwtToken = tokenManager.generateJwtToken2(phone_number);
        System.out.println("hellso");
        //System.out.println(jwtToken);
        //System.out.println());
        return ResponseEntity.ok(new JwtResponseModel(jwtToken));


        //return auth;
    }

}
