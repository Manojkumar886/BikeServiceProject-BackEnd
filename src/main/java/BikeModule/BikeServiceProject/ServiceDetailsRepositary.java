package BikeModule.BikeServiceProject;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ServiceDetailsRepositary extends JpaRepository<ServiceDetails,Integer>
{

}
