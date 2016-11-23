import java.util.*;

public class Class extends Symbol implements Scope {
    private boolean valid;
    private String parentClassName;
    private Scope parentScope;

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

    public getParentClassName() {
        return parentClassName;
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
        return parentScope;
    }

    @Override
    public void addSymbol(Symbol symbol) {
        symbols.put(symbol.getName(), symbol);
    }

    @Override
    public Symbol findSymbol(String name) {
        if (symbols.containsKey(name))
            return symbols.get(name);
        else
            return this.getParentScope().findSymbol(name);
    }

    @Override
    public Symbol findLocalSymbol(String name) {
        return symbols.get(name);
    }

    @Override
    public Map<String, Symbol> getSymbols() {
        return symbols;
    }

}
