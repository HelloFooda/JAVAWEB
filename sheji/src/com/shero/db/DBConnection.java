package com.shero.db;

import java.sql.Connection;
import java.sql.DriverManager;

public class DBConnection {
		private static final String Driver = "com.mysql.jdbc.Driver";
		private static final String URL = "jdbc:mysql://localhost:3309/shoppingweb";
		private static final String USER = "root";
		private static final String PASSWORD = "root";
		private Connection conn = null;

		public DBConnection() throws Exception { // �������ݿ�����
			try {
				Class.forName(Driver); // �÷���������ݿ�����
				this.conn = DriverManager.getConnection(URL, USER, PASSWORD);
			} catch (Exception e) {
				throw e; // �׳��쳣
			}
		}

		public Connection getConnection() {
			return this.conn; // ȡ�����ݿ������
		}

		public void close() throws Exception { // �ر����ݿ�
			if (this.conn != null) {
				try {
					this.conn.close(); // ���ݿ�ر�
				} catch (Exception e) {
					throw e;
				}
			}
		}

	}
