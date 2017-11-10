package dao;

import org.apache.ibatis.annotations.Select;

import java.util.List;
import java.util.Map;

/**
 * Created by timeloveboy on 17-10-30.
 */
public interface Testmapper {
    @Select("select * from user")
    List<Map<String, Object>> users();
}
