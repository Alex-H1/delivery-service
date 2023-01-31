package mybatis.interfaces;

import model.PackageType;

import java.util.List;

public interface IPackageTypeDAO {

    List<PackageType> getPackageTypeByName(String name);

}
