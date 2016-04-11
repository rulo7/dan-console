package _app_package_name_._packagename_;

import _app_package_name_._datastore_package_._Entityname_DataStore;
import _app_package_name_._entity_package_._Entityname_Entity;
import _app_package_name_._mapper_package_._Entityname_Cache;
import _app_package_name_.data.net.RestApi;

import java.util.List;
import rx.Observable;

public class _Entityname_CloudDataStore implements _Entityname_DataStore {

    private final RestApi restApi;
    private _Entityname_Cache cache;

    public _Entityname_CloudDataStore(RestApi restApi, _Entityname_Cache cache) {
        this.restApi = restApi;
        this.cache = cache;
    }

    @Override
    public Observable<List<_Entityname_Entity>> _entityname_() {
        return restApi._entityname_().doOnNext(_entityname_Entities -> {
            if (_entityname_Entities != null) {
                _Entityname_CloudDataStore.this.cache.put(_entityname_Entities);
            }
        });
    }
}
