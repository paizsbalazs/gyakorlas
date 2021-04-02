package zarovizsga1;

import javax.sql.DataSource;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class PeopleDao {

    private DataSource dt;

    public PeopleDao(DataSource dt) {
        this.dt = dt;
    }

    String findIpByName(String firstName, String lastName) {

        try (Connection conn = dt.getConnection();
             PreparedStatement stmt = conn.prepareStatement("select first_name, last_name, ip_address from people where first_name = ? and last_name = ?")
        ) {
            stmt.setString(1,firstName);
            stmt.setString(2,lastName);

            try (ResultSet rs = stmt.executeQuery()) {
                while (rs.next()) {
                    return rs.getString(3).toLowerCase();
                }
            } catch (SQLException sqle) {
                throw new IllegalStateException("Cannot query", sqle);
            }


        } catch (SQLException sqlException) {
            throw new IllegalStateException("Cannot find");
        }
        return "";
    }


}
