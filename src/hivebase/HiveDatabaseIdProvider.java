package hivebase;

import org.apache.ibatis.mapping.DatabaseIdProvider;

import javax.sql.DataSource;
import java.sql.SQLException;
import java.util.Properties;

/**
 * Created by timeloveboy on 17-10-27.
 */
public class HiveDatabaseIdProvider implements DatabaseIdProvider {
    Properties properties;

    @Override
    public void setProperties(Properties p) {
        this.properties = p;
    }

    @Override
    public String getDatabaseId(DataSource dataSource) throws SQLException {
        String dbname = dataSource.getConnection().getMetaData().getDatabaseProductName();
        String dbId = "hive2";
        return dbId;
    }
}
