package sample;

import java.util.List;

public interface IExport {

    void export(List<Exportable> exportable, Character separateValue) throws Exception;
}
