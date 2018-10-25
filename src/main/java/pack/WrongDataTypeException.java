package pack;

public class WrongDataTypeException extends Exception {
    public WrongDataTypeException(Throwable e) {
        initCause(e);
    }
}
