package BikeModule.BikeServiceProject;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class Controller
{
    @Autowired
    BikeDetailsService service;

    @Autowired
    ServiceDetailsService Sservice;

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

    @PostMapping("/createservice")
    public ServiceDetails servicecreate(@RequestBody ServiceDetails serv)
    {
        Bikedetails temp=service.Gettingone(serv.getBikeDetails1().getCusId());
        if(serv.getBikeTypeofservice()=="free")
        {
            int total=serv.getBikeNewproductcost()+(serv.getBikeNewproductcost()*18/100);//600+80=680
            serv.setBikeFinalpay(total);
        }
        else {
            int total=serv.getBikeLabourcharge()+serv.getBikeNewproductcost();//800+900=1700
            total+=total*18/100;
            serv.setBikeFinalpay(total);
        }
        temp.getMyservicedetails().add(serv);
        serv.setBikeDetails1(temp);
        Sservice.newservice(serv);
        return serv;
    }
}
