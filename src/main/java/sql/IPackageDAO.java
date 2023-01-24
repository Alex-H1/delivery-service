package sql;


import model.Package;

public interface IPackageDAO extends IBaseDAO<Package> {
    Package getPackageByTrackingNumber(String num);

}
