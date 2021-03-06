import java.util.*;

public interface Scope {

    public String getName();

    public Scope getParentScope();

    public boolean isValid();

    public void addSymbol(Symbol symbol);

    public Symbol findSymbol(String name);

    public Symbol findLocalSymbol(String name);

}
