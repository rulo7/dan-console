package _app_package_name_._packagename_;

import _app_package_name_.domain.model._Entityname_;
import java.util.List;
import rx.Observable;

public interface _Entityname_Repository {

    Observable<_Entityname_> _entityname_(int id);

    Observable<List<_Entityname_>> _entityname_List();
}