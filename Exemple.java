import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Statement;
import javax.servlet.http.HttpServletRequest;

// Commentaires
public class UserDAO {

    public void unsafeQuery(HttpServletRequest request) throws Exception {
        String username = request.getParameter("username");
        Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/mydb", "user", "password");
        Statement stmt = con.createStatement();

        // Problème : Concaténation directe de l'entrée utilisateur dans une requête SQL
        // Ceci est vulnérable à l'injection SQL.
        String query = "SELECT * FROM users WHERE username = '" + username + "'";
        stmt.executeQuery(query);

        // ... traitement des résultats ...

        stmt.close();
        con.close();
    }

    public void anotherIssue() {
        // Problème : Mot de passe codé en dur
        // Semgrep peut aussi identifier cela comme un secret codé en dur.
        String dbPassword = "mySuperSecretPassword123!";
        System.out.println("Connecting with password: " + dbPassword);
    }
}
