package jp.co.central_soft.train2019.service;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;

import jp.co.central_soft.train2019.bean.EmployeeDispBean;
import jp.co.central_soft.train2019.bean.EmployeeListDispBean;
import jp.co.central_soft.train2019.dao.Dao;
import jp.co.central_soft.train2019.dao.EmployeesDao;

public class EmployeeService
{

	public EmployeeListDispBean findAll()
	{
		EmployeeListDispBean bean = new EmployeeListDispBean();

		//オートクローズ
		try( Connection con= Dao.getConnection() )
		{
			EmployeesDao dao = new EmployeesDao( con );

			List<EmployeeDispBean> eList = dao.findAll();

			bean.setEmpList( eList );
		}
		catch( SQLException | ClassNotFoundException e )
		{
			e.printStackTrace();
			throw new RuntimeException( e );
		}

		return bean;
	}

	//--------------------------------------------
	public EmployeeDispBean findByKey( int iid )
	{

		EmployeeDispBean emp = null;
		try( Connection con = Dao.getConnection() )
		{
			EmployeesDao dao = new EmployeesDao(con);
			emp =  dao.findByKey(iid);
		}
		catch( SQLException | ClassNotFoundException e1 )
		{
			e1.printStackTrace();
			throw new RuntimeException( e1 );
		}

		return emp;
	}


}
