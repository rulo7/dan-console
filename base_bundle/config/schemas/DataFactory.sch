package _app_package_name_._packagename_;

import _app_package_name_._cache_package_._Entityname_Cache;
import _app_package_name_.data.net.RestApi;
import javax.inject.Inject;
import javax.inject.Singleton;

@Singleton
public class _Entityname_DataFactory {

    private RestApi restApi;
    private _Entityname_Cache cache;
    
    @Inject
    public _Entityname_DataFactory(RestApi restApi, _Entityname_Cache cache) {
        this.restApi = restApi;
        this.cache = cache;
    }

    public _Entityname_DataStore createCloudDataStore() {
        return new _Entityname_CloudDataStore(restApi, cache);
    }

    public _Entityname_DiskDataStore createLocalDataStore() {
        return new _Entityname_DiskDataStore(cache);
    }
}

