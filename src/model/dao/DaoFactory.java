package model.dao;

import db.DB;
import model.dao.impl.DepartmentDaoJDBC;
import model.dao.impl.Sellerdaojdbc;

public class DaoFactory {
	public static SellerDao createSellerDao() {
		return new Sellerdaojdbc(DB.getConnection());
	}
	public static DepartmentDao createDepartmentDao() {
		return new DepartmentDaoJDBC(DB.getConnection());
	}
}
