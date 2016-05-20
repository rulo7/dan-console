package _app_package_name_._packagename_;

import android.content.Context;
import java.io.File;
import java.util.List;
import rx.Observable;
import javax.inject.Inject;
import javax.inject.Singleton;
import _app_package_name_._entity_package_._Entityname_Entity;
import _app_package_name_.data.cache.serializer.JsonSerializer;
import _app_package_name_.data.cache.DataCache;
import _app_package_name_.data.local.FileManager;
import _app_package_name_.data.exception.NotFoundException;
import _app_package_name_.domain.executor.ThreadExecutor;

@Singleton
public class _Entityname_Cache extends DataCache<_Entityname_Entity> {

    @Inject
    public _Entityname_Cache(Context context, FileManager fileManager, ThreadExecutor executor) {
        super(context, new JsonSerializer<>(_Entityname_Entity.class), fileManager, executor);
    }

    @Override
    public String getFilePrefixName() {
        return _Entityname_Entity.class.getSimpleName();
    }

    public Observable<_Entityname_Entity> get(int id) {
        return Observable.create(subscriber -> {
            File file = _Entityname_Cache.this.buildFile();
            String fileContent = _Entityname_Cache.this.fileManager.readFileContent(file);
            List<_Entityname_Entity> entities = _Entityname_Cache.this.serializer.deserializeList(fileContent);
            if (entities != null) {
                for (_Entityname_Entity _entityname_Entity : entities) {
                    if (_entityname_Entity.getId() == id) {
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