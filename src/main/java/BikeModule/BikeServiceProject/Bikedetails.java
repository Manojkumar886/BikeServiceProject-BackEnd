package BikeModule.BikeServiceProject;

import com.fasterxml.jackson.annotation.JsonFormat;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

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
    private Date DateofPurchase;

}
