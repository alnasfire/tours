package by.scand.info.dao;

/**
 * User: nasgor
 * Date: 10/10/12
 * Time: 4:17 PM
 */
public class DAOException extends Exception {

    public DAOException() {
    }

    public DAOException(String s) {
        super(s);
    }

    public DAOException(String s, Throwable throwable) {
        super(s, throwable);
    }

    public DAOException(Throwable throwable) {
        super(throwable);
    }
}