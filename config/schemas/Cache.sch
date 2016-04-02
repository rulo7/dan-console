package _packagename_;

import android.content.Context;
import java.io.File;
import java.util.List;
import javax.inject.Inject;
import javax.inject.Singleton;
import rx.Observable;
import javax.inject.Inject;
import javax.inject.Singleton;
import _entity_package_._Entityname_;
import _app_package_name_.data.cache.serializer.JsonSerializer;
import _app_package_name_.data.cache.DataCache;
import _app_package_name_.data.cache.FileManager;
import _app_package_name_.data.exception.NotFoundException;
import _app_package_name_.domain.executor.ThreadExecutor;

@Singleton
public class _Entityname_Cache extends DataCache<_Entityname_Entity> {

    @Inject
    public _Entityname_Cache(Context context, FileManager fileManager, ThreadExecutor executor) {
        super(context, new JsonSerializer<>(NotaPrensaEntity.class), fileManager, executor);
    }

    @Override
    public String getFilePrefixName() {
        return _Entityname_Entity.class.getSimpleName();
    }

    public Observable<_entitname_Entity> get(int id) {
        return Observable.create(subscriber -> {
            File _entityname_EntityFile = _Entityname_Cache.this.buildFile();
            String fileContent = _Entityname_Cache.this.fileManager.readFileContent(_entityname_File);
            List<NotaPrensaEntity> entities = NotaPrensaCache.this.serializer.deserializeList(fileContent);
            if (entities != null) {
                for (_Entityname_Entity _entityname_Entity : entities) {
                    if (_entityname_Entity.getId()) == id) {
                        subscriber.onNext(_entityname_Entity);
                        subscriber.onCompleted();
                        return;
                    }
                }
            }
            subscriber.onError(new NotFoundException());
        });
    }
}