package udf;

import inter.UDFName;
import org.apache.hadoop.hive.ql.exec.UDFArgumentException;
import org.apache.hadoop.hive.ql.metadata.HiveException;
import org.apache.hadoop.hive.ql.udf.generic.GenericUDF;
import org.apache.hadoop.hive.serde2.objectinspector.ObjectInspector;
import org.apache.hadoop.hive.serde2.objectinspector.primitive.PrimitiveObjectInspectorFactory;
import org.apache.hadoop.hive.serde2.objectinspector.primitive.StringObjectInspector;

import java.util.ArrayList;
import java.util.HashSet;

@UDFName("GET_LIST")
// 类必须被public定义，否则即使spark注册了也无法使用，类找不到
//
public class GetListGenericUDF extends GenericUDF {

    private transient StringObjectInspector tbNameOI;
    private transient StringObjectInspector pathOI;
    private transient StringBuilder filterSet;

    @Override
    public ObjectInspector initialize(ObjectInspector[] objectInspectors) throws UDFArgumentException {

        ObjectInspector tbName = objectInspectors[0];
        ObjectInspector path = objectInspectors[1];
        this.tbNameOI = (StringObjectInspector) tbName;
        this.pathOI = (StringObjectInspector) path;

        filterSet = new StringBuilder();
        filterSet.append("XLS");
        filterSet.append("XLSX");
        filterSet.append("ET");
        filterSet.append("XLT");
        filterSet.append("XLSM");

        // 用工厂类生成用于表示返回值的ObjectInspector
        return PrimitiveObjectInspectorFactory.javaStringObjectInspector;
    }

    @Override
    public Object evaluate(DeferredObject[] deferredObjects) throws HiveException {
        String tbName = tbNameOI.getPrimitiveJavaObject(deferredObjects[0].get());
        String path = pathOI.getPrimitiveJavaObject(deferredObjects[1].get());
        return tbName + "," + path + "," + filterSet;
    }

    @Override
    public String getDisplayString(String[] strings) {
        return "GET_LIST()";
    }
}
