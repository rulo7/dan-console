package _app_package_name_._packagename_;

import _app_package_name_._datastore_package_._Entityname_DataStore;
import _app_package_name_._entity_package_._Entityname_Entity;
import _app_package_name_._mapper_package_._Entityname_Cache;

import java.util.List;
import rx.Observable;

public class _Entityname_DiskDataStore implements _Entityname_DataStore {

    private _Entityname_Cache cache;

    public _Entityname_DiskDataStore(_Entityname_Cache cache) {
        this.cache = cache;
    }

    @Override
    public Observable<List<_Entityname_Entity>> _entityname_() {
        return cache.getList();
    }
}
