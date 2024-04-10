package github.guimaraesp;

public class ZeroSubscribersException extends RuntimeException {
    @Override
    public String getMessage() {
        return "You do not have any subscribers buddy :(";
    }
}
