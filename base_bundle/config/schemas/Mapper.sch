package _app_package_name_._packagename_;

import javax.inject.Inject;
import javax.inject.Singleton;
import _app_package_name_._entity_package_._Entityname_Entity;
import _app_package_name_._model_package_._Entityname_;

@Singleton
public class _Entityname_Mapper extends EntryEntityMapper<_Entityname_,_Entityname_Entity> {

    @Inject
    public _Entityname_Mapper() {
        //Declarated default constructor for dagger
    }

    @Override
    public _Entityname_ transform(_Entityname_Entity entity) {
        if (entity != null) {
            _Entityname_ _entityname_ = new _Entityname_();
            _entityname_.setId(entity.getId());

            return _entityname_;
        }
        return null;
    }
}