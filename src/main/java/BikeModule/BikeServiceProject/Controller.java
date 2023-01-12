package BikeModule.BikeServiceProject;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class Controller
{
    @Autowired
    BikeDetailsService service;

    //---http://localhost:8080/newbikedetails
    @PostMapping("/newbikedetails")
    public String makecreate(@RequestBody Bikedetails bikes)
    {
        return service.create(bikes).getCusName()+"has been added in database successfully";
    }
}
