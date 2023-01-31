package mybatis.interfaces;

import java.util.ArrayList;

public interface IParentDAO<T> {
    T get(int id);
    ArrayList<T> getAll();
    int create(T objInstance);
    int update(T transientObject);
    int delete(int id);
}
