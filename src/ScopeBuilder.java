import org.antlr.v4.runtime.*;
import java.util.*;

public class ScopeBuilder extends MiniJavaBaseListener {
    private Map<String, Class> classes;
    private Scope currentScope = null;

    public ScopeBuilder(Map<String, Class> classes) {
        this.classes = classes;
    }

    public void exitScope() {
        currentScope = currentScope.getParentScope();
    }

    @Override
    public void enterMainClass(MiniJavaParser.MainClassContext ctx) {
        String className = ctx.name.getText();
        Class mainClass = new Class(className, "", null);
        classes.put(className, mainClass);
        currentScope = mainClass;
    }

    @Override
    public void enterClassDeclaration(MiniJavaParser.ClassDeclarationContext ctx) {
        String className, parentClassName;
        className = ctx.name.getText();
        parentClassName = (ctx.parent != null ? ctx.parent.getText() : "");
        System.out.println("Class: " + className + "; Parent: " + parentClassName);
        
        Class currentClass = new Class(className, parentClassName, currentScope);
        if (classes.containsKey(className))
            System.err.println("Duplicate classes.");
        else
            classes.put(className, currentClass);
        currentScope = currentClass;
    }

    @Override
    public void exitClassDeclaration(MiniJavaParser.ClassDeclarationContext ctx) {
        exitScope();
    }

    @Override
    public void enterMethodDeclaration(MiniJavaParser.MethodDeclarationContext ctx) {
        String methodName, methodReturnType;
        methodName = ctx.name.getText();
        methodReturnType = ctx.rtype.getText();
        System.out.println("Method: " + methodName + "; Return Type: " + methodReturnType);
        
        Method currentMethod = new Method(methodName, methodReturnType, currentScope);
        // put in currentScope's symbol table
        currentScope.addSymbol(currentMethod);
        currentScope = currentMethod;
    }

    @Override
    public void exitMethoDeclaration(MiniJavaParser.MethodDeclarationContext ctx) {
        exitScope();
    }

    @Override
    public void enterVarDeclaration(MiniJavaParser.VarDeclarationContext ctx) {
        String varType, varName;
        varType = ctx.vtype.getText();
        varName = ctx.name.getText();
        System.out.println("Var: " + varName + "; Type: " + varType);
        
        Symbol currentVar = new Symbol(varName, varType);
        // put in currentScope's symbol table
        currentScope.addSymbol(currentVar);
    }
}
