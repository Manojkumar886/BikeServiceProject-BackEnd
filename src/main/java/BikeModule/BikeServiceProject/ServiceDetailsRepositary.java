package BikeModule.BikeServiceProject;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ServiceDetailsRepositary extends JpaRepository<ServiceDetails,Integer>
{
    //findByID-primary ,display for only one value
    //findAll-list all
    //findAllByBikeDetails1-

    public List<ServiceDetails> findAllBybikeDetails1(Bikedetails bike);

    public List<ServiceDetails> findAllBybikeTypeofservice(String type);

    @Query(value = "select * from service_details where bike_dateofservice between :startDate and :endDate",nativeQuery = true)
    public List<ServiceDetails> findAllBybikeDateofservice(String startDate,String endDate);

    

}
