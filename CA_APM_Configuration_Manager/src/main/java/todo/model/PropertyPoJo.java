package todo.model;
/**
 * Created by dwiba01 on 29/09/2016.
 */
public class PropertyPoJo {
    int id;
    public void setId(int id) {
        this.id = id;
    }
    public int getId() {
        return id;
    }
    
    public String getKey() {
        return Key;
    }
    public void setKey(String key) {
        Key = key;
    }
    public String getValue() {
        return Value;
    }
    public void setValue(String value) {
        Value = value;
    }
    String Key;
    String Value;
    boolean commentedflag;
    public boolean isCommentedflag() {
        return commentedflag;
    }
    public void setCommentedflag(boolean commentedflag) {
        this.commentedflag = commentedflag;
    }

}
