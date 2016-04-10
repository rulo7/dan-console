package _app_package_name_._packagename_;

import _app_package_name_._datastore_package_._EntityName_DataStore;
import _app_package_name_._mapper_package_._EntityName_Cache;
import _app_package_name_.data.net.RestApi;
import javax.inject.Inject;
import javax.inject.Singleton;

@Singleton
public class EntryDataFactory {

    private RestApi restApi;
    private _Entityname_Cache cache;
    
    @Inject
    public _Entityname_DataFactory(RestApi restApi, _Entityname_Cache cache) {
        this.restApi = restApi;
        this.cache = cache;
    }

    public _Entityname_DataStore createCloudDataStore() {
        return new Cloud_Entityname_DataStore(restApi, cache);
    }

    public _Entityname_DataStore createLocalDataStore() {
        return new Disk_Entityname_DataStore(cache);
    }
}

