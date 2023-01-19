package main.java.sql;

import java.sql.SQLException;

public interface IPackageDAO extends IBaseDAO {
    main.java.model.Package getPackageByTrackingNumber(String number) throws SQLException;
}
