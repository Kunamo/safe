package ch.elias.safe.controllers;

import ch.elias.safe.services.RSAService;
import org.hibernate.boot.model.relational.Sequence;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class RSAController {
    @Autowired
    RSAService rsaService;

    // Always need to do that on boot
    @GetMapping("/createKeys")
    public void createPrivatePublickey() {
        rsaService.createKeys();
    }

    // Only using it for debugging
    @PostMapping("/encrypt")
    public String encryptMessage(@RequestBody String plainString) {
        return rsaService.encrypt(plainString);
    }

    // Only using it for debugging
    @PostMapping("/decrypt")
    public String decryptMessage(@RequestBody String encryptString) {
        return rsaService.decrypt(encryptString);
    }


}
