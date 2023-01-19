package main.java.sql;

public interface IPackageTypeDAO extends IBaseDAO {
    main.java.model.PackageType getPackageTypeByName(String Name);
}
