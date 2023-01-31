package mybatis.interfaces;

import model.Package;

public interface IPackageDAO {

    Package getPackageByTrackingNumber(String num);

}
