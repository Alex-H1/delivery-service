package sql;


import model.Order;

import java.util.List;

public interface IOrderDAO extends IBaseDAO<Order> {

    List<Order> getOrderByDeliveryEmployee(int id);

}
