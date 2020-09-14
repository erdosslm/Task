package kz.aitu.project;

import kz.aitu.project.entity.Group;
import kz.aitu.project.entity.Student;

import java.sql.*;
import java.util.Scanner;
public class Test {
    public static void main(String[] args) {
        Student student = new Student(1, "Yerdos", "87478374545", 1);
        Group group = new Group(1, "CS-1905");
        Connection conn = null;

        try {
            String url = "jdbc:postgresql://localhost:5432/postgres";
            String user = "postgres";
            String pass = "160902";

            conn = DriverManager.getConnection(url, user, pass);

            Statement statement = conn.createStatement();
            ResultSet result;
            String query = "INSERT INTO \"Group\" VALUES" +
                    "(" + group.id + ",\'" + group.name + "\'"+")";
            statement.executeUpdate(query);

            query = "INSERT INTO \"Student\" VALUES" +
                    "(" + student.id + ",\'" + student.name + "\',\'" +
                    student.phone + "\'," + student.groupId + ")";
            statement.executeUpdate(query);
            Scanner in = new Scanner(System.in);
            String group_name = in.next();
            String query1 = "SELECT \"Student\".id,\"Student\".name,\"Student\".phone\n" +
                    "FROM \"Student\"\n" +
                    "INNER JOIN \"Group\"\n" +
                    "ON \"Student\".id = \"Group\".id\n" +
                    "WHERE \"Group\". name = \'" + group_name + "\'";
            result = statement.executeQuery(query1);
            while (result.next()) {
                System.out.println(result.getString("id"));
                System.out.println(result.getString("name"));
                System.out.println(result.getString("phone"));
            }
        } catch (SQLException e) {
            System.out.println(e.getMessage());

        } finally {
            try {
                if (conn != null)
                    conn.close();
            } catch (SQLException e) {
                System.out.println(e.getMessage());

            }
        }
    }
}


