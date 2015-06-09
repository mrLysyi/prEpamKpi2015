package pr4.lysyi.businessLogic;



import java.sql.Connection;
import java.sql.SQLException;
//import pr4.lysyi.unused.ConnectionPool;
//import by.bsu.pool.ConnectionPool;
//import by.bsu.simpledao.AbonentDAO;
//import by.bsu.simpledao.PaymentDAO;
//import by.bsu.subject.Abonent;
//import by.bsu.subject.Payment;

public class SomeLogicTest {

    public void doLogic(int id) throws SQLException {
// 1. создание-получение соединения
//        Connection conn = ConnectionPool.getConnection();
// 2. открытие транзакции
//        conn.setAutoCommit(false);
// 3. инициализация необходимых экземпляров DAO
//        AbonentDAO abonentDAO = new AbonentDAO(conn);
//        PaymentDAO paymentDAO = new PaymentDAO(conn);
//// 4. выполнение запросов
//        abonentDAO.findAll();
//        paymentDAO.findEntityById(id);
//        paymentDAO.delete(id);
// 5. закрытие транзакции
//        conn.commit();
// 6. закрытие-возвращение соединения
//        ConnectionPool.close(conn);
    }
    
    public static void main(String[] args) {
        String s= "s";
        String s2= "S";
        System.out.println(s.equals(s2));
    }
}
