package sql;

import model.PackageType;

import java.util.List;

public interface IPackageTypeDAO extends IBaseDAO<PackageType> {

    List<PackageType> getPackageTypeByName(String name);

}
