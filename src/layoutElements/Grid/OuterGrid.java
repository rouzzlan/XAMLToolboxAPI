package layoutElements.Grid;

import org.jdom2.Element;
import tools.XAMLToobox;

import java.util.List;

/**
 * Created by rouslankhayaouri on 14/09/15 time 13:06.
 */
public class OuterGrid implements GridFormable {
    private Element root;
    private boolean isRowDefinitionSet =false;
    private boolean isColumnDefinitionSet =false;
    private List<Element> rowConfigurations;
    private List<Element> columnConfigurations;

    public void setColumnConfiguration(List<Element> columnConfigurationsList){
        if (!isColumnDefinitionSet) {
            this.columnConfigurations = columnConfigurationsList;
            isColumnDefinitionSet=true;
        }

    }
    public void setRowConfiguration(List<Element> rowConfigurationsList){
        if (!isRowDefinitionSet) {
            this.rowConfigurations = rowConfigurationsList;
            isRowDefinitionSet=true;
        }
    }

    @Override
    public void createGridLayout(){
        root.addContent(createGridColumnDefinitions());
        root.addContent(createGridRowDefinitions());
    }

    @Override
    public void addContentToGrid(Element element, int row, int column){
        if (isColumnDefinitionSet && isRowDefinitionSet){
            element.setAttribute("Grid.Row", Integer.toString(row));
            element.setAttribute("Grid.Column", Integer.toString(column));
            root.addContent(element);
        }
    }
    private Element createGridColumnDefinitions(){
        Element GridColumnDefinitons = XAMLToobox.getToobox().createXAMLElement("Grid.ColumnDefinitions");
        for (Element column : columnConfigurations){
            Element currentColumn = XAMLToobox.getToobox().createXAMLElement("ColumnDefinition");
            currentColumn.setAttribute("Width", column.getText());
            GridColumnDefinitons.addContent(currentColumn);
        }
        return GridColumnDefinitons;
    }
    private Element createGridRowDefinitions(){
        Element GridRowDefinitions = XAMLToobox.getToobox().createXAMLElement("Grid.RowDefinitions");
        for (Element row : rowConfigurations){
            Element currentRow = XAMLToobox.getToobox().createXAMLElement("RowDefinition");
            currentRow.setAttribute("Height", row.getText());
            GridRowDefinitions.addContent(currentRow);
        }
        return GridRowDefinitions;
    }
}
