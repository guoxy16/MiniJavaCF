import java.util.*;

public class Class extends Symbol implements Scope {
    private String parentClassName;
    private Scope parentScope;
    private boolean valid;

    private Map<String, Symbol> symbols = new HashMap<String, Symbol>();

    public Class(String className, String parentClassName, Scope parentScope, boolean valid) {
        super(className);
        this.parentClassName = parentClassName;
        this.parentScope = parentScope;
        this.valid = valid;
    }

    // Fucking Java does not support default parameter ??!!
    public Class(String className, String parentClassName, Scope parentScope) {
        super(className);
        this.parentClassName = parentClassName;
        this.parentScope = parentScope;
        this.valid = true;
    }

    @Override
    public boolean isValid() {
        return this.valid;
    }

    @Override
    public String getName() {
        return this.name;
    }

    @Override
    public Scope getParentScope() {
        return this.parentScope;
    }

    @Override
    public void addSymbol(Symbol symbol) {
        symbols.put(symbol.getName(), symbol);
    }

    @Override
    public Symbol findSymbol(String name) {
        if (symbols.containsKey(name))
            return symbols.get(name);
        else {
            if (this.parentScope == null)
                return null;
            Symbol result = this.parentScope.findSymbol(name);
            if (result != null)
                return result;
            else {
                Symbol parentClass = this.parentScope.findSymbol(this.parentClassName);
                if (parentClass == null)
                    return null;
                else
                    return ((Class)parentClass).findSymbol(name);
            }
        }
    }

    @Override
    public Symbol findLocalSymbol(String name) {
        return symbols.get(name);
    }

    public String getParentClassName() {
        return parentClassName;
    }

}
