package com.coderandyli.demo;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * Created by lizhen on 2019-03-20
 */
@RestController
@RequestMapping("/cpu")
public class CPUController {

    /**
     * 死循环
     */
    @GetMapping("/loop")
    public void loop() {
        while (true) {
            System.out.println("It's an endless loop");
        }
    }

}
