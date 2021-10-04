package jvm.pablohdz.emailbasicauthenticationservice.persistence;

public class EnvDatabaseH2Impl
        implements EnvDatabase {
    private final String DB_URL = "jdbc:h2:~/test";
    private final String USER = "sa";
    private final String PASSWORD = "sa";

    @Override
    public String getUrlDatabase() {
        return DB_URL;
    }

    @Override
    public String getUserDatabase() {
        return USER;
    }

    @Override
    public String getPasswordDatabase() {
        return PASSWORD;
    }
}
