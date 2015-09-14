package layoutElements;

import org.jdom2.Element;
import tools.XAMLToobox;

/**
 * Created by rouslankhayaouri on 14/09/15 time 21:22.
 */
public class InnerGrid implements GridFormable {
    private Element root;
    private boolean rowsAreSet = false;
    private boolean columnsAreSet = false;
    private int rows;
    private int columns;

    public void setNumRows(int rows) {
        if (rows > 0) {
            this.rows = rows;
            rowsAreSet = true;
        }
    }

    public void setNumColumns(int columns) {
        if (columns > 0) {
            this.columns = columns;
            columnsAreSet = true;
        }
    }

    @Override
    public void createGridLayout() {
        createGridColuns();
        createGridRows();
    }

    @Override
    public void addContentToGrid(Element element, int row, int column) {
        if (rowsAreSet && columnsAreSet) {
            element.setAttribute("Grid.Row", Integer.toString(row));
            element.setAttribute("Grid.Column", Integer.toString(column));
            root.addContent(element);
        }
    }

    private void createGridRows() {
        if (rowsAreSet) {
            Element rowDefinitions = XAMLToobox.getToobox().createXAMLElement("Grid.RowDefinitions");
            for (int currentRow = 0; currentRow < rows; currentRow++) {
                Element currentElement = XAMLToobox.getToobox().createXAMLElement("RowDefinition");
                rowDefinitions.addContent(currentElement);
            }
            root.addContent(rowDefinitions);
        }
    }

    private void createGridColuns() {
        if (columnsAreSet) {
            Element columnDefinitons = XAMLToobox.getToobox().createXAMLElement("Grid.ColumnDefinitions");
            for (int currentColumn = 0; currentColumn < columns; currentColumn++) {
                Element currentElement = XAMLToobox.getToobox().createXAMLElement("ColumnDefinition");
                columnDefinitons.addContent(currentElement);
            }
            root.addContent(columnDefinitons);
        }
    }
}
