package views;

public class ViewFactory
{
    public View createView(String id, String type)
    {
        View view;
        switch(type)
        {
            case "image":
                view = new ImageView(id);
            break;
                
            case "textSelection":
                view = new TextSelectionView(id);
            break;
                
            case "imageSelection":
                view = new ImageSelectionView(id);
            break;
                
            case "textTemplate":
                view = new TextTemplateView(id);
            break;
                
            default:
                view = new TextView(id);
        }
        
        return view;
    }
}
