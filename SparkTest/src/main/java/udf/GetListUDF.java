package udf;

import org.apache.hadoop.hive.ql.exec.UDF;
import org.apache.hadoop.hive.ql.metadata.HiveException;
import java.util.ArrayList;
import java.util.List;

public class GetListUDF extends UDF {

    public List<String> evaluate(String tbName, String path) throws HiveException {
        List<String> result = new ArrayList<>();
        result.add(tbName);
        result.add(path);
        String[] strings = {"aaa", "bbb"};
        return result;

    }
}
