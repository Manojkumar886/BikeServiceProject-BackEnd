package BikeModule.BikeServiceProject;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.lang.Nullable;

import javax.persistence.*;
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
    private String cusBikeno;
    private String cusName;
    private long cusContactno;
    private String cusEmail;
    @JsonFormat(pattern = "yyyy-mm-dd")
    private Date Dateofpurchase;
    @OneToMany(cascade = CascadeType.ALL,fetch = FetchType.LAZY)
    @Nullable
    @JsonBackReference
    @JoinTable(name = "AllRecords",joinColumns = @JoinColumn(name = "CustomerId"),inverseJoinColumns = @JoinColumn(name = "ServiceId"))
    private Collection<ServiceDetails> myservicedetails=new ArrayList<>();

}
