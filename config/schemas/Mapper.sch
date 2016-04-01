package _mapper_package_;

import javax.inject.Inject;
import javax.inject.Singleton;
import _entity_package_._Entityname_Entity;
import _model_package_._Entityname;
import _app_package_name_.data.entity.mapper.DataCache;

@Singleton
public class _EntityName_EntityMapper extends EntryEntityMapper<_Entityname_,_Entityname_Entity> {

    @Inject
    public _Entityname_EntityMapper() {
        //Declarated default constructor for dagger
    }

    @Override
    public _EntityName_ transform(_Entityname_Entity entity) {
        if (entity != null) {
            _Entityname_ _entityname_ = new _Entityname_();
            _entityname_.setId(entity.getId()));

            return _entityname_;
        }
        return null;
    }
}

