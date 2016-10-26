import org.antlr.v4.runtime.*;
import java.util.*;

public class ClassChecker extends MiniJavaBaseListener {
    private Map<String, Class> classes;

    public ClassChecker(Map<String, Class> classes) {
        this.classes = classes;
    }

    @Override
    public void enterClassDeclaration(MiniJavaParser.ClassDeclarationContext ctx) {
        String className = ctx.identifier(0).getText();
        System.out.println(className);
        Class currentClass = new Class(className);
        if (classes.containsKey(className)) {
            System.err.println("Duplicate classes.");
        }
        else {
            classes.put(className, currentClass);
        }
    }
}
