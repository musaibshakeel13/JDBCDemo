import java.sql.*;

public class JDBCDemo {

    private static final String URl ="jdbc:mysql://localhost:3306/demodb";
    private static final String User ="root";
    private static final String Password ="pASSWORD123";
    public static void main(String[] args) throws SQLException {
        try(Connection conn = DriverManager.getConnection(URl,User,Password)){
            System.out.println("Connected to database successfully");
//            insertStudent(conn,1,"musaib","haji@123gmail.com");
//            updateStudent(conn,2,"WASID","wasid12@gmail.com");
//            selectStudent(conn);
            deleteStudent(conn,2);

        }catch(SQLException e){
            e.printStackTrace();
        }

        }
        private static void insertStudent(Connection conn,int id,String name, String email){
        String SQL="insert into student (name,email) values ('"+name+"','"+email+"')";
        try (Statement stmt =conn.createStatement()) {
            int rows=stmt.executeUpdate(SQL);
            System.out.println("rows affected: "+rows);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        }
        private static void selectStudent(Connection conn) throws SQLException {
         String SQL="SELECT * FROM student";
        try(Statement stmt = conn.createStatement()) {
        ResultSet rs=stmt.executeQuery(SQL);
            System.out.println("Student list: ");
            while(rs.next()){
                int id=rs.getInt("id");
                String name=rs.getString("name");
                String email=rs.getString("email");
                System.out.println(id+" "+name+" "+email);
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
    private static void updateStudent(Connection conn, int id, String name, String email) {
        String SQL = "UPDATE student SET name='" + name + "', email='" + email + "' WHERE id=" + id;

        try (Statement stmt = conn.createStatement()) {
            int rows = stmt.executeUpdate(SQL);
            System.out.println("rows affected: " + rows);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    private static void deleteStudent(Connection conn, int id) {
        String SQL = "DELETE FROM student WHERE id=" + id;
        try(Statement stmt = conn.createStatement()){
            int rows= stmt.executeUpdate(SQL);
            System.out.println("rows deleted: " + rows);
        } catch (SQLException e) {
           e.printStackTrace();
        }
    }
    }

