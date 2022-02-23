package action;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class Getdata {

    List<EmpBean> empBeanList= new ArrayList<>();

    public List<EmpBean> getEmpBeanList() {
        return empBeanList;
    }

    public void setEmpBeanList(List<EmpBean> empBeanList) {
        this.empBeanList = empBeanList;
    }

    public String get(){

        Connection connection;

        PreparedStatement preparedStatement;

        try {

            Class.forName("com.mysql.jdbc.Driver");

            connection = DriverManager.getConnection("jdbc:mysql://localhost:5000/FetchAPI", "root", "");

            preparedStatement=connection.prepareStatement("select * from emp");

            ResultSet resultSet=preparedStatement.executeQuery();

            while (resultSet.next()){

                EmpBean empBean=new EmpBean();

                empBean.setId(resultSet.getString(1));

                empBean.setName(resultSet.getString(2));

                empBeanList.add(empBean);

            }

        } catch (ClassNotFoundException | SQLException e) {

            e.printStackTrace();

        }

        return "GET";
    }
}
