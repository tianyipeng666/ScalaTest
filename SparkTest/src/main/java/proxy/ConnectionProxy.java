package proxy;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.sql.Connection;

public class ConnectionProxy implements InvocationHandler {
    private final Connection delegate;

    public ConnectionProxy(Connection delegate) {
        this.delegate = delegate;
    }
    @Override
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
        if ("prepareStatement".equals(method.getName())) {
            // String sql = (String) args[0];
            // String modifiedSql = SqlUtils.convertSql(sql);
            // args[0]= modifiedSql;
        }
        return method.invoke(delegate, args);

    }
    public static Connection wrap(Connection conn) {
        return (Connection) java.lang.reflect.Proxy.newProxyInstance(
                Connection.class.getClassLoader(),
                new Class<?>[]{Connection.class},
                new ConnectionProxy(conn)
        );
    }
}
