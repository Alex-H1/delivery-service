package sql;

import model.PackageType;

import java.sql.SQLException;

public interface IPackageDAO extends IBaseDAO {
    void saveEntity(Object model) throws SQLException;

    void updateEntity(Object model) throws SQLException;

    PackageType getPackageByTrackingNumber(String number) throws SQLException;
}
