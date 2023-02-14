package BikeModule.BikeServiceProject;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ServiceDetailsService {
    @Autowired
    ServiceDetailsRepositary Srepo;

    public ServiceDetails newservice(ServiceDetails service) {
        return Srepo.save(service);
    }

    public List<ServiceDetails> GetAllServiceDetails(Bikedetails bike) {
        return Srepo.findAllBybikeDetails1(bike);
    }

    public List<ServiceDetails> GetTypeofService(String type) {
        return Srepo.findAllBybikeTypeofservice(type);
    }

    public Optional<ServiceDetails> GettingExactInService(int jobcardNo) {
        return Srepo.findById(jobcardNo);
    }

    public List<ServiceDetails> ImpleDates(String d1,String d2)
    {
        return Srepo.findAllBybikeDateofservice(d1,d2);
    }



}
