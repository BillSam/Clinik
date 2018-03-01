package daos.daosInterface;


import java.util.ArrayList;

/**
 * Created by error on 2/23/18.
 */
public interface Crud {

    boolean create(Object o);
    Object read(Object o);
    boolean update(Object o);
    boolean delete(Object o);
    ArrayList<Object> getAll();



}
