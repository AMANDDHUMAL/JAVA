package src;

import java.sql.*;
class DB {
    private static final String DATABASE_URL="jdbc:mysql://127.0.0.1/srms";
    private static final String DATABASE_USERNAME="root";
    private static final String DATABASE_PASSWORD="Vep4pta8xv";
    private static final String GET_LOGIN = "SELECT * FROM stud INNER JOIN res USING (rollno) WHERE rollno = ?";
    
    static String rollno = null;
    static String course = null;
    static String branch = null;
    static String name = null;
    static String father = null;
    static String gender = null;
    
    static String oopj = null;
    static String dlca= null;
    static String ds = null;
    static String cg = null;
    static String math = null;
    
    public Connection connectDatabase(){
    try{
    return DriverManager.getConnection(DATABASE_URL,DATABASE_USERNAME,DATABASE_PASSWORD);
    }catch(SQLException e){
        System.out.println("SQL FAIL");
    }
        return null;
    }
    public boolean getLogin(String x) throws SQLException{
    try(Connection connection = connectDatabase();
        PreparedStatement preparedStatement =connection.prepareStatement(GET_LOGIN)){
        preparedStatement.setString(1, x);
        ResultSet resultSet = preparedStatement.executeQuery();
        if(resultSet.next()){
        
        DB.course = resultSet.getString("course");
        DB.branch = resultSet.getString("branch");
        DB.name = resultSet.getString("name");
        DB.father = resultSet.getString("father");
        DB.gender = resultSet.getString("gender");
        
        DB.oopj = resultSet.getString("oopj");
        DB.dlca = resultSet.getString("dlca");
        DB.ds = resultSet.getString("ds");
        DB.cg = resultSet.getString("cg");
        DB.math = resultSet.getString("math");
        
        DB.rollno = x;
        return true;
        }
        else 
            return false;
       }
    }
}
