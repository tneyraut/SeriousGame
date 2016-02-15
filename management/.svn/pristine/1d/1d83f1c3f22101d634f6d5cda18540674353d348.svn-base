package conditions;

import org.w3c.dom.Element;
import wizardgame.Joueur;

class StatCondition extends Condition
{
    private String name;
    private int value;
    private String operator;
    
    @Override
    public boolean eval()
    {
        boolean result;
        
        switch(operator)
        {
            case "gt":
                result = value >= Joueur.getInstance().get(name);
            break;
            case "lt":
                result = value <= Joueur.getInstance().get(name);
            break;
            case "!=":
                result = value != Joueur.getInstance().get(name);
            break;
            default:
                result = value == Joueur.getInstance().get(name);
        }
        
        return result;
    }

    @Override
    public void fill(Element xmlCondition)
    {
        this.name = xmlCondition.getAttribute("name");
        this.value = Integer.parseInt(xmlCondition.getAttribute("value"));
        this.operator = xmlCondition.getAttribute("operator");
    }
}
