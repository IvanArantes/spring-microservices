package br.com.ia.microservicecourseinit.filter;

import br.com.ia.microservicecourseinit.model.Order;
import com.fasterxml.jackson.databind.ser.FilterProvider;
import com.fasterxml.jackson.databind.ser.impl.SimpleBeanPropertyFilter;
import com.fasterxml.jackson.databind.ser.impl.SimpleFilterProvider;
import org.springframework.http.converter.json.MappingJacksonValue;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.time.LocalDate;

@RestController("/filter")
public class FilteringController {


    @GetMapping("/teste")
    public Order getOrder5(){
        return new Order(2, LocalDate.now(), "Allan21");
    }


    @GetMapping
    public MappingJacksonValue getOrder(){
        Order orderTest = new Order(1, LocalDate.now(), "Ivan");
        SimpleBeanPropertyFilter filter = SimpleBeanPropertyFilter.filterOutAllExcept("userName", "id");
        FilterProvider filters = new SimpleFilterProvider()
                .addFilter("orderFilter",filter);
        MappingJacksonValue mapping = new MappingJacksonValue(orderTest);
        mapping.setFilters(filters);
        return mapping;
    }

}
