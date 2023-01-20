package BikeModule.BikeServiceProject;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BikeDetailsService
{
    @Autowired //Object creation
    BikedetailsRepositary repo;

    public Bikedetails create(Bikedetails bike)
    {
        return repo.save(bike);
    }

    public String erasing(int id)
    {
        Bikedetails temp=repo.findById(id).orElse(new Bikedetails());
        repo.delete(temp);
        return temp.getCusName()+"has deleted succcessfully";
    }
    //FindAll Values
    public List<Bikedetails> makeFetchAll()
    {
        return (List<Bikedetails>) repo.findAll();
    }

}
