package layoutElements.Grid;

import org.jdom2.Element;

/**
 * Created by rouslankhayaouri on 14/09/15 time 21:29.
 */
public interface GridFormable {
    void createGridLayout();
    void addContentToGrid(Element element, int row, int column);
}
