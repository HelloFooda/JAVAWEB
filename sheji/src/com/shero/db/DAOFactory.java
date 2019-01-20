package com.shero.db;

import java.sql.Connection;

import com.shero.dao.GoodsDao;
import com.shero.dao.GoodsDaoImpl;
import com.shero.dao.TbDao;
import com.shero.dao.TbdaoImpl;
import com.shero.dao.UserDao;
import com.shero.service.UsersService;




public class DAOFactory {
	public static UserDao getUserDAOInstance()throws Exception {   
        return new UsersService(); 
    }
public static GoodsDao getGoodDAOInstance(Connection conn)throws Exception {   
        return new GoodsDaoImpl(conn);
    } 
public static TbDao getTbDAOInstance(Connection conn)throws Exception {   
    return new TbdaoImpl(conn);
} 

}
