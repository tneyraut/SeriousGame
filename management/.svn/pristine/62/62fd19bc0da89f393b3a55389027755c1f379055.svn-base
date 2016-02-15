package actions;

public class ActionFactory
{
    public Action createAction(String type)
    {
        Action action;
        switch(type)
        {
            case "stat":
                action = new StatAction();
            break;
            case "notification":
                action = new NotificationAction();
            break;
            case "modal":
                action = new ModalAction();
            break;
            case "view":
                action = new ViewAction();
            break;
            case "game-over":
                action = new GameOverAction();
            break;
            default:
                action = new VoidAction();
        }
        
        return action;
    }
}
