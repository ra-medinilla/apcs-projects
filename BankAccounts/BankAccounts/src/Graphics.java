import javax.swing.ImageIcon;
public enum Graphics {

    DELETEDORIGINALACCOUNT("src/images/deletedoriginal.png"), ESCAPEDFUGITIVEALLOWED("src/images/escapedfugitive.png"),
    DOUBLEWHAMMY("src/images/doublewhammy.png"), DEFAULT("src/images/default.png");

    private ImageIcon _img;

    public ImageIcon getImage() { return _img; }
    private Graphics(String fName) {
        _img = new ImageIcon(fName);
    }
}
