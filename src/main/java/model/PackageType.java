package model;

public class PackageType {

    private Integer packageTypeId;
    private String packageTypeName;

    public PackageType() {
    }

    public PackageType(Integer packageTypeId) {
        this.packageTypeId = packageTypeId;
    }

    public Integer getPackageTypeId() {
        return packageTypeId;
    }

    public void setPackageTypeId(Integer packageTypeId) {
        this.packageTypeId = packageTypeId;
    }

    public String getPackageTypeName() {
        return packageTypeName;
    }

    public void setPackageTypeName(String packageTypeName) {
        this.packageTypeName = packageTypeName;
    }

    @Override
    public String toString() {
        return "PackageType{" +
                "packageTypeId=" + packageTypeId +
                ", packageTypeName='" + packageTypeName + '\'' +
                '}';
    }
}
