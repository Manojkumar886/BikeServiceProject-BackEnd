package BikeModule.BikeServiceProject;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ServiceDetailsService
{
    @Autowired
    ServiceDetailsRepositary Srepo;
    public ServiceDetails newservice(ServiceDetails service)
    {
        return Srepo.save(service);
    }

}
