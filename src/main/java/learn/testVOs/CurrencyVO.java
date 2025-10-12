package learn.testVOs;

import jakarta.persistence.Entity;
import jakarta.persistence.Table;
import lombok.Getter;
import lombok.Setter;

@Table(name = "currency")
@Entity
@Getter
@Setter
public class CurrencyVO extends BaseVO {
    private String currency;
    private double nav;
}
