package com.coderandyli.monitor_tuning.chapter1;

import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * Created by lizhen on 2019-04-18
 */
@Slf4j
@RestController
@RequestMapping("/cpu")
public class CPUController {

    /**
     * 死循环
     *
     */
    @GetMapping("/loop")
    public void loop(){
        while (true){
            log.info("你到底爱不爱我，how old are you?");
        }
    }

   /* {
        "data": [{
        "partnerid": 982,
                "count": "10000",
                "cityid": "11"
    }, {
        "partnerid": 983,
                "count": "10000",
                "cityid": "11"
    }, {
        "partnerid": 984,
                "count": "10000",
                "cityid": "11"
    }]
    }*/

}
