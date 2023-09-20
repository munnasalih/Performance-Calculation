package com.example.SpringBootApp;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import java.util.ArrayList;
import java.util.List;
@RestController
public class CodeController {
    @Autowired
    CodeRepo codeRepo;

    @PostMapping("/saveCode")
    public long approveRecord(@RequestParam("digit") Long digit) {
        Long begin = System.currentTimeMillis();
        List<Code> codeList=new ArrayList<>();
        for(int i=0;i<digit;i++){
            Code code = new Code();
            code.setUniqueCode(getAlphaNumericString(7));
            codeList.add(code);
        }
        codeRepo.saveAll(codeList);
        Long end = System.currentTimeMillis();
        return end-begin;
    }

    @GetMapping("/getCodes")
    public List<Code>getCodes(){
        return codeRepo.findAll();
    }

    static String getAlphaNumericString(int n)
    {

        // choose a Character random from this String
        String AlphaNumericString = "ABCDEFGHIJKLMNOPQRSTUVWXYZ"
                + "0123456789"
                + "abcdefghijklmnopqrstuvxyz";

        // create StringBuffer size of AlphaNumericString
        StringBuilder sb = new StringBuilder(n);

        for (int i = 0; i < n; i++) {

            // generate a random number between
            // 0 to AlphaNumericString variable length
            int index
                    = (int)(AlphaNumericString.length()
                    * Math.random());

            // add Character one by one in end of sb
            sb.append(AlphaNumericString
                    .charAt(index));
        }

        return sb.toString();
    }
}