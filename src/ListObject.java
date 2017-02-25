import java.util.List;

/**
 * Created by aparnamahadevan on 16/2/17.
 */
public class ListObject extends Object {
    private String data;
    private String description;
    private int num;
    private boolean priority;
    private boolean checked;
    private String progress;

    public ListObject(){
        data = null;
        description = null;
        priority = false;
        checked =false;
    }

    public ListObject(String o, String d, boolean p, boolean c) {
        data = o;
        description = d;
        priority = p;
        checked = c;
    }

    public String getData(){
        return data;
    }
    public String getDescription(){
        return description;
    }
    public boolean getPriority(){
        return priority;
    }
    public boolean getChecked(){
        return checked;
    }

    public void setData(String s){
        data = s;
    }
    public void setDescription(String s){
        description = s;
    }
    public void setChecked(boolean b){
        checked = b;
    }
    public void setPriority(boolean b){
        priority = b;
    }
}
