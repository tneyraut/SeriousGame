package conditions;

public class ConditionFactory
{
    public Condition createCondition(String type)
    {
        Condition condition;
        switch(type)
        {
            case "stat":
                condition = new StatCondition();
            break;
            default:
                condition = new VoidCondition();
        }
        
        return condition;
    }
}
