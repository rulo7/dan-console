package _app_package_name_._packagename_;

import _app_package_name_._datastore_package_._EntityName_DataStore;
import _app_package_name_._entity_package_._Entityname_Entity;
import _app_package_name_._mapper_package_._EntityName_Cache;
import _app_package_name_.data.net.RestApi;

import java.util.List;
import rx.Observable;

public class Cloud_Entityname_DataStore implements _Entityname_DataStore {

    private final RestApi restApi;
    private _Entityname_Cache cache;

    public CloudEntryDataStore(RestApi restApi, _Entityname_Cache cache) {
        this.restApi = restApi;
        this.cache = cache;
    }

    @Override
    public Observable<List<_Entityname_Entity>> _entityname_() {
        return restApi._entityname_().doOnNext(_entityname_Entities -> {
            if (_entityname_Entities != null) {
                Cloud_Entityname_DataStore.this.cache.put(_entityname_Entities);
            }
        });
    }
}
