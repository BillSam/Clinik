package daos.qualifiers;

import javax.inject.Qualifier;
import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.Target;

import static java.lang.annotation.RetentionPolicy.RUNTIME;

/**
 * Created by error on 3/1/18.
 */
@Qualifier
@Retention(RUNTIME)
@Target({ElementType.FIELD,ElementType.TYPE,ElementType.METHOD,ElementType.PARAMETER})
public @interface Clinic {
    clinicChoice value();
}

    enum clinicChoice{
        BookingDao,
        DispenseDao,
        ExaminationDao,
        LabTestingDao,
        PatientDao,
        UserDao,
        PatientVitals

    }


