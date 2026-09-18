import java.util.Objects;

public record Member (String name, int ID){
    public String toString() {return name+" "+"ID:"+ID;}
}
