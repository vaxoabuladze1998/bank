import java.util.List;

public interface Medium {

    public void write(String user, long dataId, String data) throws Exception;

    String read(String user , long dataId) throws Exception;

    List<String> read(String user) throws Exception;

}
