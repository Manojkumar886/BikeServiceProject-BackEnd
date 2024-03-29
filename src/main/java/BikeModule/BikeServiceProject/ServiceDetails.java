package BikeModule.BikeServiceProject;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.Date;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
public class ServiceDetails
{
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int bikeJobcardno;
    private String[] bikeIssues;
    @JsonFormat(pattern = "yyyy-mm-dd")
    private Date bikeDateofservice;
    private int bikeKilometer;
    private String bikeStatus;//Approved,Processing,Cancel
    private String bikeTypeofservice;//free,paid
    private int bikeEstimateCharge;
    private int bikeNewproductcost;
    private int bikeLabourcharge;
    @Column(name = "bikeServicetotalamount")
    private int bikeFinalpay;
    @ManyToOne(fetch = FetchType.EAGER,cascade = CascadeType.ALL)
    @JoinColumn(name = "BikeCustomerID")
//    @JsonIgnoreProperties(value = {"service_details","hibernateLazyInitializer"})
    private  Bikedetails bikeDetails1;

}
