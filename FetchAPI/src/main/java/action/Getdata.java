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

    void select(String tableName,ArrayList attributes,ArrayList values) throws ClassNotFoundException, SQLException {

        PreparedStatement preparedStatement;

        Class.forName("com.mysql.cj.jdbc.Driver");

        Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/FetchAPI", "root", "Mind@123");

        int size = attributes.size();

        String query="select * from "+tableName+" where ";

        for(Object attribute:attributes){

            query+=attribute+"=? AND ";

        }

        query+= "1=1";

        System.out.println(query);

        preparedStatement=connection.prepareStatement(query);

        for(int i=1;i<=size;i++){

            if(values.get(i-1) instanceof Integer){

                preparedStatement.setInt(i, (Integer) values.get(i-1));

            }
            else {

                preparedStatement.setString(i,(String) values.get(i-1));
            }

        }

        ResultSet resultSet=preparedStatement.executeQuery();

        while (resultSet.next()){

            System.out.println(resultSet.getString(1)+resultSet.getString(2));

        }


    }

    void delete(String tableName,ArrayList attributes,ArrayList values) throws ClassNotFoundException, SQLException {

        PreparedStatement preparedStatement;

        Class.forName("com.mysql.cj.jdbc.Driver");

        Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/FetchAPI", "root", "Mind@123");

        int size = attributes.size();

        String query="delete from "+tableName+" where ";

        for(Object attribute:attributes){

            query+=attribute+"=? AND ";

        }

        query+= "1=1";

        System.out.println(query);

        preparedStatement=connection.prepareStatement(query);

        for(int i=1;i<=size;i++){

            if(values.get(i-1) instanceof Integer){

                preparedStatement.setInt(i, (Integer) values.get(i-1));

            }
            else {

                preparedStatement.setString(i,(String) values.get(i-1));
            }

        }

        preparedStatement.executeUpdate();

    }

    boolean insert(String tableName,ArrayList attributes,ArrayList values) throws ClassNotFoundException, SQLException {

        PreparedStatement preparedStatement;

        Class.forName("com.mysql.cj.jdbc.Driver");

        Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/FetchAPI", "root", "Mind@123");

        int length=attributes.size();

        String attributesString ="(";

        String valueString="(";

        for(int i=0;i<length;i++){

            if(length-1==i){

                attributesString += attributes.get(i);

                valueString+="?";

            }else {

                attributesString += attributes.get(i)+",";

                valueString+="?,";

            }

        }

        attributesString+=")";

        valueString+=")";

        String query= "insert into "+tableName+" "+attributesString+" values"+valueString;

        System.out.println(query);

        try {

            preparedStatement=connection.prepareStatement(query);

            for(int i=1;i<=length;i++){

                if(values.get(i-1) instanceof Integer){

                    preparedStatement.setInt(i, (Integer) values.get(i-1));

                }
                else {

                    preparedStatement.setString(i,(String) values.get(i-1));
                }

            }
            preparedStatement.executeUpdate();
            return true;

        } catch (SQLException e) {

            e.printStackTrace();

        }

        return false;
    }

    public String get(){

        Connection connection;

        PreparedStatement preparedStatement;

        try {

            Class.forName("com.mysql.cj.jdbc.Driver");

            connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/FetchAPI", "root", "Mind@123");

            preparedStatement=connection.prepareStatement("select * from emp");

            ArrayList attributes=new ArrayList();

            attributes.add("id");

            attributes.add("name");

            ArrayList values=new ArrayList();

            values.add("2");

            values.add("shekhar");


            insert("emp",attributes,values);

            select("emp",attributes,values);

            ResultSet resultSet=preparedStatement.executeQuery();

            ArrayList attributes1=new ArrayList();

            attributes1.add("id");

            ArrayList values1=new ArrayList();

            values1.add("322");

            ArrayList conditionAttributes=new ArrayList();

            conditionAttributes.add("name");

            ArrayList conditionValues=new ArrayList();

            conditionValues.add("gabani");

            update("emp",attributes1,values1,conditionAttributes,conditionValues);

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
