package mybatis.interfaces;

import model.Address;

public interface IAddressDAO extends IParentDAO<Address> {

    Address getAddressByAddress(String address);

}
