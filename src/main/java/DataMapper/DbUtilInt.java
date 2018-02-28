package DataMapper;

import java.sql.PreparedStatement;
import java.sql.ResultSet;

/**
 * Created by error on 2/22/18.
 */
public interface DbUtilInt {

    ResultSet read(String sql);
    void connect();
    int writePreparedStatement(PreparedStatement ps);
    int write(String sql);
    void cleanUp(ResultSet rs);
    void cleanUp();
}
