/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package pr4.lysyi.unused;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.concurrent.ArrayBlockingQueue;

/**
 *
 * @author hellow
 */
public class ConnectionPool<T> {
  
//	
//private ArrayBlockingQueue<T> connectionQueue;
//	
//public ConnectionPool(final int POOL_SIZE) throws SQLException {
//		connectionQueue = new ArrayBlockingQueue<T>(POOL_SIZE);
//		for (int i = 0; i < POOL_SIZE; i++) {
//			T connection = // create connection
//			connectionQueue.offer(connection);
//		}
//	}
//	
//public T getConnection() throws InterruptedException {
//		
//T connection = null;
//		
//connection = connectionQueue.take();
//		return connection;
//	}
//	
//public void closeConnection(T connection) {
//		connectionQueue.offer(connection); // возможны утечки соединений
//	
//}
//	
//// more methods
//}
}
