package _app_package_name_._packagename_;

import _app_package_name_._entity_package_._Entityname_Entity;
import java.util.List;
import rx.Observable;

public interface _Entityname_DataStore {
    Observable<List<_Entityname_Entity>> _entityname_List();

    Observable<_Entityname_Entity> _entityname_(int id);
}
