package BikeModule.BikeServiceProject;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

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

    @PutMapping("/update")
    public String updating(@RequestBody Bikedetails bikes)
    {
        Bikedetails temp=service.create(bikes);
        return temp.getCusName()+" has been updated successfully";
    }
    @DeleteMapping("/Delete/{key}")
    public String deleting(@PathVariable("key")int key)
    {
        return  service.erasing(key);
    }

    @GetMapping("/sample")
    public void Sample()
    {
        System.out.println("Welcome to BackEnd");
    }

    @GetMapping("/")
    public List<Bikedetails> ListAll()
    {
        return service.makeFetchAll();
    }
    @GetMapping("/Listone/{id}")
    public Bikedetails listone(@PathVariable("id")int id)
    {
        return service.Gettingone(id);
    }
}
