package mybatis.interfaces;


import model.Order;

import java.util.List;

public interface IOrderDAO extends IParentDAO<Order> {

    List<Order> getOrderByDeliveryEmployee(int id);

}
