package com.multbroker.corretoras.dto;

import com.multbroker.models.Brokerage;
import lombok.*;
import java.io.Serializable;
import java.math.BigDecimal;

@AllArgsConstructor
@ToString(exclude="id")
@EqualsAndHashCode
@Data
public class BrokeragePainelDTO implements Serializable {

    private static final long serialVersionUID = 1L;

     private Long id;
     private String name;
     private BigDecimal swingTrade;
     private BigDecimal dayTrade;
     private String status;

    public BrokeragePainelDTO() {}

    public BrokeragePainelDTO(Brokerage objBrokerage) {
        super();
        id = objBrokerage.getId();
        name = objBrokerage.getName();
        status = objBrokerage.getStatus();
        swingTrade = objBrokerage.getSwingTrade();
        dayTrade = objBrokerage.getDayTrade();
    }
}
