package BikeModule.BikeServiceProject;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonFormat;
import jakarta.annotation.Nullable;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Date;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
public class Bikedetails
{
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int cusId;
    private String cusbikeno;
    private String cusName;
    private long cusContactno;
    private String cusEmail;
    @JsonFormat(pattern = "yyyy-mm-dd")
    private Date DateofPurchase;
    @OneToMany(cascade = CascadeType.ALL,fetch = FetchType.LAZY)
    @Nullable
    @JsonBackReference
    @JoinTable(name = "AllRecords",joinColumns = @JoinColumn(name = "CustomerId"),inverseJoinColumns = @JoinColumn(name = "ServiceId"))
    private Collection<ServiceDetails> myservicedetails=new ArrayList<>();

}
