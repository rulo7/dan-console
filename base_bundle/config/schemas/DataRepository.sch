package _app_package_name_._packagename_;

import _app_package_name_.data.entity.mapper._Entityname_Mapper;
import _app_package_name_.data.repository.datasource._Entityname_DataFactory;
import _app_package_name_.domain.model._Entityname_;
import _app_package_name_.domain.repository._Entityname_Repository;
import java.util.List;
import javax.inject.Inject;
import rx.Observable;

public class _Entityname_DataRepository implements _Entityname_Repository {

    private _Entityname_DataFactory dataFactory;
    private _Entityname_Mapper mapper;

    @Inject
    public _Entityname_DataRepository(_Entityname_Mapper mapper, _Entityname_DataFactory dataFactory) {
        this.mapper = mapper;
        this.dataFactory = dataFactory;
    }

    @Override
    public Observable<List<_Entityname_>> _entityname_List(Integer page, Integer perPage) {
        return dataFactory.createCloudDataStore()._entityname_List(page, perPage).map(_entityname_Entity -> mapper.transform(_entityname_Entity));
    }

    @Override
    public Observable<_Entityname_> _entityname_(int id) {
        return dataFactory.createCloudDataStore()._entityname_(id).map(_entityname_Entity -> mapper.transform(_entityname_Entity));
    }
}

