package daos.daosImpl;

import daos.daosInterface.Crud;
import daos.qualifiers.Clinic;

import java.util.ArrayList;

import static daos.qualifiers.Clinic.clinicChoice.DispenseDao;

/**
 * Created by error on 2/21/18.
 */
@Clinic(DispenseDao)
public class DispenseDao implements Crud {

    @Override
    public boolean create(Object o) {
        return false;
    }

    @Override
    public Object read(Object o) {
        return null;
    }

    @Override
    public boolean update(Object o) {
        return false;
    }

    @Override
    public boolean delete(Object o) {
        return false;
    }

    @Override
    public ArrayList<Object> getAll() {
        return null;
    }
}
