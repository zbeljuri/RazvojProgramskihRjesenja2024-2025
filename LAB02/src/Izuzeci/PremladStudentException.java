package Izuzeci;

public class PremladStudentException extends Exception
{
    public PremladStudentException (String message)
    {
        super(message);
    }

    public static class DijeljenjeSNulomException extends RuntimeException {
        public DijeljenjeSNulomException(String message) {
            super(message);
        }
    }
}

