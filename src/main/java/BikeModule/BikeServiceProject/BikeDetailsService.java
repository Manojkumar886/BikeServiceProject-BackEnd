package BikeModule.BikeServiceProject;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class BikeDetailsService
{
    @Autowired //Object ceration
    BikedetailsRepositary repo;

    public Bikedetails create(Bikedetails bike)
    {
        return repo.save(bike);
    }


}
