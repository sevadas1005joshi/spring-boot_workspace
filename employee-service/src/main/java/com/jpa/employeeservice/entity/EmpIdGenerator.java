package com.jpa.employeeservice.entity;

import java.io.Serializable;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import org.hibernate.HibernateException;
import org.hibernate.engine.spi.SharedSessionContractImplementor;
import org.hibernate.id.IdentifierGenerator;

public class EmpIdGenerator implements IdentifierGenerator{

    @Override
    public Serializable generate(SharedSessionContractImplementor session, Object object)
            throws HibernateException {

        String prefix = "EMP";
        Connection connection = session.connection();

        try {
            Statement statement=connection.createStatement();
            ResultSet rs=statement.executeQuery("select count(ID) as Id from EMPLOYEE");
            if(rs.next())
            {
            	int id=rs.getInt(1);
                String generatedId = prefix + new Integer(id).toString();
                System.out.println("Generated Id: " + generatedId);
                return generatedId;
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }

}