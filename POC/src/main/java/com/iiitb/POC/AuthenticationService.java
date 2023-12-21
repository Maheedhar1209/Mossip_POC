package com.iiitb.POC;

//import com.iiitb.POC.models.User_Login;
//import com.iiitb.POC.repositories.UserLoginRepository;
import com.twilio.Twilio;
import org.springframework.stereotype.Service;

@Service
public class AuthenticationService {

    private static final String ACCOUNT_SID = "ACbcec39040fe22ddea4512e79e24b6c90"; //System.getenv("ACbc91ba0b1ce5b5020130385133c2ae46");
    private static final String AUTH_TOKEN = "2445d6bbd53302717d6b41df7d83e147"; //System.getenv("aa2cab81ac3f795ce2280dbe04659ef1");
  private String pass="1234";
    public void create_service() {
        Twilio.init(ACCOUNT_SID, AUTH_TOKEN);
        com.twilio.rest.verify.v2.Service service = com.twilio.rest.verify.v2.Service.creator("My First Verify Service").create();
        System.out.println("Verification Service Created!");
        System.out.println(service.getSid());
        String service_sid = service.getSid();
    }
    public String send_otp(String mobile_number,String password) {
//        Twilio.init(ACCOUNT_SID, AUTH_TOKEN);
//        Verification verification = Verification.creator(
//                        "MG7c6c635538504e7eff3166751c18343f",
//                        "+91"+mobile_number,
//                        "sms")
//                .create();
//        System.out.println(verification.getStatus());
//        return verification.getStatus();
        return "pending";
    }
    public String verify_otp(String password, String mobile_number) {
//        Twilio.init(ACCOUNT_SID, AUTH_TOKEN);
//   if (password
//        VerificationCheck verificationCheck = VerificationCheck.creator(
//                        "VAee7296006168aef06bef5ffa1148a553")
//                .setTo("+91"+mobile_number)
//                .setCode(otp)
//                .create();
//        System.out.println(verificationCheck.getStatus());
//        return verificationCheck.getStatus();
        if (pass.equals(password))
            return "approved";
        return "";
    }
}
