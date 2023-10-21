package hu.progmatic.orders.service;

import hu.progmatic.orders.model.OrderRecord;
import hu.progmatic.orders.repository.OrderRecordRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class OrderRecordService {

    @Autowired
    private OrderRecordRepository orderRecordRepository;


    public OrderRecord addOrder(OrderRecord orderRecord) {
        return orderRecordRepository.save(orderRecord);
    }

}
