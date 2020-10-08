package org.softwire.training.bookish.services;

import org.jdbi.v3.core.Jdbi;

public abstract class DatabaseService {

    private final String hostname = "localhost";
    private final String database = "bookish";
    private final String user = "dave";
    private final String password = "admin";
    private final String connectionString = "jdbc:mysql://" + hostname + "/" + database + "?user=" + user + "&password=" + password + "&useJDBCCompliantTimezoneShift=true&useLegacyDatetimeCode=false&serverTimezone=GMT&allowPublicKeyRetrieval=true&useSSL=false";

    protected final Jdbi jdbi = Jdbi.create(connectionString);
}
