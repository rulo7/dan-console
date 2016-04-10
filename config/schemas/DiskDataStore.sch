package _app_package_name_._packagename_;

import _app_package_name_._datastore_package_._EntityName_DataStore;
import _app_package_name_._entity_package_._Entityname_Entity;
import _app_package_name_._mapper_package_._EntityName_Cache;

import java.util.List;
import rx.Observable;

public class Disk_Entityname_DataStore implements _Entityname_DataStore {

    private _Entityname_Cache cache;

    public CloudEntryDataStore(_Entityname_Cache cache) {
        this.cache = cache;
    }

    @Override
    public Observable<List<_Entityname_Entity>> _entityname_() {
        return cache.getList();
    }
}
