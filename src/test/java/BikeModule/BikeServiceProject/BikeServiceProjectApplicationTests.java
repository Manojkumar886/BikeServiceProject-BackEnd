package BikeModule.BikeServiceProject;

import org.junit.Assert;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.Date;
import java.util.stream.Collectors;
import java.util.stream.Stream;

@SpringBootTest
@RunWith(SpringRunner.class)
class BikeServiceProjectApplicationTests
{
	@Autowired
	BikeDetailsService service;

	@MockBean
	BikedetailsRepositary repo;

	@Test
	public void testing1()
	{
		Date d=new Date(2001,10,12);

		Bikedetails bike=new Bikedetails(1,"TN34V5063","Manojkumar",9789355930L,"manojgeetha@gmail.com",d,null);

		Mockito.when(repo.findAll()).thenReturn(Stream.of(bike).collect(Collectors.toList()));

		Assert.assertSame(d,service.makeFetchAll().get(0).getDateofpurchase());


	}


}
