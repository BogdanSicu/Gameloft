package bogdan.gameloft.controllers;

import bogdan.gameloft.models.campaign.Campaign;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/test")
public class TestController {

    @GetMapping()
    public String getTest() {
        return "test";
    }


}
