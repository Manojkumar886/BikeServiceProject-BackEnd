package BikeModule.BikeServiceProject;

import com.fasterxml.jackson.annotation.JsonFormat;
import jakarta.annotation.Nullable;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
public class ServiceDetails
{
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
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
    @ManyToOne(fetch = FetchType.LAZY,cascade = CascadeType.ALL)
    @JoinColumn(name = "BikeCustomerID")
    @Nullable
    private  Bikedetails bikeDetails1;

}
